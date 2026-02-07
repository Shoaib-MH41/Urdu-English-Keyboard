package com.urdu.keyboard

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.Gravity
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.graphics.Color
import android.graphics.Typeface

class SettingsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // مرکزی لے آؤٹ
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(60, 60, 60, 60)
            setBackgroundColor(Color.parseColor("#1A1A1B")) // آپ کا kb_background
        }

        // عنوان
        val title = TextView(this).apply {
            text = "شاندار اردو کی بورڈ"
            textSize = 28f
            setTextColor(Color.WHITE)
            typeface = Typeface.DEFAULT_BOLD
            gravity = Gravity.CENTER
        }

        // ہدایات
        val desc = TextView(this).apply {
            text = "نیچے والا بٹن دبا کر 'شاندار اردو کی بورڈ' کو آن کریں"
            textSize = 16f
            setTextColor(Color.parseColor("#CCCCCC"))
            gravity = Gravity.CENTER
            setPadding(0, 40, 0, 60)
        }

        // فعال کرنے والا بٹن
        val enableButton = Button(this).apply {
            text = "کی بورڈ فعال کریں"
            setBackgroundColor(Color.parseColor("#00ADB5")) // آپ کا accent_color
            setTextColor(Color.WHITE)
            setPadding(40, 20, 40, 20)
            
            setOnClickListener {
                // یہ لائن صارف کو سسٹم کی کی بورڈ سیٹنگز میں لے جائے گی
                val intent = Intent(Settings.ACTION_INPUT_METHOD_SETTINGS)
                startActivity(intent)
            }
        }

        layout.addView(title)
        layout.addView(desc)
        layout.addView(enableButton)

        setContentView(layout)
    }
}
