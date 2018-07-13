package com.lijun.basedemo.mvp_one.ui

import android.text.TextUtils

/**
 * @author Koma
 * @date 13 02
 * @des
 */
class LoginPresenter(private val loginView: LoginContract.View) : LoginContract.Presenter {


  override fun login() {
    if (!TextUtils.isEmpty(loginView.account) && TextUtils.isEmpty(loginView.password)) {
      loginView.loginSuccess()
    } else {
     // loginView.loginError()
    }

  }

  override fun onStart() {
    loginView.loginStart()
  }
}