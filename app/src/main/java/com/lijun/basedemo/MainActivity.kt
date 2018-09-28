package com.lijun.basedemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.util.Log
import com.lijun.basedemo.mvp.commom.LoginFragment
import com.lijun.basedemo.utils.DisplayUtils
import kotlin.math.log

class MainActivity : AppCompatActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    //DisplayUtils.setCustomDensity(this,application)
    val dm = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(dm)

    Log.i("dm", "xdpi=" + dm.xdpi)
    Log.i("dm", "ydpi=" + dm.ydpi)
    Log.i("dm", "density=" + dm.density)
    Log.i("dm", "densityDpi=" + dm.densityDpi)
    Log.i("dm", "scaledDensity=" + dm.scaledDensity)
    Log.i("dm", "widthPixels=" + dm.widthPixels)
    Log.i("dm", "heightPixels=" + dm.heightPixels)

    supportFragmentManager.beginTransaction()
        .replace(R.id.fragment_layout, LoginFragment())
        .commit()
  }
}
