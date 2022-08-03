# ali_face_vertify

A new flutter plugin project.

## Getting Started

This project is a starting point for a Flutter
[plug-in package](https://flutter.dev/developing-packages/),
a specialized package that includes platform-specific implementation code for
Android and/or iOS.

# 集成
需要在主工程```$flutterProject/android/app/```下添加```libs```文件夹，其中的内容是本plugins中的
```
APSecuritySDK-DeepSec-7.0.1.20220617.jiagu.aar
Android-AliyunDevice-FG-10022.2.aar
android-aliyunbasicstl-sdk-release-1.6.5-20220704102254.aar
android-aliyuncomm-sdk-release-1.6.5-20220704102254.aar
android-aliyunface-sdk-release-1.6.5-20220704102254.aar
android-aliyunocr-sdk-release-1.6.5-20220704102254.aar
photinus-1.0.1.220217162928.aar
tygerservice-1.0.0.220618105311.aar
```
并且在主工程中的app/build.gradle中添加
```
dependencies {
    implementation fileTree(dir: 'libs', include: ['*.aar'])
}
```
以获得aar引包
## 权限
### Android
```
// 授权获取手机状态的权限。
<uses-permission android:name="android.permission.READ_PHONE_STATE" />                
// 授权获取接入网络的权限。开发人员需注意，6.0以上系统属于动态权限。     
<uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
```
### iOS
info.plist添加相机使用权限
```
<key>NSCameraUsageDescription</key>
	<string>调取相机以获取头像</string>
```
### example
```
// ignore_for_file: prefer_const_constructors_in_immutables

class FaceVertifyPage extends StatefulWidget {
  FaceVertifyPage({Key? key}) : super(key: key);

  @override
  State<FaceVertifyPage> createState() => _FaceVertifyPageState();
}

class _FaceVertifyPageState extends State<FaceVertifyPage>
    implements AliFaceVertifyCallBack {
  @override
  void initState() {
    testFaceInitial();
    AliFaceVertifyCallBack.setup(this);
    super.initState();
  }

  void testFaceInitial() async {
    var manager = AliFaceVertifyManager();
    AliFaceVertifyCallBack;
    var metaInfo = await manager.getMetaInfo();
    /// 将metaInfo转为String之后传给后台做校验
    var stringObj = jsonEncode(metaInfo);
    /// 后台获取到metaInfo后根据服务端sdk生成certifyId，根据id，去唤醒sdk
    
    var rsp = await  Dio().post('/v3/user/auth/init',
        queryParameters: {'metaInfo': stringObj, 'authType': 1});
    if (rsp.data is String) {
      String certifyId = rsp.data ?? '';
      debugPrint(certifyId);

      await manager.openFaceCertify(certifyId);
    }
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(title: Text('人脸验证页面')),
      ),
    );
  }

  @override
  void certifyCompletion(FaceVerResponse response) {
    if (response.code == ZIMResponseStatus.ZIMResponseSuccess) {
      ///showToast('人脸认证完成');
      
    } else {
      ///showToast(response.reason ?? '');
    }
  }
}
```
<img src= "https://user-images.githubusercontent.com/24474112/182522655-af341281-1c57-4368-9410-ea9747027449.PNG" alt="IMG_4508" width="375" height="800"/>
<img src="https://user-images.githubusercontent.com/24474112/182522646-959a1601-a449-4162-92f2-44ee28158bcc.PNG" alt="IMG_4507" width="375" height="800"/>

# 代码混淆
如果需要代码混淆，在主工程中app/build.gradle中添加
```
       buildTypes {
        release {
            signingConfig signingConfigs.release
            proguardFiles getDefaultProguardFile('proguard-android.txt'),'proguard-rules.pro'
            minifyEnabled true
        }

        debug {
            signingConfig signingConfigs.release
            minifyEnabled false
        }
    }
```
其中需另外添加proguard-rules.pro，该文件需要放置在主工程android/app下，与src同级
即主工程的目录如下：
$flutterProject
  build.gradle        
  proguard-rules.pro
  libs                    
  src
```
# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-verbose

-keep class com.aliyun.aliyunface.network.model.** {*;}
-keep class com.aliyun.aliyunface.api.ZIMCallback {*;}
-keep class com.aliyun.aliyunface.api.ZIMFacade {*;}
-keep class com.aliyun.aliyunface.api.ZIMFacadeBuilder {*;}
-keep class com.aliyun.aliyunface.api.ZIMMetaInfo {*;}
-keep class com.aliyun.aliyunface.api.ZIMResponse {*;}
-keep class com.aliyun.aliyunface.api.ZIMSession {*;}
-keep class com.aliyun.aliyunface.config.**{*;}
-keep class com.aliyun.aliyunface.log.RecordBase {*;}
-keep class com.aliyun.aliyunface.ui.ToygerWebView {*;}

-keep class com.alipay.zoloz.toyger.**{*;}
-keep class com.alipay.zoloz.image.** {*;}
-keep class com.alipay.android.** {*;}
-keep class com.alipay.zoloz.toyger.ToygerState { *; }
-keep class com.alipay.zoloz.toyger.algorithm.Astro { *; }

-keep class net.security.device.api.** {*;}
-keep class com.alipay.deviceid.** { *; }
-keep class com.alibaba.fastjson.** {*;}
-keep class com.alibaba.sdk.android.oss.** { *; }
-dontwarn okio.**
-dontwarn org.apache.commons.codec.binary.**

-keepclassmembers,allowobfuscation class * {
     @com.alibaba.fastjson.annotation.JSONField <fields>;
}
```
