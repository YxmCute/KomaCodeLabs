package com.lijun.basedemo.mvp_one

/**
 * @author Koma
 * @date 2018/9/20 9:28
 * @des
 */
interface LoginVIew {
  fun onLoginSuccess(msg: String)
  fun onLoginFailed(msg: String)
  fun onLoginning(msg: String)
  fun onLoginComplete(msg: String)
}