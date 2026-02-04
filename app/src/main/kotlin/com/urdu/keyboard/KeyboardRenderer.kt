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
            0, 1.0f  
        )  
        orientation = LinearLayout.HORIZONTAL  
    }  

    for (char in chars) {  
        val key = LayoutInflater.from(context).inflate(R.layout.key_item, row, false) as Button  
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
          
        // بٹن کا سائز سیٹ کریں  
        val params = key.layoutParams as LinearLayout.LayoutParams  
        if (char == "Space") {  
            params.weight = 4.0f   
        } else if (char == "Enter" || char == "⌫") {  
            params.weight = 1.5f  
        } else {  
            params.weight = 1.0f  
        }  
        key.layoutParams = params  

        row.addView(key)  
    }  
    return row  
}

}
