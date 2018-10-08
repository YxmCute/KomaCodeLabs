package com.lijun.basedemo.view

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.util.Log
import android.view.View

/**
 * @author Koma
 * @date 2018/9/30 16:55
 * @des
 */
open class PieView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

  private val paint = Paint()
  var mWidth: Int = 0
  var mHeight: Int = 0
  var startAngle = 0f
  //数据源
  var dataArray = mutableListOf<PieData>()
  //颜色值
  private val colorArray = intArrayOf(-0x330100, -0x9b6a13, -0x1cd9ca, -0x800000, -0x7f8000, -0x7397, -0x7f7f80, -0x194800, -0x830400)
  /*private val colorArray = mutableListOf<String>("0xFFCCFF00", "0xFF6495ED", "0xFFE32636", "0xFF800000", "0xFF808000", "0xFFFF8C69", "0xFF808080",
      "0xFFE6B800", "0xFF7CFC00")*/

  init {
    paint.style = Paint.Style.FILL
    paint.isAntiAlias = true
  }

  override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
    super.onSizeChanged(w, h, oldw, oldh)
    mWidth = w
    mHeight = h

  }

  @SuppressLint("DrawAllocation")
  override fun onDraw(canvas: Canvas) {
    super.onDraw(canvas)
    Log.i("timo", "onDraw"+mWidth)
    Log.i("timo"," width="+width)
    Log.i("timo"," canvas width="+canvas.width)

    if (null == dataArray) {
      return
    }
    var currentAngle = startAngle
    canvas.translate((mWidth / 2).toFloat(), (height / 2).toFloat())

    val r: Float = (Math.min(mWidth, mHeight) / 2 * 0.8).toFloat()
    val rect = RectF(-r, -r, r, r)
    /* for (it in dataArray.indices) {
       paint.color = dataArray[it].color
       val angle = dataArray[it].angle
       canvas.drawArc(rect, currentAngle, angle, true, paint)
       currentAngle += angle
     }*/
    for (it in dataArray) {
      paint.color = it.color
      canvas.drawArc(rect, currentAngle, it.angle, true, paint)
      currentAngle += it.angle
    }
  }

  fun setStartAngle(angle: Int) {
    startAngle = angle.toFloat()
    invalidate()
  }

  fun setData(data: MutableList<PieData>) {
    Log.i("timo", "setData")

    this.dataArray = data
    initData(data)
    invalidate()

  }

  private fun initData(data: MutableList<PieData>) {
    Log.i("timo", "initData")

    if (null == data || data.size == 0)
      return
    var sumValue: Float = 0F
    for (i in data.indices) {
      sumValue += data[i].value
      val color: Int = i % colorArray.size
      data[i].color = colorArray[color]


    }
    var sumAngle: Float = 0F

    for (i in data.indices) {
      val percent = data[i].value / sumValue
      val angle = percent * 360
      data[i].percent = percent
      data[i].angle = angle
      sumAngle += angle
    }

  }


}