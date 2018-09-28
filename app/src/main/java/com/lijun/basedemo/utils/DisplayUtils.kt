package com.lijun.basedemo.utils

import android.app.Activity
import android.app.Application
import android.content.ComponentCallbacks
import android.content.res.Configuration

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
}