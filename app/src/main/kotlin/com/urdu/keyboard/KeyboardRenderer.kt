package com.urdu.keyboard

import android.content.Context
import android.view.LayoutInflater
import android.view.View
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
            
            // بٹن کے کام کرنے کی منطق (Logic)
            key.setOnClickListener {
                when (char) {
                    "🌐" -> service.onLanguageChange() // زبان بدلنا
                    "⌫" -> service.deleteChar()      // بیک اسپیس
                    "Space" -> service.sendKey(" ")   // اسپیس
                    "Enter" -> service.handleEnter()  // اگلی لائن
                    else -> service.sendKey(char)     // عام حروف (ا، ب، c، d)
                }
            }
            
            // اسپیس بار کو تھوڑا چوڑا دکھانے کے لیے (اگر ضرورت ہو)
            if (char == "Space") {
                val params = key.layoutParams as LinearLayout.LayoutParams
                params.weight = 3.0f // اسپیس بار کو 3 گنا جگہ دیں
                key.layoutParams = params
            }

            row.addView(key)
        }
        return row
    }
}
