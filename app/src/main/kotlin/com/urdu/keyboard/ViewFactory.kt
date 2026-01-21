package com.urdu.keyboard

import android.content.Context
import android.view.LayoutInflater
import android.widget.Button
import android.widget.LinearLayout

class ViewFactory(val context: Context) {
    fun createKey(label: String, onClick: (String) -> Unit): Button {
        val button = Button(context)
        button.text = label
        button.setOnClickListener { onClick(label) }
        // یہاں مزید ڈیزائن لاجک شامل کر سکتے ہیں
        return button
    }
}
