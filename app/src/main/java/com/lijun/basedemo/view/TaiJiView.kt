package com.lijun.basedemo.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

/**
 * @author Koma
 * @date 2018/10/8 16:07
 * @des
 */
class TaiJiView(context: Context, attr: AttributeSet? = null) : View(context, attr) {
  private val wPaint = Paint()
  private val bPaint = Paint()
  private var mWidth: Int = 0
  private var mHeight: Int = 0
  private var degrees = 0f

  init {
    wPaint.color = Color.WHITE
    wPaint.isAntiAlias = true
    wPaint.style = Paint.Style.FILL
    bPaint.color = Color.BLACK
    bPaint.isAntiAlias = true
    bPaint.style = Paint.Style.FILL

  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    mWidth = w
    mHeight = h

  }

  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    canvas.translate((width / 2).toFloat(), (height / 2).toFloat())
    canvas.drawColor(Color.GRAY)
    canvas.rotate(degrees)
    val radius: Float = (min(width / 2, height / 2) - 30).toFloat()
    val rectF = RectF(-radius, -radius, radius, radius)
    canvas.drawArc(rectF, 0f, 180f, true, wPaint)
    canvas.drawArc(rectF, -180f, 180f, true, bPaint)
    val smallRadius = radius / 2
    canvas.drawCircle(smallRadius, 0f, smallRadius, wPaint)
    canvas.drawCircle(-smallRadius, 0f, smallRadius, bPaint)
    canvas.drawCircle(smallRadius, 0f, smallRadius / 4, bPaint)
    canvas.drawCircle(-smallRadius, 0f, smallRadius / 4, wPaint)

  }

  fun setRotate(degress: Float) {
    this.degrees = degress
    invalidate()
  }

}