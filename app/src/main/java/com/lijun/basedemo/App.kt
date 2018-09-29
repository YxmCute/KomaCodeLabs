package com.lijun.basedemo

import android.app.Application
import com.blankj.utilcode.util.Utils
import kotlin.properties.Delegates

/**
 * @author Koma
 * @date 2018/9/27 11:24
 * @des
 */
class App : Application() {
  companion object {
    var instance: App by Delegates.notNull()
  }

  override fun onCreate() {
    super.onCreate()
    instance = this
    Utils.init(this)
  }
}