package com.lijun.basedemo.mvp_one

/**
 * @author Koma
 * @date 2018/9/20 10:22
 * @des
 */
class LoginPresenterImpl(val view: LoginVIew) : LoginPresenter {
  private val loginModelImpl: LoginModelImpl by lazy {
    LoginModelImpl()
  }

  override fun doLogin(name: String, password: String) {
    view.onLoginning("")
    loginModelImpl.login(name, password, object : LoginModel.LoginCallBack {
      override fun loginSuccess(msg: String) {
        view.onLoginSuccess("")
      }

      override fun loginFailed(msg: String) {
        view.onLoginFailed(msg)
      }
    })


  }


}