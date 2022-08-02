// Autogenerated from Pigeon (v1.0.19), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package com.example.ali_face_vertify;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression"})
public class AliFaceVertifyManager {

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class FaceVerResponse {
    private @Nullable Long code;
    public @Nullable Long getCode() { return code; }
    public void setCode(@Nullable Long setterArg) {
      this.code = setterArg;
    }

    private @Nullable Long retCode;
    public @Nullable Long getRetCode() { return retCode; }
    public void setRetCode(@Nullable Long setterArg) {
      this.retCode = setterArg;
    }

    private @Nullable String reason;
    public @Nullable String getReason() { return reason; }
    public void setReason(@Nullable String setterArg) {
      this.reason = setterArg;
    }

    private @Nullable String retCodeSub;
    public @Nullable String getRetCodeSub() { return retCodeSub; }
    public void setRetCodeSub(@Nullable String setterArg) {
      this.retCodeSub = setterArg;
    }

    private @Nullable String retMessageSub;
    public @Nullable String getRetMessageSub() { return retMessageSub; }
    public void setRetMessageSub(@Nullable String setterArg) {
      this.retMessageSub = setterArg;
    }

    private @Nullable Map<Object, Object> extInfo;
    public @Nullable Map<Object, Object> getExtInfo() { return extInfo; }
    public void setExtInfo(@Nullable Map<Object, Object> setterArg) {
      this.extInfo = setterArg;
    }

    private @Nullable String bizData;
    public @Nullable String getBizData() { return bizData; }
    public void setBizData(@Nullable String setterArg) {
      this.bizData = setterArg;
    }

    private @Nullable String deviceToken;
    public @Nullable String getDeviceToken() { return deviceToken; }
    public void setDeviceToken(@Nullable String setterArg) {
      this.deviceToken = setterArg;
    }

    private @Nullable String videoFilePath;
    public @Nullable String getVideoFilePath() { return videoFilePath; }
    public void setVideoFilePath(@Nullable String setterArg) {
      this.videoFilePath = setterArg;
    }

    public static class Builder {
      private @Nullable Long code;
      public @NonNull Builder setCode(@Nullable Long setterArg) {
        this.code = setterArg;
        return this;
      }
      private @Nullable Long retCode;
      public @NonNull Builder setRetCode(@Nullable Long setterArg) {
        this.retCode = setterArg;
        return this;
      }
      private @Nullable String reason;
      public @NonNull Builder setReason(@Nullable String setterArg) {
        this.reason = setterArg;
        return this;
      }
      private @Nullable String retCodeSub;
      public @NonNull Builder setRetCodeSub(@Nullable String setterArg) {
        this.retCodeSub = setterArg;
        return this;
      }
      private @Nullable String retMessageSub;
      public @NonNull Builder setRetMessageSub(@Nullable String setterArg) {
        this.retMessageSub = setterArg;
        return this;
      }
      private @Nullable Map<Object, Object> extInfo;
      public @NonNull Builder setExtInfo(@Nullable Map<Object, Object> setterArg) {
        this.extInfo = setterArg;
        return this;
      }
      private @Nullable String bizData;
      public @NonNull Builder setBizData(@Nullable String setterArg) {
        this.bizData = setterArg;
        return this;
      }
      private @Nullable String deviceToken;
      public @NonNull Builder setDeviceToken(@Nullable String setterArg) {
        this.deviceToken = setterArg;
        return this;
      }
      private @Nullable String videoFilePath;
      public @NonNull Builder setVideoFilePath(@Nullable String setterArg) {
        this.videoFilePath = setterArg;
        return this;
      }
      public @NonNull FaceVerResponse build() {
        FaceVerResponse pigeonReturn = new FaceVerResponse();
        pigeonReturn.setCode(code);
        pigeonReturn.setRetCode(retCode);
        pigeonReturn.setReason(reason);
        pigeonReturn.setRetCodeSub(retCodeSub);
        pigeonReturn.setRetMessageSub(retMessageSub);
        pigeonReturn.setExtInfo(extInfo);
        pigeonReturn.setBizData(bizData);
        pigeonReturn.setDeviceToken(deviceToken);
        pigeonReturn.setVideoFilePath(videoFilePath);
        return pigeonReturn;
      }
    }
    @NonNull Map<String, Object> toMap() {
      Map<String, Object> toMapResult = new HashMap<>();
      toMapResult.put("code", code);
      toMapResult.put("retCode", retCode);
      toMapResult.put("reason", reason);
      toMapResult.put("retCodeSub", retCodeSub);
      toMapResult.put("retMessageSub", retMessageSub);
      toMapResult.put("extInfo", extInfo);
      toMapResult.put("bizData", bizData);
      toMapResult.put("deviceToken", deviceToken);
      toMapResult.put("videoFilePath", videoFilePath);
      return toMapResult;
    }
    static @NonNull FaceVerResponse fromMap(@NonNull Map<String, Object> map) {
      FaceVerResponse pigeonResult = new FaceVerResponse();
      Object code = map.get("code");
      pigeonResult.setCode((code == null) ? null : ((code instanceof Integer) ? (Integer)code : (Long)code));
      Object retCode = map.get("retCode");
      pigeonResult.setRetCode((retCode == null) ? null : ((retCode instanceof Integer) ? (Integer)retCode : (Long)retCode));
      Object reason = map.get("reason");
      pigeonResult.setReason((String)reason);
      Object retCodeSub = map.get("retCodeSub");
      pigeonResult.setRetCodeSub((String)retCodeSub);
      Object retMessageSub = map.get("retMessageSub");
      pigeonResult.setRetMessageSub((String)retMessageSub);
      Object extInfo = map.get("extInfo");
      pigeonResult.setExtInfo((Map<Object, Object>)extInfo);
      Object bizData = map.get("bizData");
      pigeonResult.setBizData((String)bizData);
      Object deviceToken = map.get("deviceToken");
      pigeonResult.setDeviceToken((String)deviceToken);
      Object videoFilePath = map.get("videoFilePath");
      pigeonResult.setVideoFilePath((String)videoFilePath);
      return pigeonResult;
    }
  }
  private static class AliFaceVertifyManagerCodec extends StandardMessageCodec {
    public static final AliFaceVertifyManagerCodec INSTANCE = new AliFaceVertifyManagerCodec();
    private AliFaceVertifyManagerCodec() {}
    @Override
    protected Object readValueOfType(byte type, ByteBuffer buffer) {
      switch (type) {
        case (byte)128:         
          return FaceVerResponse.fromMap((Map<String, Object>) readValue(buffer));
        
        default:        
          return super.readValueOfType(type, buffer);
        
      }
    }
    @Override
    protected void writeValue(ByteArrayOutputStream stream, Object value)     {
      if (value instanceof FaceVerResponse) {
        stream.write(128);
        writeValue(stream, ((FaceVerResponse) value).toMap());
      } else 
{
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated interface from Pigeon that represents a handler of messages from Flutter.*/
  public interface AliFaceVertifyManagerImpl {
    @NonNull void init();
    @NonNull Map<Object, Object> getMetaInfo();
    @NonNull void openFaceCertify(String certifyId);

    /** The codec used by AliFaceVertifyManager. */
    static MessageCodec<Object> getCodec() {
      return AliFaceVertifyManagerCodec.INSTANCE;
    }

    /** Sets up an instance of `AliFaceVertifyManager` to handle messages through the `binaryMessenger`. */
    static void setup(BinaryMessenger binaryMessenger, AliFaceVertifyManagerImpl api) {
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.AliFaceVertifyManager.init", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              api.init();
              wrapped.put("result", null);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
            }
            reply.reply(wrapped);
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.AliFaceVertifyManager.getMetaInfo", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              Map<Object, Object> output = api.getMetaInfo();
              wrapped.put("result", output);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
            }
            reply.reply(wrapped);
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
      {
        BasicMessageChannel<Object> channel =
            new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.AliFaceVertifyManager.openFaceCertify", getCodec());
        if (api != null) {
          channel.setMessageHandler((message, reply) -> {
            Map<String, Object> wrapped = new HashMap<>();
            try {
              ArrayList<Object> args = (ArrayList<Object>)message;
              String certifyIdArg = (String)args.get(0);
              if (certifyIdArg == null) {
                throw new NullPointerException("certifyIdArg unexpectedly null.");
              }
              api.openFaceCertify(certifyIdArg);
              wrapped.put("result", null);
            }
            catch (Error | RuntimeException exception) {
              wrapped.put("error", wrapError(exception));
            }
            reply.reply(wrapped);
          });
        } else {
          channel.setMessageHandler(null);
        }
      }
    }
  }
  private static class AliFaceVertifyCallBackCodec extends StandardMessageCodec {
    public static final AliFaceVertifyCallBackCodec INSTANCE = new AliFaceVertifyCallBackCodec();
    private AliFaceVertifyCallBackCodec() {}
    @Override
    protected Object readValueOfType(byte type, ByteBuffer buffer) {
      switch (type) {
        case (byte)128:         
          return FaceVerResponse.fromMap((Map<String, Object>) readValue(buffer));
        
        default:        
          return super.readValueOfType(type, buffer);
        
      }
    }
    @Override
    protected void writeValue(ByteArrayOutputStream stream, Object value)     {
      if (value instanceof FaceVerResponse) {
        stream.write(128);
        writeValue(stream, ((FaceVerResponse) value).toMap());
      } else 
{
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated class from Pigeon that represents Flutter messages that can be called from Java.*/
  public static class AliFaceVertifyCallBack {
    private final BinaryMessenger binaryMessenger;
    public AliFaceVertifyCallBack(BinaryMessenger argBinaryMessenger){
      this.binaryMessenger = argBinaryMessenger;
    }
    public interface Reply<T> {
      void reply(T reply);
    }
    static MessageCodec<Object> getCodec() {
      return AliFaceVertifyCallBackCodec.INSTANCE;
    }

    public void certifyCompletion(FaceVerResponse responseArg, Reply<Void> callback) {
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.AliFaceVertifyCallBack.certifyCompletion", getCodec());
      channel.send(new ArrayList<Object>(Arrays.asList(responseArg)), channelReply -> {
        callback.reply(null);
      });
    }
  }
  private static Map<String, Object> wrapError(Throwable exception) {
    Map<String, Object> errorMap = new HashMap<>();
    errorMap.put("message", exception.toString());
    errorMap.put("code", exception.getClass().getSimpleName());
    errorMap.put("details", "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    return errorMap;
  }
}
