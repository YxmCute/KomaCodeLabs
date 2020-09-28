package com.yxmcute.codelabs.customview.basic

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import java.util.logging.Level.parse

/**
 * <pre>
 *     author : LiJun
 *     e-mail : lijunyxm@qq.com
 *     time   : 2020/09/28 17:41
 *     desc   :
 *     link   :
 *     version: 1.0
 * </pre>
 */
class PaintStyleView @JvmOverloads constructor(
  mContext: Context,
  attributeSet: AttributeSet? = null,
  defStyleAttr: Int = 0
) : View(mContext, attributeSet, defStyleAttr) {
  private val paint = Paint(Paint.ANTI_ALIAS_FLAG)

  private var showFillAndStroke = true
  fun changeStyle() {
    showFillAndStroke = true
    invalidate()

  }

  override fun onDraw(canvas: Canvas?) {
    super.onDraw(canvas)

    canvas?.also {
      it.drawColor(Color.LTGRAY)

      if (showFillAndStroke) {
        paint.style = Paint.Style.FILL_AND_STROKE
        paint.color = Color.YELLOW
       // paint.strokeWidth = width / 2.toFloat()
        it.drawCircle(width / 2.toFloat(), height / 2.toFloat(), width / 4.toFloat(), paint)
      } else {
        paint.style = Paint.Style.FILL
        paint.color = Color.BLUE
        it.drawCircle(width / 2.toFloat(), height / 2.toFloat(), width / 2.toFloat(), paint)
      }

      paint.strokeWidth = width / 6.toFloat()
      paint.style = Paint.Style.STROKE
      paint.color = Color.BLACK
    //  it.drawCircle(width / 2.toFloat(), height / 2.toFloat(), width / 4.toFloat(), paint)
      paint.style = Paint.Style.FILL
      paint.color = Color.RED
     // it.drawCircle(width / 2.toFloat(), height / 2.toFloat(), width / 4.toFloat(), paint)

    }
  }
}