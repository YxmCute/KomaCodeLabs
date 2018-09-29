package com.lijun.base.util

import android.app.Application
import kotlin.properties.Delegates

/**
 * @author Koma
 * @date 2018/9/29 12:37
 * @des
 */
object Utils {
  private lateinit var instance: Application

  fun init(app: Application) {
    instance = app
  }

  fun getAPP() = instance
}