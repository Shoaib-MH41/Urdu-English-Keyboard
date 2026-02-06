package com.urdu.keyboard

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView

class SettingsActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(40, 40, 40, 40)
        }

        val title = TextView(this).apply {
            text = "شاندار اردو کی بورڈ"
            textSize = 22f
            gravity = Gravity.CENTER
        }

        val desc = TextView(this).apply {
            text = "کی بورڈ فعال کرنے کے لیے:\n\nSettings → Languages & Input → Keyboards → Urdu Keyboard"
            textSize = 16f
            gravity = Gravity.CENTER
            setPadding(0, 30, 0, 0)
        }

        layout.addView(title)
        layout.addView(desc)
        setContentView(layout)
    }
}
