package com.urdu.keyboard

class KeyboardController(private val service: UrduInputService) {
    fun handleInput(text: String) {
        if (text == "Switch") {
            service.onLanguageChange()
        } else {
            service.sendKey(text)
        }
    }
}
