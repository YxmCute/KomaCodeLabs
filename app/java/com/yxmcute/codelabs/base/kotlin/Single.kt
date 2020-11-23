package com.yxmcute.codelabs.base.kotlin

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
class Single private constructor() {
  companion object {
    val INSTANCE: Single by lazy { Single() }
    // val INSTANCE: Single by lazy (mode = PUBLICATION){ Single() }
  }

  /*
  * 上面代码所示 mode = LazyThreadSafetyMode.SYNCHRONIZED，lazy 默认的模式，可以省掉，这个模式的意思是：如果有多个线程访问，只有一条线程可以去初始化 lazy 对象。


当 mode = LazyThreadSafetyMode.PUBLICATION 表达的意思是：对于还没有被初始化的 lazy 对象，可以被不同的线程调用，如果 lazy 对象初始化完成，其他的线程使用的是初始化完成的值。


mode = LazyThreadSafetyMode.NONE 表达的意思是：只能在单线程下使用，不能在多线程下使用，不会有锁的限制，也就是说它不会有任何线程安全的保证以及相关的开销。

*/
  fun test() {}
}