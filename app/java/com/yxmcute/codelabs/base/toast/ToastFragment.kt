package com.yxmcute.codelabs.base.toast

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.yxmcute.codelabs.R
import kotlinx.android.synthetic.main.custom_view_toast.*
import kotlinx.android.synthetic.main.fragment_toast.*
import kotlinx.android.synthetic.main.fragment_toast.tv_change_position
import kotlinx.android.synthetic.main.fragment_toast.tv_custom_view_toast

/**
 * @author Koma
 * @date 2020/6/25 23:30
 * @filename  ToastFragment
 * @description https://developer.android.google.cn/guide/topics/ui/notifiers/toasts#kotlin
 */
class ToastFragment : Fragment() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

    return inflater.inflate(R.layout.fragment_toast, container, false)
  }

  override fun onViewCreated(v: View, savedInstanceState: Bundle?) {
    super.onViewCreated(v, savedInstanceState)
    tv_default_toast.setOnClickListener {
      Toast.makeText(context, R.string.default_toast, Toast.LENGTH_SHORT).show()
    }
    tv_change_position.setOnClickListener {
      val toast = Toast.makeText(context, R.string.default_toast, Toast.LENGTH_SHORT)
      toast.setGravity(Gravity.TOP, 0, 100)
      toast.show()

    }
    tv_custom_view_toast.setOnClickListener {
      val customView = layoutInflater.inflate(R.layout.custom_view_toast, custom_toast_container)
      /*val toast = Toast.makeText(context, R.string.default_toast, Toast.LENGTH_SHORT)
      toast.view = customView
      toast.setGravity(Gravity.CENTER, 0, 0)
      toast.show()*/
      with(Toast(context)) {
        setGravity(Gravity.CENTER, 0, 0)
        duration = Toast.LENGTH_SHORT
        view = customView
        show()
      }

    }
  }
}