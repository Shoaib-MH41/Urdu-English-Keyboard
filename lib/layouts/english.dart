import 'package:flutter/material.dart';
import '../key_widget.dart';

class EnglishKeyboard extends StatelessWidget {
  final VoidCallback onGlobePressed;

  const EnglishKeyboard({
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

          _row(["q","w","e","r","t","y","u","i","o","p"]),
          _row(["a","s","d","f","g","h","j","k","l"]),
          _row(["z","x","c","v","b","n","m"]),

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
