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
class AActivity : AppCompatActivity() {
  companion object {
    const val TAG = "timo"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.i(
        TAG, "消息 onCreate"
    )

    val binding = ActivityStackABinding.inflate(layoutInflater)
    setContentView(binding.root)
    var count = 0
    binding.tvTitle.setText("消息")
    binding.btbStartOne.setText("打开个人主页")
    binding.btbStartTwo.setText("打开直播间")
    binding.btbStartOne.setOnClickListener {
      val intent = Intent(this, BActivity::class.java)
      if (binding.chkSet.isChecked) {
        //  count++
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        //  intent.putExtra("count", count)
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

      }
      startActivity(intent)
    }
    binding.btbStartTwo.setOnClickListener {
      val intent = Intent(this, CActivity::class.java)
      if (binding.chkSet.isChecked) {
        //  count++
        /* intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
         intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)*/
        //  intent.putExtra("count", count)
        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

      }
      startActivity(intent)
    }

  }

  override fun onNewIntent(intent: Intent?) {
    super.onNewIntent(intent)
    intent?.also {
      val count = it.getIntExtra("count", -1)
      Log.i("消息", "AActivity count= $count")

    }

  }

  override fun onDestroy() {
    super.onDestroy()
    Log.i(
        TAG, "消息 onDestroy"
    )
  }

}