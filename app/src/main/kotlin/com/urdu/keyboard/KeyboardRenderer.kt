package com.urdu.keyboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class KeyboardRenderer(private val context: Context, private val service: UrduInputService) {

    fun createRow(chars: List<String>): LinearLayout {
    val row = LinearLayout(context).apply {
        layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        orientation = LinearLayout.HORIZONTAL
    }

    for (char in chars) {
        val key = LayoutInflater.from(context)
            .inflate(R.layout.key_item, row, false) as Button

        key.text = char

        key.setOnClickListener {
            when (char) {
                "🌐" -> service.onLanguageChange()
                "⌫" -> service.deleteChar()
                "Space" -> service.sendKey(" ")
                "Enter" -> service.handleEnter()
                else -> service.sendKey(char)
            }
        }

        val params = LinearLayout.LayoutParams(
            0,
            LinearLayout.LayoutParams.MATCH_PARENT
        )

        params.weight = when (char) {
            "Space" -> 4f
            "Enter", "⌫" -> 1.5f
            else -> 1f
        }

        key.layoutParams = params
        row.addView(key)
    }
    return row
}
