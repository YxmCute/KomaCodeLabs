package com.yxmcute.codelabs.jetpack.startup

import android.content.Context
import android.util.Log
import androidx.startup.Initializer

/**
 * @author Koma
 * @date 2020/6/14 12:07
 * @filename  AppInitializer
 * @description
 */
class AppInitializer : Initializer<AppInitializer.Dependency> {
  override fun create(context: Context): Dependency {
    Log.i("timo", "AppInitializer-> create()")
    return Dependency(context)
  }

  override fun dependencies(): List<Class<out Initializer<*>>> {
    return mutableListOf()
  }

  class Dependency(context: Context) {
    init {
      Log.i("timo", "Dependency-> init()")

      isInitialized = true
    }

    companion object {

      var isInitialized = false
    }
  }
}