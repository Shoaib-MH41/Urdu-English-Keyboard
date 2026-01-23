package com.urdu.keyboard

import android.inputmethodservice.InputMethodService
import android.view.KeyEvent
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
        mainLayout.removeAllViews()
        val renderer = KeyboardRenderer(this, this)
        
        // یہاں ہم نے نام درست کر دیے ہیں تاکہ ایرر ختم ہو جائے
        val rows = if (KeyboardState.currentMode == KeyboardMode.URDU) 
            KeyboardLogic.urduRows else KeyboardLogic.englishRows
        
        for (rowChars in rows) {
            mainLayout.addView(renderer.createRow(rowChars))
        }
    }
    
    fun onLanguageChange() {
        // یہاں toggleLanguage کی جگہ اب setMode یا براہ راست لاجک استعمال کریں گے
        KeyboardState.currentMode = if (KeyboardState.currentMode == KeyboardMode.URDU) 
            KeyboardMode.ENGLISH else KeyboardMode.URDU
            
        renderKeyboard()
    }

    fun sendKey(text: String) {
        val ic = currentInputConnection
        ic?.commitText(text, 1)
    }

    fun deleteChar() {
        val ic = currentInputConnection
        ic?.deleteSurroundingText(1, 0)
    }

    fun handleEnter() {
        val ic = currentInputConnection
        ic?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER))
    }
}
