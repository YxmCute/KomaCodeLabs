package com.lijun.basedemo.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.blankj.utilcode.util.ToastUtils
import com.lijun.basedemo.R
import com.lijun.basedemo.view.PieData
import kotlinx.android.synthetic.main.fragment_customview.*

/**
 * @author Koma
 * @date 2018/10/8 14:41
 * @des
 */
class CustomViewFragment : Fragment() {
  private var rootView: View? = null

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    rootView ?: let {
      rootView = inflater.inflate(R.layout.fragment_customview, container, false)
    }
    return rootView
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    val datas = mutableListOf<PieData>()
    datas.add(PieData("历史", 20f))
    datas.add(PieData("数学", 40f))
    datas.add(PieData("语文", 60f))
    datas.add(PieData("生物", 80f))
    pieview.setData(datas)
    pieview.setOnClickListener { ToastUtils.showShort("hihihi") }
   // taijiview.setRotate(50f)
    val handler = @SuppressLint("HandlerLeak")
    object : Handler() {
      private var degrees = 0f
      override fun handleMessage(msg: Message) {
        super.handleMessage(msg)
        taijiview.setRotate(degrees+=5f)
        this.sendEmptyMessageDelayed(0, 80)
      }
    }
    handler.sendEmptyMessageDelayed(0, 20)
  }
}