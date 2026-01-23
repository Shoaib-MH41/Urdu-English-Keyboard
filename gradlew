#!/usr/bin/env bash

# جار فائل کا راستہ
JAR_PATH="./gradle/wrapper/gradle-wrapper.jar"

# اگر جاوا موجود ہے تو جار فائل کو چلاؤ
if [ -f "$JAR_PATH" ]; then
    java -jar "$JAR_PATH" "$@"
else
    # اگر جار فائل نہیں ملتی تو سسٹم کا گریڈل استعمال کرو
    gradle "$@"
fi
