import 'package:flutter/material.dart';
import '../key_widget.dart';

class UrduKeyboard extends StatelessWidget {
  final Function(String) onKeyTap;
  final VoidCallback onBackspace;
  final VoidCallback onSpace;
  final VoidCallback onGlobePressed;

  const UrduKeyboard({
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
        _row(["ق","و","ع","ر","ت","ے","ء","ی","ہ"]),
        _row(["ا","س","د","ف","گ","ح","ج","ک","ل"]),
        _row(["ز","ش","چ","ط","ب","ن","م"]),
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
