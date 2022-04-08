import 'package:fl_plugin/filter_type.dart';
import 'package:flutter/material.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/services.dart';
import 'package:flutter/rendering.dart';

/// Compose Player Activity
class FLPluginView extends StatelessWidget {
  const FLPluginView(
      {Key? key,
      required this.videoUrl,
      required this.filterType,
      required this.filterProgress})
      : super(key: key);
  final String videoUrl;
  final FilterType filterType;
  final int filterProgress;

  @override
  Widget build(BuildContext context) {
    const String viewType = 'com.example.fl_plugin/player_activity';
    final Map<String, dynamic> creationParams = <String, dynamic>{
      "position": filterType.index,
      "videoUrl" : videoUrl,
      "filterProgress" : filterProgress
    };
    switch (defaultTargetPlatform) {
      case TargetPlatform.android:
        return PlatformViewLink(
            surfaceFactory: (context, controller) {
              return AndroidViewSurface(
                  controller: controller as AndroidViewController,
                  hitTestBehavior: PlatformViewHitTestBehavior.opaque,
                  gestureRecognizers: const <
                      Factory<OneSequenceGestureRecognizer>>{});
            },
            onCreatePlatformView: (PlatformViewCreationParams params) {
              return PlatformViewsService.initSurfaceAndroidView(
                  id: params.id,
                  viewType: viewType,
                  layoutDirection: TextDirection.ltr,
                  creationParams: creationParams,
                  creationParamsCodec: const StandardMessageCodec())
                ..addOnPlatformViewCreatedListener(params.onPlatformViewCreated)
                ..create();
            },
            viewType: viewType);
      case TargetPlatform.iOS:
        return UiKitView(
          viewType: viewType,
          layoutDirection: TextDirection.ltr,
          creationParams: creationParams,
          creationParamsCodec: const StandardMessageCodec(),
        );
      default:
        throw UnsupportedError("Unsupported platform view");
    }
  }

}
