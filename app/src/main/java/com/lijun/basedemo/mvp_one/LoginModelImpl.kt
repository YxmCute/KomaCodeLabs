package com.lijun.basedemo.mvp_one

/**
 * @author Koma
 * @date 2018/9/20 10:49
 * @des
 */
class LoginModelImpl : LoginModel {
  override fun login(name: String, password: String, loginCallBack: LoginModel.LoginCallBack) {
    if (name == "lijun" && password == "1102") {
      loginCallBack.loginSuccess("ok")
    } else {
      loginCallBack.loginFailed("failed")

    }
  }
}