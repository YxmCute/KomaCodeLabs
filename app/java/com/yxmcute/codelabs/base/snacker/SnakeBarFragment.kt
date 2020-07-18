package com.yxmcute.codelabs.base.snacker

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import android.widget.Toast
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.yxmcute.codelabs.R
import kotlinx.android.synthetic.main.fragment_snacker.*



/**
 * @author Koma
 * @date 2020/7/5 11:43
 * @filename  SnakeBar
 * @description  SnakeBarFragment
 * @see https://developer.android.google.cn/reference/com/google/android/material/snackbar/Snackbar
 * https://github.com/guoyoujin/MySnackBar
 * https://gitee.com/mengpeng920223/SnackbarUtils
 */
class SnakeBarFragment : Fragment() {
  private lateinit var v: View
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
    v = inflater.inflate(R.layout.fragment_snacker, container, false)
    return v
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    btn_snack_basic.setOnClickListener {
      Snackbar.make(v, "基本使用", Snackbar.LENGTH_SHORT).show()
    }
    btn_snack_color.setOnClickListener {
      val snackbar: Snackbar? = Snackbar.make(v, "看我的字体颜色", Snackbar.LENGTH_SHORT)
      val view = snackbar?.view as FrameLayout
      snackbar?.let {
        view?.setBackgroundColor(Color.RED)
        view?.findViewById<TextView>(R.id.snackbar_text)?.setTextColor(Color.YELLOW)
      }
      snackbar?.show()
    }
    btn_snack_setaction.setOnClickListener {
      val snackbar: Snackbar? = Snackbar.make(v, "看我的Action", Snackbar.LENGTH_SHORT)
      val view = snackbar?.view
      snackbar?.let {
        view?.setBackgroundColor(Color.RED)
        view?.findViewById<TextView>(R.id.snackbar_text)?.setTextColor(Color.YELLOW)
      }
      snackbar?.setAction("确定") {
        val toast = Toast.makeText(context, "点击了确定", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
      }
      snackbar?.setActionTextColor(Color.CYAN)
      snackbar?.show()
    }
    btn_snack_callback.setOnClickListener {
      val snackbar: Snackbar? = Snackbar.make(v, "看我的CallBack", Snackbar.LENGTH_SHORT)
      val view = snackbar?.view
      snackbar?.let {
        view?.setBackgroundColor(Color.RED)
        view?.findViewById<TextView>(R.id.snackbar_text)?.setTextColor(Color.YELLOW)
      }
      snackbar?.setAction("确定") {
        val toast = Toast.makeText(context, "点击了确定", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
      }
      snackbar?.setActionTextColor(Color.CYAN)
      snackbar?.addCallback(object : Snackbar.Callback() {
        override fun onShown(sb: Snackbar?) {
          super.onShown(sb)
          val toast = Toast.makeText(context, "onShown", Toast.LENGTH_SHORT)
          toast.setGravity(Gravity.CENTER, 0, 0)
          toast.show()
        }

        override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
          super.onDismissed(transientBottomBar, event)
          val toast = Toast.makeText(context, "onDismissed event=$event", Toast.LENGTH_SHORT)
          toast.setGravity(Gravity.CENTER, 0, 0)
          toast.show()
        }
      })
      snackbar?.show()
    }
    btn_snack_custom.setOnClickListener { custom() }

  }
  private  fun custom(){
    val snackbar: Snackbar? = Snackbar.make(v, "自定义", Snackbar.LENGTH_SHORT)
    val view = snackbar?.view as FrameLayout
    snackbar?.let {
      //view?.setBackgroundColor(Color.RED)
      val drawable=ContextCompat.getDrawable(context!!,R.mipmap.ic_launcher)

      drawable?.setBounds(0,0,drawable.minimumWidth,drawable.minimumHeight)
      val tv=view?.findViewById<TextView>(R.id.snackbar_text)
      tv.setCompoundDrawables(drawable,null,null,null)
      tv.compoundDrawablePadding=50
      tv.gravity=Gravity.CENTER_VERTICAL

      tv.setTextColor(Color.YELLOW)
    }
    snackbar?.setAction("确定") {
      val toast = Toast.makeText(context, "点击了确定", Toast.LENGTH_SHORT)
      toast.setGravity(Gravity.CENTER, 0, 0)
      toast.show()
    }
    snackbar.setAnimationMode(Snackbar.ANIMATION_MODE_FADE)
    val grid = GradientDrawable()
    grid.shape = GradientDrawable.RECTANGLE
    grid.colors = intArrayOf(ContextCompat.getColor(context!!, R.color.colorAccent), ContextCompat.getColor(context!!, R.color.colorPrimaryDark))
    grid.cornerRadius = 20f
    grid.orientation = GradientDrawable.Orientation.LEFT_RIGHT
    grid.gradientType = GradientDrawable.LINEAR_GRADIENT
    view?.background = grid
    val layoutParams = view.layoutParams
    val clayoutParams = FrameLayout.LayoutParams(layoutParams.width, layoutParams.height)
    clayoutParams.gravity = Gravity.CENTER //垂直居中
    view.layoutParams = clayoutParams
    //snackbar.setAnchorView(btn_snack_setaction)
    snackbar?.show()

  }
}