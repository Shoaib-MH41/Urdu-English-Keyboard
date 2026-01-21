import 'keyboard_state.dart';

class KeyboardController {
  final KeyboardState _state = KeyboardState();
  String _text = "";

  KeyboardState get state => _state;
  String get text => _text;

  void onLanguageSwitch() {
    _state.toggleLanguage();
  }

  void onKeyPressed(String key) {
    _text += key;
  }

  void onSpace() {
    _text += " ";
  }

  void onBackspace() {
    if (_text.isNotEmpty) {
      _text = _text.substring(0, _text.length - 1);
    }
  }

  void clear() {
    _text = "";
  }
}
