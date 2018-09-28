package com.lijun.basedemo

import android.app.Application
import com.blankj.utilcode.util.Utils

/**
 * @author Koma
 * @date 2018/9/27 11:24
 * @des
 */
class App : Application() {
  override fun onCreate() {
    super.onCreate()
    Utils.init(this)
  }
}