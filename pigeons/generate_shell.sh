flutter pub run pigeon \
--input pigeons/ali_face_vertify_message.dart \
--dart_out lib/ali_face_message.dart \
--objc_header_out ios/Classes/AliFaceVertifyManager.h \
--objc_source_out ios/Classes/AliFaceVertifyManager.m \
--java_out android/src/main/java/com/example/ali_face_vertify/AliFaceVertifyManager.java \
--java_package 'io.flutter.plugins'
