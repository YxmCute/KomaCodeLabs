package com.yxmcute.liba

import android.content.Context
import android.util.Log
import androidx.startup.Initializer

/**
 * @author Koma
 * @date 2020/6/14 12:07
 * @filename  AppInitializer
 * @description
 */
class LibAInitializer : Initializer<LibAInitializer.Dependency> {
  override fun create(context: Context): Dependency {
    Log.i("timo", "LibAInitializer-> create()")
    return Dependency(context)
  }

  override fun dependencies(): List<Class<out Initializer<*>>> {
    return emptyList()
  }

  class Dependency(context: Context) {
    init {
      Log.i("timo", "LibAInitializer Dependency-> init()")

      isInitialized = true
    }

    companion object {

      var isInitialized = false
    }
  }
}