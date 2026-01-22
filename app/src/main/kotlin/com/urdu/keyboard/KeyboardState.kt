package com.urdu.keyboard

enum class KeyboardMode {
    URDU, ENGLISH, SYMBOLS, EMOJI
}

object KeyboardState {
    var currentMode = KeyboardMode.URDU
    
    fun setMode(mode: KeyboardMode) {
        currentMode = mode
    }
}
