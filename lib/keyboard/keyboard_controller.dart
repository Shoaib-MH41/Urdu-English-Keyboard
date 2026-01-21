import 'keyboard_state.dart';

class KeyboardController {
  final KeyboardState _state = KeyboardState();

  KeyboardState get state => _state;

  /// 🌐 Globe button
  void onLanguageSwitch() {
    _state.toggleLanguage();
  }

  /// ⇧ Shift key
  void onShiftPressed() {
    _state.toggleShift();
  }

  /// Key press handler
  String onKeyPressed(String key) {
    if (_state.language == KeyboardLanguage.english) {
      return _state.isShiftOn ? key.toUpperCase() : key.toLowerCase();
    }

    // Urdu layout keys already mapped
    return key;
  }
}
