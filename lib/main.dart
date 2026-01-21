import 'package:flutter/material.dart';
import 'keyboard/keyboard_view.dart';

void main() {
  runApp(const UrduKeyboardApp());
}

class UrduKeyboardApp extends StatelessWidget {
  const UrduKeyboardApp({super.key});

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      debugShowCheckedModeBanner: false,
      theme: ThemeData.dark(),
      home: const Scaffold(
        backgroundColor: Colors.black,
        body: SafeArea(
          child: UrduKeyboardView(),
        ),
      ),
    );
  }
}
