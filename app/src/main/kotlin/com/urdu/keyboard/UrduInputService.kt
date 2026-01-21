package com.urdu.keyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.widget.LinearLayout

class UrduInputService : InputMethodService() {

    private lateinit var mainLayout: LinearLayout

    override fun onCreateInputView(): View {
        mainLayout = layoutInflater.inflate(R.layout.keyboard_main, null) as LinearLayout
        renderKeyboard()
        return mainLayout
    }

    fun renderKeyboard() {
        // یہاں ہم پرانے بٹن صاف کر کے نئے حروف لوڈ کریں گے
        val rows = if (KeyboardState.currentLanguage == KeyboardLanguage.URDU) 
            KeyboardLogic.urduRows else KeyboardLogic.englishRows
        
        // بٹن بنانے اور لے آؤٹ میں شامل کرنے کا لاجک یہاں آئے گا
    }
    
    fun onLanguageChange() {
        KeyboardState.toggleLanguage()
        renderKeyboard() // زبان بدلتے ہی کی بورڈ ری فریش ہو جائے گا
    }
}
