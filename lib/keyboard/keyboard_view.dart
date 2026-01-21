import 'package:flutter/material.dart';
import 'key_widget.dart';
import 'layouts/urdu.dart';

class UrduKeyboardView extends StatelessWidget {
  const UrduKeyboardView({super.key});

  @override
  Widget build(BuildContext context) {
    return Column(
      children: [
        const Spacer(),

        // 🔒 SAFE BOTTOM GAP (اصل مسئلے کا حل)
        const SizedBox(height: 24),

        Container(
          padding: const EdgeInsets.symmetric(horizontal: 8, vertical: 6),
          decoration: BoxDecoration(
            color: Colors.grey.shade900,
            borderRadius: const BorderRadius.vertical(top: Radius.circular(16)),
          ),
          child: Column(
            children: urduLayout.map((row) {
              return Row(
                mainAxisAlignment: MainAxisAlignment.spaceEvenly,
                children: row.map((key) {
                  return KeyWidget(label: key);
                }).toList(),
              );
            }).toList(),
          ),
        ),
      ],
    );
  }
}
