package com.lijun.basedemo.mvp_one

/**
 * @author Koma
 * @date 2018/9/20 10:41
 * @des
 */
interface LoginModel {
  interface LoginCallBack {
    fun loginSuccess(msg: String)
    fun loginFailed(msg: String)
  }

  fun login(name: String, password: String,loginCallBack: LoginCallBack)
}