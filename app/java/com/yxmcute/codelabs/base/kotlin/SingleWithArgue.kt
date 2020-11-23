package com.yxmcute.codelabs.base.kotlin

import android.content.Context
import kotlin.LazyThreadSafetyMode.PUBLICATION

/**
 * <pre>
 *     author : Koma
 *     e-mail : lijunyxm@qq.com
 *     time   : 2020/08/06 12:05
 *     desc   : 一个object就代表一个单例
 *     link   :
 *     version: 1.0
 * </pre>
 */
class SingleWithArgue private constructor(context: Context) {
  companion object : SingletonHolder<SingleWithArgue, Context>(::SingleWithArgue){
    fun  test(context: Context){
      println()
    }

  }

  /*fun test(string: String) {
    println(string)
  }*/
}