
import 'dart:async';

import 'package:flutter/services.dart';

class FlPlugin {
  static const MethodChannel _channel = MethodChannel('fl_plugin');

  static Future<String?> get platformVersion async {
    final String? version = await _channel.invokeMethod('getPlatformVersion',{"position":5});
    return version;
  }
}
