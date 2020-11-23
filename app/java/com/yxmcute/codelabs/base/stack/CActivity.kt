package com.yxmcute.codelabs.base.stack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.yxmcute.codelabs.databinding.ActivityStackABinding

/**
 * <pre>
 *     author : Koma
 *     e-mail : lijunyxm@qq.com
 *     time   : 2020/09/02 21:18
 *     desc   :
 *     link   :
 *     version: 1.0
 * </pre>
 */
class CActivity : AppCompatActivity() {
  companion object {
    const val TAG = "timo"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.i(
        TAG, "直播间 onCreate"
    )

    val binding = ActivityStackABinding.inflate(layoutInflater)
    setContentView(binding.root)
    binding.tvTitle.setText("直播间")
    binding.btbStartOne.setText("打开消息 ")
    binding.btbStartTwo.setText("打开个人主页 ")
    binding.btbStartOne.setOnClickListener {
      val intent = Intent(this, AActivity::class.java)
      if (binding.chkSet.isChecked) {
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      }
      startActivity(intent)
    }
    binding.btbStartTwo.setOnClickListener {
      val intent = Intent(this, BActivity::class.java)
      if (binding.chkSet.isChecked) {
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
      }
      startActivity(intent)
    }

  }

  override fun onDestroy() {
    super.onDestroy()
    Log.i(
        TAG, "直播间 onDestroy"
    )
  }

}