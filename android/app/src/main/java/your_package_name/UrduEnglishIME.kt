package your.package.name.com.shoaib.urdu_english_keyboard

import android.inputmethodservice.InputMethodService
import android.view.View
import android.view.inputmethod.InputConnection
import io.flutter.embedding.android.FlutterView
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel

class UrduEnglishIME : InputMethodService() {

    private lateinit var flutterView: FlutterView
    private lateinit var flutterEngine: FlutterEngine
    private val CHANNEL = "urdu_english_keyboard"

    override fun onCreateInputView(): View {

        flutterEngine = FlutterEngine(this)
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        flutterView = FlutterView(this)
        flutterView.attachToFlutterEngine(flutterEngine)

        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            CHANNEL
        ).setMethodCallHandler { call, result ->

            when (call.method) {
                "sendText" -> {
                    val text = call.argument<String>("text") ?: ""
                    currentInputConnection?.commitText(text, 1)
                    result.success(null)
                }

                "backspace" -> {
                    currentInputConnection?.deleteSurroundingText(1, 0)
                    result.success(null)
                }

                else -> result.notImplemented()
            }
        }

        return flutterView
    }
}
