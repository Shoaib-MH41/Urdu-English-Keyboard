package com.urdu.keyboard

// تمام ممکنہ موڈز (زبانیں اور دیگر)
enum class KeyboardMode {
    URDU, ENGLISH, SYMBOLS, EMOJI
}

object KeyboardState {
    // ڈیفالٹ موڈ اردو رکھیں
    var currentMode = KeyboardMode.URDU
    
    // زبان تبدیل کرنے کے لیے (اردو <-> انگلش)
    fun toggleLanguage() {
        currentMode = if (currentMode == KeyboardMode.URDU) 
            KeyboardMode.ENGLISH else KeyboardMode.URDU
    }

    // مخصوص موڈ سیٹ کرنے کے لیے (مثلاً ایموجی یا سمبلز)
    fun setMode(mode: KeyboardMode) {
        currentMode = mode
    }
}
