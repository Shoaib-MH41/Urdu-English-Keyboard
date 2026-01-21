package com.urdu.keyboard

object KeyboardLogic {
    // اردو حروف
    val urduRows = listOf(
        listOf("ق", "و", "ع", "ر", "ت", "ے", "ی", "پ", "ا", "ل"),
        listOf("س", "د", "ف", "گ", "ھ", "ج", "ک", "ل"),
        listOf("ز", "خ", "چ", "ب", "ن", "م")
    )

    // انگلش حروف (QWERTY)
    val englishRows = listOf(
        listOf("q", "w", "e", "r", "t", "y", "u", "i", "o", "p"),
        listOf("a", "s", "d", "f", "g", "h", "j", "k", "l"),
        listOf("z", "x", "c", "v", "b", "n", "m")
    )
}
