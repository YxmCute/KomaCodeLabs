package com.lijun.basedemo.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
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
    paint.style = Paint.Style.STROKE
    paint.strokeWidth = 10f
  }

  @SuppressLint("DrawAllocation")
  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    /*canvas.drawPoint(50f, 50f, paint)
    canvas.drawPoints(floatArrayOf(
        100f, 100f, 100f, 200f, 100f, 300f), paint)
    canvas.drawLine(100f,100f,200f,200f,paint)
    canvas.drawLines(floatArrayOf(50f,50f,100f,50f,70f,70f,100f,70f),paint)
    canvas.drawRect(400f,100f,700f,400f,paint)
    val rectf=RectF(200f,400f,500f,600f)
    paint.color=Color.RED
    canvas.drawRect(rectf,paint)
    paint.color=Color.BLUE
    canvas.drawRoundRect(rectf,150f,100f,paint)
    paint.color=Color.BLACK
    canvas.drawOval(rectf,paint)
    canvas.drawCircle(300f,300f,100f,paint)*/
    val rectF = RectF(100f, 100f, 400f, 400f)
    paint.color = Color.GRAY
    canvas.drawRect(rectF, paint)
    paint.color = Color.GREEN
    canvas.drawArc(rectF, 0f, 40f, false, paint)

  }
}