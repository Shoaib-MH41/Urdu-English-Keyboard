import 'package:flutter/material.dart';
import 'package:flutter/services.dart';

void main() {
  WidgetsFlutterBinding.ensureInitialized();
  runApp(const KeyboardApp());
}

class KeyboardApp extends StatelessWidget {
  const KeyboardApp({super.key});

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
  static const MethodChannel _channel =
      MethodChannel('urdu_english_keyboard');

  bool isUrdu = true;

  final List<String> urduKeys = [
    'ا','ب','ت','ث','ج','ح','خ',
    'د','ر','ز','س','ش','ص',
    'ط','ع','ف','ق','ک','ل',
    'م','ن','و','ہ','ی'
  ];

  final List<String> englishKeys = [
    'q','w','e','r','t','y','u',
    'i','o','p','a','s','d',
    'f','g','h','j','k','l',
    'z','x','c','v','b','n','m'
  ];

  void _sendText(String text) {
    _channel.invokeMethod('sendText', {'text': text});
  }

  void _backspace() {
    _channel.invokeMethod('backspace');
  }

  @override
  Widget build(BuildContext context) {
    final keys = isUrdu ? urduKeys : englishKeys;

    return Scaffold(
      backgroundColor: const Color(0xFF111111),
      body: SafeArea(
        child: Column(
          children: [
            // Top bar
            Container(
              height: 45,
              padding: const EdgeInsets.symmetric(horizontal: 12),
              color: Colors.black,
              child: Row(
                children: [
                  Text(
                    isUrdu ? 'Urdu' : 'English',
                    style: const TextStyle(color: Colors.white),
                  ),
                  const Spacer(),
                  IconButton(
                    icon: const Icon(Icons.language, color: Colors.white),
                    onPressed: () {
                      setState(() {
                        isUrdu = !isUrdu;
                      });
                    },
                  ),
                  IconButton(
                    icon: const Icon(Icons.backspace, color: Colors.white),
                    onPressed: _backspace,
                  ),
                ],
              ),
            ),

            // Keys
            Expanded(
              child: GridView.builder(
                padding: const EdgeInsets.all(6),
                gridDelegate:
                    const SliverGridDelegateWithFixedCrossAxisCount(
                  crossAxisCount: 7,
                  mainAxisSpacing: 6,
                  crossAxisSpacing: 6,
                ),
                itemCount: keys.length,
                itemBuilder: (context, index) {
                  return GestureDetector(
                    onTap: () => _sendText(keys[index]),
                    child: Container(
                      alignment: Alignment.center,
                      decoration: BoxDecoration(
                        color: const Color(0xFF1E1E1E),
                        borderRadius: BorderRadius.circular(8),
                      ),
                      child: Text(
                        keys[index],
                        style: const TextStyle(
                          fontSize: 20,
                          color: Colors.white,
                        ),
                      ),
                    ),
                  );
                },
              ),
            ),
          ],
        ),
      ),
    );
  }
}
