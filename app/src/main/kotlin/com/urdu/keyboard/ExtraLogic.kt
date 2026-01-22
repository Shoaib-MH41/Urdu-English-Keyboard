package com.urdu.keyboard

object ExtraLogic {

    // 🔣 عام Symbols (نمبر کے بغیر)
    val symbolRows = listOf(
        listOf("@", "#", "%", "$", "€", "£", "&", "*"),
        listOf("+", "=", "/", "-", "_", ":", ";"),
        listOf("(", ")", "!", "?", "«", "»", "⌫")
    )

    // 🕌 اردو و اسلامی علامات (حسنِ گفتار)
    val urduExtraRows = listOf(
        listOf("﷽", "ﷺ", "ؐ", "ؑ", "ؒ", "ؓ"),
        listOf("ؔ", "ؕ", "۞", "۩", "۝", "ۖ"),
        listOf("،", "۔", "؛", "؟", "٪", "⌫")
    )

    // 😀 Emojis & Stickers (basic set)
    val emojiRows = listOf(
        listOf("😊", "😂", "❤️", "👍", "🙏", "✨"),
        listOf("🔥", "😢", "😡", "😍", "🤲", "🌸"),
        listOf("ABC", "⌫")
    )
}
