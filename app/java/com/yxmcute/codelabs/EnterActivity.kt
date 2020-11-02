package com.yxmcute.codelabs

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @author Koma
 * @date 2020/6/25 23:31
 * @filename  EnterActivity
 * @description
 */
class EnterActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    setContentView(R.layout.activity_fragment)
    /*if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
          .add(R.id.fl_container, ComparePaintStyleFragment())
          .commit()
    }*/
  }
}