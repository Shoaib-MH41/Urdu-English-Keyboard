package your.package.name

import android.inputmethodservice.InputMethodService
import android.view.View
import android.view.inputmethod.InputConnection

class UrduEnglishIME : InputMethodService() {

    private lateinit var keyboardView: View
    private var isUrdu = true

    override fun onCreateInputView(): View {
        keyboardView = layoutInflater.inflate(
            R.layout.keyboard_view,
            null
        )
        return keyboardView
    }

    fun sendText(text: String) {
        val ic: InputConnection? = currentInputConnection
        ic?.commitText(text, 1)
    }

    fun backspace() {
        currentInputConnection?.deleteSurroundingText(1, 0)
    }

    fun switchLanguage() {
        isUrdu = !isUrdu
    }
}
