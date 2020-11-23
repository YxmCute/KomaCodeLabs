package com.yxmcute.codelabs.base.kotlin

/**
 * <pre>
 *     author : Koma
 *     e-mail : lijunyxm@qq.com
 *     time   : 2020/09/02 17:09
 *     desc   :
 *     link   : https://kotlinlang.org/docs/reference/delegation.html
 *     version: 1.0
 * </pre>
 */
interface Transform {
  val a: String
  val b: String
}

data class AB(
  override val a: String,
  override val b: String
) : Transform

data class C(
  val ab: AB,
  val c: String
) : Transform by ab {

}

fun main() {
  val b = BaseImp(10)
  Drive(b).print()
  C(AB("1", "2"), "3")
}

interface Base {
  fun print()
}

class BaseImp(val x: Int) : Base {
  override fun print() {
    print(x)
  }
}

class Drive(b: BaseImp) : Base by b