package com.urdu.keyboard

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.Gravity
import android.widget.LinearLayout

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // سیٹنگز کے لیے ایک سادہ لے آؤٹ
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(50, 50, 50, 50)
        }

        val title = TextView(this).apply {
            text = "شاندار اردو کی بورڈ سیٹنگز"
            textSize = 24f
            gravity = Gravity.CENTER
        }

        val description = TextView(this).apply {
            text = "یہاں آپ کی بورڈ کی تھیم اور دیگر سیٹنگز بدل سکیں گے۔ ابھی یہ فیچر تیاری کے مراحل میں ہے۔"
            textSize = 16f
            gravity = Gravity.CENTER
            setPadding(0, 40, 0, 0)
        }

        layout.addView(title)
        layout.addView(description)
        setContentView(layout)
    }
}
