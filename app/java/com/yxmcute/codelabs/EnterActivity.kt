package com.yxmcute.codelabs

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.yxmcute.codelabs.base.anim.AnimFragment
import com.yxmcute.codelabs.base.snacker.SnakeBarFragment
import com.yxmcute.codelabs.base.toast.ToastFragment
import com.yxmcute.codelabs.customview.basic.ComparePaintStyleFragment
import com.yxmcute.codelabs.jetpack.workmanager.WorkManagerFragment

/**
 * @author Koma
 * @date 2020/6/25 23:31
 * @filename  EnterActivity
 * @description
 */
class EnterActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_fragment)
    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
          .add(R.id.fl_container, ComparePaintStyleFragment())
          .commit()
    }
  }
}