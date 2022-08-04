package com.example.ali_face_vertify;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alibaba.fastjson.JSON;
import com.aliyun.aliyunface.api.ZIMCallback;
import com.aliyun.aliyunface.api.ZIMFacade;
import com.aliyun.aliyunface.api.ZIMFacadeBuilder;
import com.aliyun.aliyunface.api.ZIMResponse;
import com.aliyun.aliyunface.utils.StringUtil;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;

import java.util.HashMap;
import java.util.Map;



/** AliFaceVertifyPlugin */
public class AliFaceVertifyPlugin implements FlutterPlugin, MethodCallHandler, AliFaceVertifyManager.AliFaceVertifyManagerImpl{
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  static AliFaceVertifyManager.AliFaceVertifyCallBack aliFaceVertifyCallBack;
  private MethodChannel channel;
  private Context context;
  public static String jsonReasonMapString = "{\"Z5120\":\"刷脸成功，认证通过\",\"Z1000\":\"其他异常 \",\"Z1001\":\"人脸识别算法初始化失败 \",\"Z1003\":\"不支持的CPU架构 \",\"Z1004\":\"Android系统版本过低 \",\"Z1005\":\"刷脸超时(单次) \",\"Z1006\":\"多次刷脸超时 \",\"Z1018\":\"无前置摄像头 \",\"Z1019\":\"摄像头权限未赋予 \",\"Z1020\":\"打开摄像头失败 \",\"Z1024\":\"SDK认证流程正在进行中，请等待 \",\"Z1029\":\"Android系统不支持录屏 \",\"Z1030\":\"录音权限未赋予 \",\"Z1031\":\"录屏权限未赋予 \",\"Z1032\":\"麦克风打开失败 \",\"Z1033\":\"录屏打开失败 \",\"Z1034\":\"本地存储空间过小\",\"Z5116\":\"音频文件上传失败 \",\"Z5112\":\"上传炫彩Meta信息失败 \",\"Z5113\":\"上传炫彩视频失败 \",\"Z5114\":\"认证视频上传失败 \",\"Z6001\":\"OCR识别次数超限 \",\"Z6002\":\"OCR图片上传网络超时 \",\"Z6003\":\"OSS Token过期 \",\"Z6004\":\"人脸照片处理失败 \",\"Z7001\":\"SDK初始化或者使用过程中数据异常 \",\"Z1008\":\"用户在认证过程中退出 \",\"Z1009\":\"用户在授权页面点击“暂不授权”退出 \",\"Z1011\":\"客户端初始化网络错误 \",\"Z1012\":\"客户端网络访问异常 \",\"Z1025\":\"客户端初始化接口返回网络错误 \",\"Z1026\":\"信息上传网络错误 \",\"Z1027\":\"服务端认证接口网络错误 \",\"Z5128\":\"刷脸失败，认证未通过 可通过服务端查询接口获取认证未通过具体原因 \"}";
  public Map<String,Object> reasonCodeMap;
  @Override
  public void onAttachedToEngine(@NonNull FlutterPluginBinding binding) {
    onAttachedToEngine(binding.getApplicationContext(), binding.getBinaryMessenger());
    
  }
  private void onAttachedToEngine(Context applicationContext, BinaryMessenger flutterPluginBinding) {
    this.context = applicationContext;
    channel = new MethodChannel(flutterPluginBinding, "ali_face_vertify");
    channel.setMethodCallHandler(this);
    AliFaceVertifyManager.AliFaceVertifyManagerImpl.setup(flutterPluginBinding,this);
    aliFaceVertifyCallBack = new AliFaceVertifyManager.AliFaceVertifyCallBack(flutterPluginBinding);
    reasonCodeMap = JSON.parseObject(jsonReasonMapString);
}

  @Override
  public void onMethodCall(@NonNull MethodCall call, @NonNull Result result) {
    if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else {
      result.notImplemented();
    }
  }


  @NonNull
  @Override
  public void init() {
      ZIMFacade.install(this.context);
  }

  @Override
  public void onDetachedFromEngine(FlutterPluginBinding binding) {
      context = null;
      channel.setMethodCallHandler(null);
      channel = null;
  }

  @NonNull
  @Override
  public Map<Object, Object> getMetaInfo() {
      String metaInfos = ZIMFacade.getMetaInfos(this.context);
      if (StringUtil.isNullorEmpty(metaInfos)) {
          return null;
      }
      return JSON.parseObject(metaInfos, Map.class);
  }

  @NonNull
  @Override
  public void openFaceCertify(String certifyId) {

      ZIMFacade zimFacade = ZIMFacadeBuilder.create(this.context);

      HashMap<String, String> extParams = new HashMap<>();
      extParams.put(ZIMFacade.ZIM_EXT_PARAMS_KEY_OCR_BOTTOM_BUTTON_COLOR, "##4F65EE");
      zimFacade.verify(certifyId, true, extParams, new ZIMCallback() {
          public boolean response(final ZIMResponse response) {
            /// 阿里iOS中有直接的reason,安卓中response.reason只有code需要对doc建立映射
            Object localDocReason = reasonCodeMap.get(response.reason);
            String reason = String.format("%s",localDocReason);
            Log.d("AliFaceVerify","ZIMResponse return: \ncode:"+response.code+"\nreason:"+response.reason+"  "+reason+"\nmsg:"+response.msg);
              AliFaceVertifyManager.FaceVerResponse faceRsp = new AliFaceVertifyManager.FaceVerResponse();
              faceRsp.setCode((long) response.code);
              faceRsp.setReason(reason);
              faceRsp.setRetMessageSub(response.msg);
              faceRsp.setDeviceToken(response.deviceToken);
              faceRsp.setVideoFilePath(response.videoFilePath);
              aliFaceVertifyCallBack.certifyCompletion(faceRsp, null);
              return true;
          }
      });
  }
}
