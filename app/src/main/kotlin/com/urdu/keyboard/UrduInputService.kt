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
        // کی بورڈ کو ری فریش کرنے سے پہلے پرانے بٹن صاف کریں
        mainLayout.removeAllViews()

        val renderer = KeyboardRenderer(this, this)
        val rows = if (KeyboardState.currentLanguage == KeyboardLanguage.URDU) 
            KeyboardLogic.urduRows else KeyboardLogic.englishRows
        
        // ہر رو (Row) کو مین لے آؤٹ میں شامل کریں
        for (rowChars in rows) {
            mainLayout.addView(renderer.createRow(rowChars))
        }
    }
    
    fun onLanguageChange() {
        KeyboardState.toggleLanguage()
        renderKeyboard()
    }

    // حروف ٹائپ کرنے کے لیے
    fun sendKey(text: String) {
        val ic = currentInputConnection
        ic?.commitText(text, 1)
    }

    // بیک اسپیس کے لیے (یہ فنکشن غائب تھا)
    fun deleteChar() {
        val ic = currentInputConnection
        ic?.deleteSurroundingText(1, 0)
    }

    // انٹر بٹن کے لیے (یہ فنکشن بھی غائب تھا)
    fun handleEnter() {
        val ic = currentInputConnection
        ic?.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER))
    }
}
