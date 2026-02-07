package com.urdu.keyboard

import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity // 👈 AppCompatActivity استعمال کریں
import android.graphics.Color // 👈 کلر سیٹ کرنے کے لیے

class SettingsActivity : AppCompatActivity() { // 👈 یہاں تبدیلی کی ہے

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(60, 60, 60, 60)
            // آپ کے کلرز فائل سے بیک گراؤنڈ
            setBackgroundColor(Color.parseColor("#1A1A1B")) 
        }

        val title = TextView(this).apply {
            text = "شاندار اردو کی بورڈ"
            textSize = 26f
            setTextColor(Color.WHITE) // 👈 سفید رنگ تاکہ ڈارک تھیم پر نظر آئے
            textStyle = android.graphics.Typeface.BOLD
            gravity = Gravity.CENTER
        }

        val desc = TextView(this).apply {
            text = "کی بورڈ فعال کرنے کے لیے:\n\nSettings → Languages & Input → Keyboards → Urdu Keyboard"
            textSize = 18f
            setTextColor(Color.parseColor("#CCCCCC")) // 👈 ہلکا سفید/سرمئی رنگ
            gravity = Gravity.CENTER
            setPadding(0, 40, 0, 0)
        }

        layout.addView(title)
        layout.addView(desc)
        setContentView(layout)
    }
}
