package com.urdu.keyboard

// زبان کی اقسام
enum class KeyboardLanguage { URDU, ENGLISH }

// کی بورڈ کی موجودہ حالت کو سنبھالنے کے لیے
object KeyboardState {
    var currentLanguage = KeyboardLanguage.URDU

    fun toggleLanguage() {
        currentLanguage = if (currentLanguage == KeyboardLanguage.URDU) 
            KeyboardLanguage.ENGLISH else KeyboardLanguage.URDU
    }
}
