package com.lijun.basedemo.view

import android.content.Context
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @author Koma
 * @date 2018/9/30 16:55
 * @des
 */
open class PieView(context: Context, attribute: AttributeSet) : View(context, attribute) {
  private val paint = Paint()
  var mWidth: Int = 0
  var mHeight: Int = 0
  var startAngle = 0.0f
  //数据源
  var dataArray = mutableListOf<PieData>()
  //颜色值
  var colorArray = listOf(0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
      0xFFE6B800, 0xFF7CFC00)


  init {
    paint.style = Paint.Style.FILL
    paint.isAntiAlias = true
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    mWidth = w
    mHeight = h

  }
}