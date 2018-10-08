package com.lijun.basedemo

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.DisplayMetrics
import android.util.Log
import android.view.WindowManager
import com.blankj.utilcode.util.BarUtils
import com.lijun.basedemo.fragment.CustomViewFragment
import com.lijun.basedemo.fragment.PieData
import com.lijun.basedemo.utils.DisplayUtils
import com.lijun.basedemo.view.gggg


class MainActivity : AppCompatActivity() {


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    //DisplayUtils.setCustomDensity(this,application)
    val dm = DisplayMetrics()
    windowManager.defaultDisplay.getMetrics(dm)
    val realDm = DisplayMetrics()
    val windowManager = this@MainActivity.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      windowManager.defaultDisplay.getRealMetrics(realDm)
    }

    Log.i("dm", "xdpi=" + dm.xdpi)
    Log.i("dm", "ydpi=" + dm.ydpi)
    Log.i("dm", "density=" + dm.density)
    Log.i("dm", "densityDpi=" + dm.densityDpi)
    Log.i("dm", "scaledDensity=" + dm.scaledDensity)
    Log.i("dm", "widthPixels=" + dm.widthPixels)
    Log.i("dm", "heightPixels=" + dm.heightPixels)
    Log.i("dm", "RealwidthPixels=" + realDm.widthPixels)
    Log.i("dm", "RealheightPixels=" + realDm.heightPixels)
    var result = 0
    val resourceId = this.getResources().getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
      result = this.getResources().getDimensionPixelSize(resourceId)
    }
    // Log.i("dm", "状态栏高度=" + result + "---" + BarUtils.getStatusBarHeight())

    val resources = this.resources
    val navresourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android")
    val height = resources.getDimensionPixelSize(navresourceId)
    Log.i("dm", "导航height:" + height

        + "反射测试；" + gggg.checkDeviceHasNavigationBar(this) + "是否显示：" + gggg.getNavigationBarHeightByR(this)
        + "自己手写的方法" + gggg.getNavigationBarHeight(this))
    Log.i("dm", "huawei" + DisplayUtils.checkDeviceHasNavigationBar(this))
    Log.i("dm", "kankan zhege " + gggg.isNavigationBarShow(this))
    Log.i("dm", "ooo" + gggg.checkNavigationBarShow(this, this.window))
    Log.i("dm", "uticode=" + BarUtils.isNavBarVisible(this) + "height=" + BarUtils.getNavBarHeight())


    supportFragmentManager.beginTransaction()
        .add(R.id.fragment_layout, CustomViewFragment())
        .commit()
  }
}
