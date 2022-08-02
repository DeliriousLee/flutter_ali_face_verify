#import "AliFaceVertifyPlugin.h"
#import <AliyunIdentityManager/AliyunIdentityPublicApi.h>
@implementation AliFaceVertifyPlugin
static AliFaceVertifyCallBack * _completion;

+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  FlutterMethodChannel* channel = [FlutterMethodChannel
      methodChannelWithName:@"ali_face_vertify"
            binaryMessenger:[registrar messenger]];
  AliFaceVertifyPlugin* instance = [[AliFaceVertifyPlugin alloc] init];
    AliFaceVertifyManagerSetup([registrar messenger], instance);
  _completion = [[AliFaceVertifyCallBack alloc] initWithBinaryMessenger:[registrar messenger]];
  [registrar addMethodCallDelegate:instance channel:channel];
}

- (void)handleMethodCall:(FlutterMethodCall*)call result:(FlutterResult)result {
  if ([@"getPlatformVersion" isEqualToString:call.method]) {
    result([@"iOS " stringByAppendingString:[[UIDevice currentDevice] systemVersion]]);
  } else {
    result(FlutterMethodNotImplemented);
  }
}
- (nullable NSDictionary *)getMetaInfoWithError:(FlutterError * _Nullable __autoreleasing * _Nonnull)error {
    return [AliyunIdentityManager getMetaInfo];
}

- (void)initWithError:(FlutterError * _Nullable __autoreleasing * _Nonnull)error {
    [AliyunSdk init];
}

- (void)openFaceCertifyCertifyId:(nonnull NSString *)certifyId error:(FlutterError * _Nullable __autoreleasing * _Nonnull)error {
    NSLog(@"打开人脸认证");
    
    UIViewController * controller = [[[UIApplication sharedApplication] keyWindow] rootViewController];
    NSDictionary * params = @{@"currentCtr":controller};
    [[AliyunIdentityManager sharedInstance] verifyWith:certifyId extParams:params onCompletion:^(ZIMResponse *response) {
        
        FaceVerResponse * rsp = [FaceVerResponse makeWithCode:[NSNumber numberWithInteger:response.code]  retCode:[NSNumber numberWithInteger:response.retCode]  reason:response.reason retCodeSub:response.retCodeSub retMessageSub:response.retMessageSub extInfo:response.extInfo bizData:response.bizData deviceToken:response.deviceToken videoFilePath:response.videoFilePath];
        [_completion certifyCompletionResponse:rsp completion:^(NSError * _Nullable error) {
            
        }];
        }];
}

@end
