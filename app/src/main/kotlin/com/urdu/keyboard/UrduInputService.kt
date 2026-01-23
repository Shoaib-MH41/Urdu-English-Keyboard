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
        // اب KeyboardState اور KeyboardLanguage دستیاب ہیں
        val rows = if (KeyboardState.currentLanguage == KeyboardLanguage.URDU) 
            KeyboardLogic.urduRows else KeyboardLogic.englishRows
        
        // یہاں آپ کا بٹن بنانے کا لاجک آئے گا
    }
    
    fun onLanguageChange() {
        KeyboardState.toggleLanguage()
        renderKeyboard()
    }

    // یہ فنکشن KeyboardController کے لیے ضروری ہے
    fun sendKey(text: String) {
        val ic = currentInputConnection
        ic?.commitText(text, 1)
    }
}
