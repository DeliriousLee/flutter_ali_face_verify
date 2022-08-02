package com.example.ali_face_vertify;

import android.content.Context;
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

      zimFacade.verify(certifyId, true, extParams, new ZIMCallback() {
          public boolean response(final ZIMResponse response) {
              AliFaceVertifyManager.FaceVerResponse faceRsp = new AliFaceVertifyManager.FaceVerResponse();
              faceRsp.setCode((long) response.code);
              faceRsp.setReason(response.reason);
              faceRsp.setRetMessageSub(response.msg);
              faceRsp.setDeviceToken(response.deviceToken);
              faceRsp.setVideoFilePath(response.videoFilePath);
              aliFaceVertifyCallBack.certifyCompletion(faceRsp, null);
              return true;
          }
      });
  }
}
