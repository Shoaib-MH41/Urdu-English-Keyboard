package com.urdu.keyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.view.inputmethod.EditorInfo

class UrduInputService : InputMethodService() {

    override fun onCreateInputView(): View {
        // اپنا ڈیزائن لوڈ کریں
        val keyboardView = layoutInflater.inflate(R.layout.keyboard_main, null)
        return keyboardView
    }

    // حروف ٹائپ کرنے کا فنکشن
    fun sendKey(char: String) {
        val ic = currentInputConnection
        ic?.commitText(char, 1)
    }

    // بیک اسپیس کے لیے
    fun deleteChar() {
        val ic = currentInputConnection
        ic?.deleteSurroundingText(1, 0)
    }
}
