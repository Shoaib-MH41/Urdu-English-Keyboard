package your.package.ime

interface KeyboardAction {
    fun onKeyPress(text: String)
    fun onBackspace()
}
