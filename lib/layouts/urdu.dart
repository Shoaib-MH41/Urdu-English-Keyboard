import 'package:flutter/material.dart';
import '../key_widget.dart';

class UrduKeyboard extends StatelessWidget {
  final VoidCallback onGlobePressed;

  const UrduKeyboard({
    super.key,
    required this.onGlobePressed,
  });

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.grey.shade200,
      padding: const EdgeInsets.symmetric(vertical: 6),
      child: Column(
        mainAxisSize: MainAxisSize.min,
        children: [

          _row(["ق","و","ع","ر","ت","ے","ء","ی","ہ"]),
          _row(["ا","س","د","ف","گ","ح","ج","ک","ل"]),
          _row(["ز","ش","چ","ط","ب","ن","م"]),

          /// 🔹 bottom row
          Row(
            children: [
              KeyWidget(label: "🌐", onTap: onGlobePressed, flex: 1.5),
              KeyWidget(label: "space", onTap: () {}, flex: 4),
              KeyWidget(label: "⌫", onTap: () {}, flex: 1.5),
            ],
          ),
        ],
      ),
    );
  }

  Widget _row(List<String> keys) {
    return Row(
      children: keys
          .map((k) => KeyWidget(label: k, onTap: () {}))
          .toList(),
    );
  }
}
