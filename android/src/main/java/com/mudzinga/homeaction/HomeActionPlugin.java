package com.mudzinga.homeaction;

import android.app.Activity;
import android.content.Intent;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** HomeActionPlugin */
public class HomeActionPlugin implements MethodCallHandler {

  private final MethodChannel channel;
  private Activity activity;

  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "home_action");
    channel.setMethodCallHandler(new HomeActionPlugin(registrar.activity(), channel));
  }

  HomeActionPlugin(Activity activity, MethodChannel channel) {
    this.activity = activity;
    this.channel = channel;
    channel.setMethodCallHandler(this);
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("pop")) {
      Intent startMain = new Intent(Intent.ACTION_MAIN);
      startMain.addCategory(Intent.CATEGORY_HOME);
      startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      activity.startActivity(startMain);
    } else {
      result.notImplemented();
    }
  }
}
