package com.lijun.basedemo.mvp.commom

/**
 * @author Koma
 * @date 2018/9/20 10:49
 * @des
 */
class LoginModelImpl : LoginModel {
  override fun login(name: String, password: String, loginCallBack: LoginModel.LoginCallBack) {
    loginCallBack.logining("正在登录中...")
   // Thread.sleep(2000)
    if (name == "KK" && password == "1102") {
      loginCallBack.loginSuccess("ok")
    } else {
      loginCallBack.loginFailed("failed")

    }
  }
}