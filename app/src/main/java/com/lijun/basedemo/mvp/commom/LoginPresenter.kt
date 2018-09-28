package com.lijun.basedemo.mvp.commom

/**
 * @author Koma
 * @date 2018/9/20 9:39
 * @des
 */
interface LoginPresenter {
  fun doLogin(name: String, password: String)
}