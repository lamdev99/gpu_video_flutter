import 'package:flutter/material.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/gestures.dart';
import 'package:flutter/services.dart';
import 'package:flutter/rendering.dart';
class PortrateCameraView extends StatelessWidget {
  const PortrateCameraView({Key? key}) : super(key: key);

  @override
  Widget build(BuildContext context) {
    const String viewType = 'com.example.fl_plugin/portrate_camera_activity';
    final Map<String, dynamic> creationParams = <String, dynamic>{};
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
