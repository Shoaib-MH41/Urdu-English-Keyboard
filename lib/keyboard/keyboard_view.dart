import 'package:flutter/material.dart';
import 'key_widget.dart';
import 'layouts/urdu.dart';
import 'layouts/english.dart';

enum Lang { urdu, english }

class KeyboardView extends StatefulWidget {
  const KeyboardView({super.key});

  @override
  State<KeyboardView> createState() => _KeyboardViewState();
}

class _KeyboardViewState extends State<KeyboardView> {
  Lang current = Lang.urdu;

  @override
  Widget build(BuildContext context) {
    final layout = current == Lang.urdu ? urduLayout : englishLayout;

    return Column(
      mainAxisAlignment: MainAxisAlignment.end,
      children: [
        const SizedBox(height: 24), // 🔒 SAFE BOTTOM GAP

        Container(
          padding: const EdgeInsets.all(6),
          decoration: BoxDecoration(
            color: Colors.grey.shade900,
            borderRadius: const BorderRadius.vertical(top: Radius.circular(16)),
          ),
          child: Column(
            children: [
              for (var row in layout)
                Row(
                  children: [
                    for (var key in row)
                      KeyWidget(
                        label: key,
                        onTap: () => debugPrint(key),
                      ),
                  ],
                ),

              // 🔽 Bottom bar
              Row(
                children: [
                  KeyWidget(label: '123'),
                  KeyWidget(
                    label: '🌐',
                    onTap: () {
                      setState(() {
                        current =
                            current == Lang.urdu ? Lang.english : Lang.urdu;
                      });
                    },
                  ),
                  Expanded(
                    child: KeyWidget(
                      label: current == Lang.urdu ? 'اردو' : 'English',
                    ),
                  ),
                  KeyWidget(label: '⌫'),
                ],
              ),
            ],
          ),
        ),
      ],
    );
  }
}
