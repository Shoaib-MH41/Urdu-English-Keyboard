package com.urdu.keyboard

object KeyboardLogic {

    // 🔢 Numbers Row
    val numberRow = listOf("1","2","3","4","5","6","7","8","9","0")

    // 🇵🇰 اردو کی بورڈ
    val urduRows = listOf(
        numberRow,
        listOf("ق","و","ع","ر","ت","ے","ی","پ","ا","ل"),
        listOf("س","د","ف","گ","ھ","ج","ک","ط","ظ"),
        listOf("ٹ","ڈ","ڑ","ب","ن","م","⌫"),
        listOf("🌐", "Space", "Enter") // 👈 نئی قطار جس میں اسپیس اور انٹر شامل ہے
    )

    // 🇬🇧 English Keyboard
    val englishRows = listOf(
        numberRow,
        listOf("q","w","e","r","t","y","u","i","o","p"),
        listOf("a","s","d","f","g","h","j","k","l"),
        listOf("z","x","c","v","b","n","m","⌫"),
        listOf("🌐", "Space", "Enter") // 👈 انگریزی کے لیے بھی اسپیس اور انٹر
    )

    // 🔣 Symbols
    val symbolRows = listOf(
        listOf("!","@","#","$","%","^","&","*","(",")"),
        listOf("_","+","=","-","/","?",":",";"),
        listOf("ABC", "Space", "⌫") 
    )
}
