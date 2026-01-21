import 'package:flutter/material.dart';
import 'keyboard/keyboard_controller.dart';
import 'keyboard/keyboard_state.dart';
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
      debugShowCheckedModeBanner: false,
      home: KeyboardScreen(),
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
          const SizedBox(height: 60),

          /// 🔹 typing area
          Padding(
            padding: const EdgeInsets.all(16),
            child: Container(
              width: double.infinity,
              padding: const EdgeInsets.all(12),
              decoration: BoxDecoration(
                border: Border.all(color: Colors.grey),
                borderRadius: BorderRadius.circular(8),
              ),
              child: Text(
                controller.text,
                style: const TextStyle(fontSize: 18),
              ),
            ),
          ),

          const Spacer(),

          /// 🔹 keyboard
          _buildKeyboard(),
        ],
      ),
    );
  }

  Widget _buildKeyboard() {
    if (controller.state.language == KeyboardLanguage.urdu) {
      return UrduKeyboard(
        onKeyTap: _onKeyTap,
        onBackspace: _onBackspace,
        onSpace: _onSpace,
        onGlobePressed: _onGlobePressed,
      );
    } else {
      return EnglishKeyboard(
        onKeyTap: _onKeyTap,
        onBackspace: _onBackspace,
        onSpace: _onSpace,
        onGlobePressed: _onGlobePressed,
      );
    }
  }

  void _onKeyTap(String key) {
    controller.onKeyPressed(key);
    setState(() {});
  }

  void _onSpace() {
    controller.onSpace();
    setState(() {});
  }

  void _onBackspace() {
    controller.onBackspace();
    setState(() {});
  }

  void _onGlobePressed() {
    controller.onLanguageSwitch();
    setState(() {});
  }
}
