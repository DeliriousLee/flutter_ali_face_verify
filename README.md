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
