package com.yxmcute.codelabs.base.toast;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;

/**
 * @author Koma
 * @date 2020/7/1 22:33
 * @filename CustomView
 * @description TODO
 */
public class CustomView extends View {
  private Paint mPaint;


  public CustomView(Context context) {
    super(context);
    init();
  }


  public CustomView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    init();
  }


  public CustomView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
    init();
  }


  private void init() {
    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

  }


  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    canvas.drawColor(Color.GRAY);
    canvas.save();
    mPaint.setStyle(Paint.Style.STROKE);
    mPaint.setStrokeWidth(10f);
    canvas.drawPoint(200, 200, mPaint);
    mPaint.setColor(Color.GREEN);
    canvas.drawLine(0, 0, 100, 100, mPaint);
    canvas.drawLine(100, 100, 200, 100, mPaint);
    Rect rect = new Rect(200, 100, 300, 300);

    mPaint.setColor(Color.BLACK);
    mPaint.setStrokeWidth(1f);
    canvas.drawRect(rect, mPaint);
    RectF rectF=new RectF(300,300,600,700);
    mPaint.setColor(Color.BLUE);
    mPaint.setStyle(Paint.Style.FILL);
    canvas.drawRoundRect(rectF,600,500,mPaint);


  }
}
