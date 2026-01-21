enum KeyboardLanguage {
  urdu,
  english,
}

class KeyboardState {
  KeyboardLanguage language;
  bool isShiftOn;

  KeyboardState({
    this.language = KeyboardLanguage.english,
    this.isShiftOn = false,
  });

  void toggleLanguage() {
    language =
        language == KeyboardLanguage.urdu ? KeyboardLanguage.english : KeyboardLanguage.urdu;
  }
}
