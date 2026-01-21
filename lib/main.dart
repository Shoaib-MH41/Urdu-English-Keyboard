import 'package:flutter/material.dart';
import 'keyboard/keyboard_controller.dart';
import 'layouts/urdu_layout.dart';
import 'layouts/english_layout.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      home: KeyboardScreen(),
      debugShowCheckedModeBanner: false,
    );
  }
}

class KeyboardScreen extends StatefulWidget {
  const KeyboardScreen({super.key});

  @override
  State<KeyboardScreen> createState() => _KeyboardScreenState();
}

class _KeyboardScreenState extends State<KeyboardScreen> {
  final KeyboardController controller = KeyboardController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Column(
        children: [

          /// 🔹 TEXT AREA (just for testing)
          const SizedBox(height: 80),
          const Text(
            "Typing Area",
            style: TextStyle(fontSize: 18),
          ),

          const Spacer(),

          /// 🔹 KEYBOARD AREA
          _buildKeyboard(),
        ],
      ),
    );
  }

  Widget _buildKeyboard() {
    /// 🔁 یہی وہ جگہ ہے جہاں language decide ہوتی ہے
    if (controller.state.language == KeyboardLanguage.urdu) {
      return UrduKeyboard(
        onGlobePressed: _onGlobePressed,
      );
    } else {
      return EnglishKeyboard(
        onGlobePressed: _onGlobePressed,
      );
    }
  }

  /// 🌐 Globe button handler
  void _onGlobePressed() {
    controller.onLanguageSwitch();   // LOGIC change
    setState(() {});                 // UI refresh
  }
}
