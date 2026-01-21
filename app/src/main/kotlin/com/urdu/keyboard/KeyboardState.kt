package com.urdu.keyboard

enum class KeyboardLanguage {
    URDU, ENGLISH
}

object KeyboardState {
    var currentLanguage = KeyboardLanguage.URDU
    
    fun toggleLanguage() {
        currentLanguage = if (currentLanguage == KeyboardLanguage.URDU) 
            KeyboardLanguage.ENGLISH else KeyboardLanguage.URDU
    }
}
