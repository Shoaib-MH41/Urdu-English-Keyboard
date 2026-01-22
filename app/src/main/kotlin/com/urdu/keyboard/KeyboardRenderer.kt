package com.urdu.keyboard

import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout
import com.urdu.keyboard.R

class KeyboardRenderer(private val context: Context, private val service: UrduInputService) {

    fun createRow(chars: List<String>): LinearLayout {
        val row = LinearLayout(context).apply {
            layoutParams = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 
                0, 1.0f
            )
            orientation = LinearLayout.HORIZONTAL
        }

        for (char in chars) {
            val key = LayoutInflater.from(context).inflate(R.layout.key_item, row, false) as Button
            key.text = char
            key.setOnClickListener {
                if (char == "🌐") {
                    service.onLanguageChange()
                } else {
                    service.sendKey(char)
                }
            }
            row.addView(key)
        }
        return row
    }
}
