#import "FlPlugin.h"
#if __has_include(<fl_plugin/fl_plugin-Swift.h>)
#import <fl_plugin/fl_plugin-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "fl_plugin-Swift.h"
#endif

@implementation FlPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftFlPlugin registerWithRegistrar:registrar];
}
@end
