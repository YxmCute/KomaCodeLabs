package com.yxmcute.codelabs.base.handler

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import android.view.View
import com.yxmcute.codelabs.base.BaseBindingFragment
import com.yxmcute.codelabs.databinding.FragmentHandlerBinding
import kotlin.concurrent.thread

/**
 * <pre>
 *     author : Koma
 *     e-mail : lijunyxm@qq.com
 *     time   : 2020/10/28 13:18
 *     desc   :
 *     link   :
 *     version: 1.0
 * </pre>
 */
class HandlerFragment : BaseBindingFragment<FragmentHandlerBinding>() {
  private var handler: Handler? = null
  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    thread {

      Looper.prepare()
      handler = object : Handler() {
        override fun handleMessage(msg: Message) {
          super.handleMessage(msg)
        }
      }
      Looper.loop()

    }.start()
  }
}