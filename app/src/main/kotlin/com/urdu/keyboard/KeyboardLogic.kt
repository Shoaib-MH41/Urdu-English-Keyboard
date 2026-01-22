package com.urdu.keyboard

object KeyboardLogic {
    val urduRows = listOf(
        listOf("ق", "و", "ع", "ر", "ت", "ے", "ی", "پ", "ا", "ل"),
        listOf("س", "د", "ف", "گ", "ھ", "ج", "ک", "ط", "ظ"),
        listOf("ٹ", "ڈ", "ڑ", "ب", "ن", "م", "🌐", "⌫") // 🌐 زبان بدلنے کے لیے، ⌫ مٹانے کے لیے
    )

    val englishRows = listOf(
        listOf("q", "w", "e", "r", "t", "y", "u", "i", "o", "p"),
        listOf("a", "s", "d", "f", "g", "h", "j", "k", "l"),
        listOf("z", "x", "c", "v", "b", "n", "m", "🌐", "⌫")
    )
}
