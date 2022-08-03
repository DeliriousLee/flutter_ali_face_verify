import 'dart:convert';

import 'package:ali_face_vertify/ali_face_message.dart';
import 'package:ali_face_vertify/zim_response.dart';
import 'package:dio/dio.dart';
import 'package:flutter/material.dart';
import 'dart:async';

import 'package:flutter/services.dart';
import 'package:ali_face_vertify/ali_face_vertify.dart';

void main() {
  runApp(FaceVertifyPage());
}

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
