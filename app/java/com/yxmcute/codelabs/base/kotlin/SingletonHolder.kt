package com.yxmcute.codelabs.base.kotlin

/**
 * <pre>
 *     author : Koma
 *     e-mail : lijunyxm@qq.com
 *     time   : 2020/08/06 13:21
 *     desc   :
 *     link   :
 *     version: 1.0
 * </pre>
 */

open class SingletonHolder<out T : Any, in A>(creator: (A) -> T) {
  private var creator: ((A) -> T)? = creator

  @Volatile
  private var instance: T? = null

  fun getInstance(arg: A): T {
    val i = instance
    if (i != null) {
      return i
    }

    return synchronized(this) {
      val i2 = instance
      if (i2 != null) {
        i2
      } else {
        val created = creator!!(arg)
        instance = created
        creator = null
        created
      }
    }
  }
}

