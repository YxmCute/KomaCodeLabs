package com.yxmcute.codelabs.base.anim

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.yxmcute.codelabs.App
import com.yxmcute.codelabs.R
import kotlinx.android.synthetic.main.fragment_anim.*

/**
 * @author Koma
 * @date 2020/7/5 21:03
 * @filename  AnimFragment
 * @description  Interpolator interpolator = new LinearInterpolator();//匀速
//        Interpolator interpolator = new AccelerateInterpolator();//先慢后快
//        Interpolator interpolator = new AnticipateInterpolator();//开始回弹效果
//        Interpolator interpolator = new BounceInterpolator();//结束回弹效果
//        Interpolator interpolator = new CycleInterpolator(2);//跳一跳效果
//        Interpolator interpolator = new OvershootInterpolator(1);//动画结束时向前弹一定距离再回到原来位置
//        Interpolator interpolator = new AccelerateDecelerateInterpolator();//系统默认的动画效果，先加速后减速
//        Interpolator interpolator = new AnticipateOvershootInterpolator();//开始之前向前甩，结束的时候向后甩


 */
class AnimFragment : Fragment() {
  private val hanlder = Handler(Looper.getMainLooper())
  private lateinit var ainmDrable: AnimationDrawable
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    return inflater.inflate(R.layout.fragment_anim, container, false)
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    btn_ainm_frame.setOnClickListener {
      animDrawable()
    }
    btn_ainm_translate.setOnClickListener {
      translte()
    }
  }

  private fun animDrawable() {
    iv_anim.setImageResource(R.drawable.ainm_drawable)
    ainmDrable = iv_anim.drawable as AnimationDrawable
    ainmDrable.start()
    hanlder.postDelayed(runnable, 5000)

  }

  private val runnable = Runnable { ainmDrable.stop() }

  fun translte() {
    // 使用java代码的方式创建TranslateAnimation，传入六个参数，fromXType、fromXValue、toXType、toXValue和fromYType、fromYValue、toYType、toYValue，使用如下构造方法。
//        参数说明：
//        fromXType：动画开始前的X坐标类型。取值范围为ABSOLUTE（绝对位置）、RELATIVE_TO_SELF（以自身宽或高为参考）、
//        RELATIVE_TO_PARENT（以父控件宽或高为参考）。
//        fromXValue：动画开始前的X坐标值。当对应的Type为ABSOLUTE时，表示绝对位置；否则表示相对位置，1.0表示100%。
//        toXType：动画结束后的X坐标类型。
//        toXValue：动画结束后的X坐标值。
//        fromYType：动画开始前的Y坐标类型。
//        fromYValue：动画开始前的Y坐标值。
//        toYType：动画结束后的Y坐标类型。
//        toYValue：动画结束后的Y坐标值。

    // val translateAnimation = TranslateAnimation(0f, 100f, 0f, 500f)
    val translateAnimation = TranslateAnimation(Animation.RELATIVE_TO_SELF, 0f,
        Animation.RELATIVE_TO_SELF, 0.5f,
        Animation.RELATIVE_TO_SELF, 0f,
        Animation.RELATIVE_TO_SELF, 0.5f)
    translateAnimation.duration = 3000
    //在默认执行一个动画的基础上再加了2次，所以会执行3次
    translateAnimation.repeatCount = 0
    var count = 0
    translateAnimation.interpolator =LinearInterpolator()
    translateAnimation.setAnimationListener(object : Animation.AnimationListener {
      override fun onAnimationRepeat(animation: Animation?) {
        Toast.makeText(App.instance, "动画重复${++count}", Toast.LENGTH_SHORT).show()

      }

      override fun onAnimationEnd(animation: Animation?) {
        Toast.makeText(App.instance, "动画结束", Toast.LENGTH_SHORT).show()

      }

      override fun onAnimationStart(animation: Animation?) {
        Toast.makeText(App.instance, "动画开始", Toast.LENGTH_SHORT).show()
      }
    })
    val alphaAnimation=AlphaAnimation(1f,0f)
    alphaAnimation.duration=3000
    alphaAnimation.startOffset=2000
    iv_anim.startAnimation(alphaAnimation)

  }
}