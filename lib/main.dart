import 'package:flutter/material.dart';
import 'keyboard_view.dart';

void main() {
  runApp(const KeyboardApp());
}

class KeyboardApp extends StatelessWidget {
  const KeyboardApp({super.key});

  @override
  Widget build(BuildContext context) {
    return const MaterialApp(
      debugShowCheckedModeBanner: false,
      home: Scaffold(
        backgroundColor: Colors.black,
        body: SafeArea(child: KeyboardView()),
      ),
    );
  }
}
