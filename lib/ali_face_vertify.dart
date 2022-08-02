
import 'dart:async';

import 'package:flutter/services.dart';

class AliFaceVertify {
  static const MethodChannel _channel = MethodChannel('ali_face_vertify');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }
}
