import 'package:flutter/material.dart';
import '../key_widget.dart';

class EnglishKeyboard extends StatelessWidget {
  final Function(String) onKeyTap;
  final VoidCallback onBackspace;
  final VoidCallback onSpace;
  final VoidCallback onGlobePressed;

  const EnglishKeyboard({
    super.key,
    required this.onKeyTap,
    required this.onBackspace,
    required this.onSpace,
    required this.onGlobePressed,
  });

  @override
  Widget build(BuildContext context) {
    return Column(
      mainAxisSize: MainAxisSize.min,
      children: [
        _row(["q","w","e","r","t","y","u","i","o","p"]),
        _row(["a","s","d","f","g","h","j","k","l"]),
        _row(["z","x","c","v","b","n","m"]),
        Row(
          children: [
            KeyWidget(label: "🌐", onTap: onGlobePressed, flex: 1.5),
            KeyWidget(label: "space", onTap: onSpace, flex: 4),
            KeyWidget(label: "⌫", onTap: onBackspace, flex: 1.5),
          ],
        ),
      ],
    );
  }

  Widget _row(List<String> keys) {
    return Row(
      children: keys
          .map((k) => KeyWidget(label: k, onTap: () => onKeyTap(k)))
          .toList(),
    );
  }
}
