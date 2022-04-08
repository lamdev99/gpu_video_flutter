package com.example.fl_plugin_example

import com.example.fl_plugin.NativeViewFactory
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class MainActivity : FlutterActivity() {
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        flutterEngine
            .platformViewsController
            .registry
            .registerViewFactory("com.example.fl_plugin/player_activity", NativeViewFactory())

    }
}
