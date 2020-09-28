package com.yxmcute.codelabs.base.permission

import android.Manifest
import android.content.pm.PackageManager
import android.content.pm.PermissionInfo
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.yxmcute.codelabs.databinding.ActivityAskPermissionBinding
import com.yxmcute.codelabs.databinding.ActivityStackABinding
import java.security.Permission

/**
 * <pre>
 *     author : LiJun
 *     e-mail : lijunyxm@qq.com
 *     time   : 2020/09/03 15:50
 *     desc   :
 *     link   :
 *     version: 1.0
 * </pre>
 */
class AskPermissionUI : AppCompatActivity() {
  companion object {
    const val TAG = "AskPermissionUI"
  }

  override fun onCreate(
    savedInstanceState: Bundle?
  ) {
    super.onCreate(savedInstanceState)
    val binding = ActivityAskPermissionBinding.inflate(layoutInflater)
    setContentView(binding.root)
    binding.btnAskCamera.setOnClickListener {
      //

      if (ContextCompat.checkSelfPermission(
              this, Manifest.permission.CAMERA
          ) != PackageManager.PERMISSION_GRANTED
      ) {
        Log.i(TAG, "没权限，开始请求")
        ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.CAMERA), 65535)
      } else {
        Log.i(TAG, "有权限")
      }

    }
  }

  override fun onRequestPermissionsResult(
    requestCode: Int,
    permissions: Array<out String>,
    grantResults: IntArray
  ) {
    super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    if (requestCode == 65535) {
      if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
      } else if (grantResults[0] == PackageManager.PERMISSION_DENIED) {

      }
    }

  }
}