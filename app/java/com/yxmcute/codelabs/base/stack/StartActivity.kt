package com.yxmcute.codelabs.base.stack

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.yxmcute.codelabs.databinding.ActivityStackABinding

/**
 * <pre>
 *     author : LiJun
 *     e-mail : lijunyxm@qq.com
 *     time   : 2020/09/02 21:18
 *     desc   :
 *     link   :
 *     version: 1.0
 * </pre>
 */
class StartActivity : AppCompatActivity() {
  companion object {
    const val TAG = "timo"
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    Log.i(
        TAG, "主页 onCreate"
    )

    val binding = ActivityStackABinding.inflate(layoutInflater)
    setContentView(binding.root)
    var count = 0
    binding.tvTitle.setText("主页")
    binding.btbStartOne.setText("打开消息")
    binding.btbStartOne.setOnClickListener {
      val intent = Intent(this, AActivity::class.java)
      if (binding.chkSet.isChecked) {
        //  count++
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
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
      Log.i("主页", "AActivity count= $count")

    }

  }

  override fun onDestroy() {
    super.onDestroy()
    Log.i(
        TAG, "主页 onDestroy"
    )
  }

}