package com.urdu.keyboard

import android.view.inputmethod.InputConnection

class InputHandler(private val ic: InputConnection?) {

    fun handleText(text: String) {
        ic?.commitText(text, 1)
    }

    fun handleBackspace() {
        // اگر کرسر کے پیچھے کچھ ہے تو اسے مٹائیں
        ic?.deleteSurroundingText(1, 0)
    }

    fun handleSpace() {
        ic?.commitText(" ", 1)
    }

    fun handleEnter() {
        ic?.sendKeyEvent(android.view.KeyEvent(android.view.KeyEvent.ACTION_DOWN, android.view.KeyEvent.KEYCODE_ENTER))
    }
}
