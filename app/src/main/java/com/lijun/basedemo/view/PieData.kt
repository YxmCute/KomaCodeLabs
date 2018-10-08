package com.lijun.basedemo.view

/**
 * @author Koma
 * @date 2018/9/30 16:52
 * @des
 */
data class PieData(val name: String, val value: Float) {
  var percent: Float = 0.0f
  var color: Int = 0
  var angle: Float = 0.0f
}