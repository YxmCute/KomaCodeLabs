package com.lijun.basedemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.lijun.basedemo.mvp_one.ui.LoginFragment

class MainActivity : AppCompatActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    supportFragmentManager.beginTransaction()
        .replace(R.id.fragment_layout, LoginFragment())
        .commit()
  }
}
