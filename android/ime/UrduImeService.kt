package your.package.ime

import android.inputmethodservice.InputMethodService
import android.view.View
import android.widget.LinearLayout

class UrduImeService : InputMethodService() {

    override fun onCreateInputView(): View {
        // For now empty native view
        return LinearLayout(this)
    }

    override fun onStartInputView(info: android.view.inputmethod.EditorInfo?, restarting: Boolean) {
        super.onStartInputView(info, restarting)
    }
}
