package your.package.name.
com.urdu_english_keyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.widget.Button

class UrduEnglishIME : InputMethodService() {

    private var isUrdu = true

    override fun onCreateInputView(): View {
        val view = layoutInflater.inflate(
            R.layout.keyboard_view,
            null
        )

        val keyA = view.findViewById<Button>(R.id.keyA)
        val keyB = view.findViewById<Button>(R.id.keyB)
        val keyLang = view.findViewById<Button>(R.id.keyLang)

        keyA.setOnClickListener {
            sendText(if (isUrdu) "ا" else "a")
        }

        keyB.setOnClickListener {
            sendText(if (isUrdu) "ب" else "b")
        }

        keyLang.setOnClickListener {
            isUrdu = !isUrdu
        }

        return view
    }

    private fun sendText(text: String) {
        currentInputConnection?.commitText(text, 1)
    }
}
