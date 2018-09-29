package com.lijun.basedemo.utils

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Activity
import android.app.Application
import android.content.ComponentCallbacks
import android.content.Context
import android.content.res.Configuration
import android.graphics.Point
import android.os.Build
import android.util.DisplayMetrics
import android.view.KeyCharacterMap
import android.view.KeyEvent
import android.view.ViewConfiguration
import android.view.WindowManager
import org.jetbrains.annotations.NotNull

/**
 * @author Koma
 * @date 2018/9/28 17:43
 * @des
 */
object DisplayUtils {

  private var sNoncompatDensity: Float = 0.toFloat()
  private var sNoncompatScaledDensity: Float = 0.toFloat()


  fun setCustomDensity(activity: Activity, application: Application) {
    val appDisplayMetrics = application.resources.displayMetrics
    if (sNoncompatDensity == 0f) {
      sNoncompatDensity = appDisplayMetrics.density
      sNoncompatScaledDensity = appDisplayMetrics.scaledDensity
      // 防止系统切换后不起作用
      application.registerComponentCallbacks(object : ComponentCallbacks {
        override fun onConfigurationChanged(newConfig: Configuration?) {
          if (newConfig != null && newConfig.fontScale > 0) {
            sNoncompatScaledDensity = application.resources.displayMetrics.scaledDensity
          }
        }


        override fun onLowMemory() {

        }
      })
    }
    val targetDensity = (appDisplayMetrics.widthPixels / 360).toFloat()
    // 防止字体变小
    val targetScaleDensity = targetDensity * (sNoncompatScaledDensity / sNoncompatDensity)
    val targetDensityDpi = (160 * targetDensity).toInt()

    appDisplayMetrics.density = targetDensity
    appDisplayMetrics.scaledDensity = targetScaleDensity
    appDisplayMetrics.densityDpi = targetDensityDpi

    val activityDisplayMetrics = activity.resources.displayMetrics
    activityDisplayMetrics.density = targetDensity
    activityDisplayMetrics.scaledDensity = targetScaleDensity
    activityDisplayMetrics.densityDpi = targetDensityDpi

  }

  //获取状态栏的高度
  fun getStatusBarHeight(context: Context): Int {
    var result = 0
    val resourceId = context.resources.getIdentifier("status_bar_height", "dimen", "android")
    if (resourceId > 0) {
      result = context.resources.getDimensionPixelSize(resourceId)
    }
    return result
  }

  //判断是否有导航栏
  @SuppressLint("PrivateApi")
  @Deprecated("")
  fun checkDeviceHasNavigationBar(@NotNull context: Context): Boolean {
    var hasNavigation = false
    val resources = context.resources
    val id = resources.getIdentifier("config_showNavigationBar", "bool", "android")
    if (id > 0) {
      hasNavigation = resources.getBoolean(id)
    }
    try {
      val clazz = Class.forName("android.os.SystemProperties")
      val method = clazz.getMethod("get", String::class.java)
      val s = method.invoke(clazz, "qemu.hw.mainkeys")
      when (s) {
        "1" -> hasNavigation = false
        "0" -> hasNavigation = true
      }

    } catch (e: Exception) {
    }


    return hasNavigation
  }

  @Deprecated("")
  fun getNavigationBarHeightByR(context: Context): Int {
    var vh = 0
    val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    val display = windowManager.defaultDisplay
    val dm = DisplayMetrics()
    try {
      val c = Class.forName("android.view.Display")
      val method = c.getMethod("getRealMetrics", DisplayMetrics::class.java)
      method.invoke(display, dm)
      val point = Point()
      windowManager.defaultDisplay?.getSize(point)
      //int width = point.x;
      val height = point.y
      //vh = dm.heightPixels - windowManager.getDefaultDisplay().getHeight();
      vh = dm.heightPixels - height

    } catch (e: Exception) {
      e.printStackTrace()
    }
    return vh
  }
  //判断导航栏显示状态
  fun isNavigationBarShow(@NotNull activity: Activity): Boolean {
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
      val display = activity.windowManager.defaultDisplay
      val size = Point()
      val realSize = Point()
      display.getSize(size)
      display.getRealSize(realSize)
      realSize.y != size.y
    } else {
      val menu = ViewConfiguration.get(activity).hasPermanentMenuKey()
      val back = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK)
      !menu && !back
    }
  }


  @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR1)
  fun getNavigationBarHeight(context: Context): Int {
    val dm = DisplayMetrics()
    val wm = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
    wm.defaultDisplay?.getRealMetrics(dm)
    val point = Point()
    wm.defaultDisplay?.getSize(point)
    return dm.heightPixels - point.y
  }


}
