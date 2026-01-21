enum KeyboardLanguage {
  urdu,
  english,
}

class KeyboardState {
  KeyboardLanguage language;
  bool isShiftOn;

  KeyboardState({
    this.language = KeyboardLanguage.urdu,
    this.isShiftOn = false,
  });

  void toggleLanguage() {
    language = language == KeyboardLanguage.urdu
        ? KeyboardLanguage.english
        : KeyboardLanguage.urdu;
  }

  void toggleShift() {
    isShiftOn = !isShiftOn;
  }
}
