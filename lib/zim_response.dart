// ignore_for_file: constant_identifier_names

class ZIMResponseStatus {
  static const ZIMResponseSuccess =
      1000; //采集成功并且服务端成功(人脸比对成功，或者证件宝服务端OCR/质量检测成功)[static const ZIM不会弹框处理]
  static const ZIMInternalError =
      1001; //用户被动退出(极简核身没有取到协议、toyger启动失败、协议解析失败)[static const ZIM不会弹框处理]
  static const ZIMInterrupt =
      1003; //用户主动退出(无相机权限、超时、用户取消)[static const ZIM会弹框处理]
  static const ZIMNetworkfail =
      2002; //网络失败(标准static const ZIM流程，请求协议错误，oss上传失败)[static const ZIM不会弹框处理]
  static const ZIMTIMEError = 2003; //设备时间设置不对
  static const ZIMResponseFail =
      2006; //服务端validate失败(人脸比对失败或者证件宝OCR/质量检测失败)[static const ZIM不会弹框处理]

  static const ZIMResponseReseaonMap = {
    '1000': '采集成功',
    '1001': '数据解析失败',
    '1003': '用户主动退出',
    '2002': '网络失败',
    '2003': '时间错误',
    '2006': '人脸比对失败'
  };
}

