package com.yxmcute.codelabs.base.share

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.yxmcute.codelabs.base.BaseBindingFragment
import com.yxmcute.codelabs.databinding.FragmentShareBinding

/**
 * <pre>
 *     author : Koma
 *     e-mail : lijunyxm@qq.com
 *     time   : 2020/11/23 17:09
 *     desc   :
 *     link   :
 * </pre>
 */
class ShareFragment : BaseBindingFragment<FragmentShareBinding>() {

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
    viewBinding.btnShareText.setOnClickListener {
      val sendIntent: Intent = Intent().apply {
        action = Intent.ACTION_SEND
        putExtra(Intent.EXTRA_TEXT, "This is my text to send.")
        type = "text/plain"
      }

      val shareIntent = Intent.createChooser(sendIntent, "Hello")
      startActivity(shareIntent)
    }
  }
}