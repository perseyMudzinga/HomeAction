import 'dart:async';

import 'package:flutter/services.dart';

class HomeAction {
  static const MethodChannel _channel =
      const MethodChannel('home_action');

  static Future<Null> pop () async {
    await _channel.invokeMethod('pop');
    return null;
  }
}
