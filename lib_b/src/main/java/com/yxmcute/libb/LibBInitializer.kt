package com.yxmcute.libb

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.yxmcute.liba.LibAInitializer

/**
 * @author Koma
 * @date 2020/6/14 12:07
 * @filename  AppInitializer
 * @description
 */
class LibBInitializer : Initializer<LibBInitializer.Dependency> {
  override fun create(context: Context): Dependency {
    Log.i("timo", "LibBInitializer-> create()")
    return Dependency(context)
  }

  override fun dependencies(): List<Class<out Initializer<*>>> {
    return mutableListOf(LibAInitializer::class.java)
  }

  class Dependency(context: Context) {
    init {
      Log.i("timo", "LibBInitializer Dependency-> init()")

      isInitialized = true
    }

    companion object {

      var isInitialized = false
    }
  }
}