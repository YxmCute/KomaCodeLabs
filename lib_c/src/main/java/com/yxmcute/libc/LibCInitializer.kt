package com.yxmcute.libc

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import com.yxmcute.libb.LibBInitializer

/**
 * @author Koma
 * @date 2020/6/14 12:07
 * @filename  AppInitializer
 * @description
 */
class LibCInitializer : Initializer<LibCInitializer.Dependency> {
  override fun create(context: Context): Dependency {
    Log.i("timo", "LibCInitializer-> create()")
    return Dependency(context)
  }

  override fun dependencies(): List<Class<out Initializer<*>>> {
    return mutableListOf(LibBInitializer::class.java)
  }

  class Dependency(context: Context) {
    init {
      Log.i("timo", "LibCInitializer Dependency-> init()")

      isInitialized = true
    }

    companion object {

      var isInitialized = false
    }
  }
}