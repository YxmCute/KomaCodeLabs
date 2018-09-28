package com.lijun.basedemo.mvp.commom

import kotlin.properties.Delegates

/**
 * @author Koma
 * @date 2018/9/20 10:22
 * @des
 */
class LoginPresenterImpl(val view: LoginVIew) : LoginPresenter {
  private val loginModelImpl: LoginModelImpl by lazy {
    LoginModelImpl()
  }
  /*var name: String by Delegates.observable("<no name>") {
    prop, old, new ->
    println("$old -> $new")
  }*/

  override fun doLogin(name: String, password: String) {
    loginModelImpl.login(name, password, object : LoginModel.LoginCallBack {
      override fun logining(msg: String) {
        view.onLogining(msg)


      }

      override fun loginSuccess(msg: String) {
        view.onLoginSuccess(msg)
      }

      override fun loginFailed(msg: String) {
        view.onLoginFailed(msg)
      }
    })


  }


}