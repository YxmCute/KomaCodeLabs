package com.yxmcute.codelabs.base.toast;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import java.util.ArrayList;

/**
 * @author Koma
 * @date 2020/7/1 23:42
 * @filename PieView
 * @description TODO
 */
class PieView extends View {
  // 颜色表 (注意: 此处定义颜色使用的是ARGB，带Alpha通道的)
  private int[] mColors = { 0xFFCCFF00, 0xFF6495ED, 0xFFE32636, 0xFF800000, 0xFF808000, 0xFFFF8C69, 0xFF808080,
      0xFFE6B800, 0xFF7CFC00 };
  private int mWidth, mHeight;
  private float mStartAngle = 0f;
  private ArrayList<PieData> pieDataArrayList;
  private Paint mPaint = new Paint();


  public PieView(Context context) {
    super(context);
  }


  public PieView(Context context, @Nullable AttributeSet attrs) {
    super(context, attrs);
    mPaint.setStyle(Paint.Style.FILL);
    mPaint.setAntiAlias(true);
  }


  public PieView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
  }


  @Override protected void onSizeChanged(int w, int h, int oldw, int oldh) {
    super.onSizeChanged(w, h, oldw, oldh);
    mWidth = w;
    mHeight = h;
  }


  @Override protected void onDraw(Canvas canvas) {
    super.onDraw(canvas);
    if (null==pieDataArrayList){
      return;
    }
    float currentStartAngle=mStartAngle;
    canvas.translate(mWidth/2,mHeight/2);
    

  }


  public void setStartAngle(int startAngle) {
    this.mStartAngle = startAngle;
    invalidate();
  }


  public void setPieData(ArrayList<PieData> pieData) {
    this.pieDataArrayList = pieData;
    initData(pieData);
    invalidate();
  }


  private void initData(ArrayList<PieData> pieData) {
    float sumValue = 0;
    for (int i = 0; i < pieData.size(); i++) {
      sumValue += pieData.get(i).getValue();
      int j = i % mColors.length;
      pieData.get(i).setColor(j);

    }
    float sumAngle = 0;
    for (int i = 0; i < pieData.size(); i++) {
      PieData data = pieData.get(i);
      float percentage = data.getValue() / sumValue;
      float angle = percentage * 360;
      data.setAngle(angle);
      data.setPercentage(percentage);
      sumAngle += angle;

    }

  }
}
