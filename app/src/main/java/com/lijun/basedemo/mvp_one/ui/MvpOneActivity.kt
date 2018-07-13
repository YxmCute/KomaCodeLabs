package com.lijun.basedemo.mvp_one.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.lijun.basedemo.R

class MvpOneActivity : AppCompatActivity(), LoginContract.View {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_mvp_one)
  }


  override fun loginError(msg: String) {

  }


  override fun loginSuccess() {

  }

  override fun loginStart() {
  }


  override fun getAccount(): String? {
    return null
  }


  override fun getPassword(): String? {
    return null
  }


  override fun setPresenter(presenter: LoginContract.Presenter) {

  }
}
