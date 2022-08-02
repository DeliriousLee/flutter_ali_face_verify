import 'package:pigeon/pigeon.dart';

class FaceVerResponse {
  int? code;
  int? retCode;
  String? reason;
  String? retCodeSub;
  String? retMessageSub;
  Map? extInfo;
  String? bizData;
  String? deviceToken; //设备token
  String? videoFilePath; //如果采用视频返照，这个字段返回视频的路径
}

@HostApi()
abstract class AliFaceVertifyManager {
  /// sdk初始化
  void init();

  /// 获取设备信息
  Map getMetaInfo();

  /// 人脸认证
  void openFaceCertify(String certifyId);
}

@FlutterApi()
abstract class AliFaceVertifyCallBack {
  void certifyCompletion(FaceVerResponse response);
}
