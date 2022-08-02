#
# To learn more about a Podspec see http://guides.cocoapods.org/syntax/podspec.html.
# Run `pod lib lint ali_face_vertify.podspec` to validate before publishing.
#
Pod::Spec.new do |s|
  s.name             = 'ali_face_vertify'
  s.version          = '0.0.1'
  s.summary          = 'A new flutter plugin project.'
  s.description      = <<-DESC
A new flutter plugin project.
                       DESC
  s.homepage         = 'http://example.com'
  s.license          = { :file => '../LICENSE' }
  s.static_framework = true
  s.author           = { 'LiChang' => '' }
  s.source           = { :path => '.' }
  s.source_files = 'Classes/**/*'
  s.public_header_files = 'Classes/**/*.h'
  s.frameworks            = 'CoreGraphics', 'Accelerate', 'SystemConfiguration', 'AssetsLibrary', 'CoreTelephony', 'QuartzCore', 'CoreFoundation', 'CoreLocation', 'ImageIO', 'CoreMedia','CoreMotion','AVFoundation','WebKit','AudioToolbox','CFNetwork','MobileCoreServices','AdSupport'
  s.libraries             = 'z', 'c++','c++.1','c++abi','z.1.2.8','resolv'
  s.resource              = 'AliFaceSDK/APBToygerFacade.framework/APBToygerFacade.bundle','AliFaceSDK/ToygerNative.framework/ToygerNative.bundle','AliFaceSDK/OCRDetectSDKForTech.framework/OCRXMedia.bundle','AliFaceSDK/BioAuthEngine.framework/BioAuthEngine.bundle'
  s.vendored_frameworks   = 'AliFaceSDK/AliyunIdentityManager.framework','AliFaceSDK/AliyunOSSiOS.framework','AliFaceSDK/APBToygerFacade.framework','AliFaceSDK/APPSecuritySDK.framework','AliFaceSDK/BioAuthAPI.framework','AliFaceSDK/BioAuthEngine.framework','AliFaceSDK/deviceiOS.framework','AliFaceSDK/MPRemoteLogging.framework','AliFaceSDK/OCRDetectSDKForTech.framework','AliFaceSDK/ToygerNative.framework','AliFaceSDK/ToygerService.framework','AliFaceSDK/ZolozIdentityManager.framework','AliFaceSDK/ZolozMobileRPC.framework','AliFaceSDK/ZolozOpenPlatformBuild.framework','AliFaceSDK/ZolozSensorServices.framework','AliFaceSDK/ZolozUtility.framework'
  s.dependency 'Flutter'
  s.platform = :ios, '9.0'

  # Flutter.framework does not contain a i386 slice.
  s.pod_target_xcconfig = { 'DEFINES_MODULE' => 'YES', 'EXCLUDED_ARCHS[sdk=iphonesimulator*]' => 'i386 x86_64','OTHER_LDFLAGS' => '-ObjC -framework "BioAuthAPI" -lxml2' }
end
