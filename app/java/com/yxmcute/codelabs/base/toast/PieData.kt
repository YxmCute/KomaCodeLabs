package com.yxmcute.codelabs.base.toast

/**
 * @author Koma
 * @date 2020/7/1 23:55
 * @filename PieData
 * @description TODO
 */
class PieData(// 用户关心数据
    var name // 名字
    : String, // 数值
    var value: Float) {
  var percentage // 百分比
      = 0f

  // 非用户关心数据
  var color = 0 // 颜色
  var angle = 0f // 角度

}