package com.lijun.basedemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

/**
 * @author Koma
 * @date 2018/9/28 15:09
 * @des
 */
class CanvasView(context: Context, attr: AttributeSet?) : View(context, attr) {
  private val paint = Paint()

  init {
    initPaint()
  }

  private fun initPaint() {

    paint.color = Color.BLACK
    paint.style = Paint.Style.FILL
    paint.strokeWidth = 10f
  }

  override fun onDraw(canvas: Canvas?) {
    super.onDraw(canvas)
    canvas?.drawPoint(150f, 150f, paint)
  }
}