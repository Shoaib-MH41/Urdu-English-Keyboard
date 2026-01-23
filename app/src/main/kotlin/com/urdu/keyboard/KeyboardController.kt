package com.urdu.keyboard

class KeyboardController(private val service: UrduInputService) {
    fun handleInput(text: String) {
        if (text == "Switch") {
            service.onLanguageChange()
        } else {
            // اب سروس کے اندر یہ فنکشن موجود ہے
            service.sendKey(text)
        }
    }
}
