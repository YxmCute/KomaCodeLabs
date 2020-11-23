package com.yxmcute.codelabs

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Environment
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.yxmcute.codelabs.base.share.ShareFragment
import java.io.File

/**
 * @author Koma
 * @date 2020/6/25 23:31
 * @filename  EnterActivity
 * @description
 */
class EnterActivity : AppCompatActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
    setContentView(R.layout.activity_fragment)
    val cachePath = this.cacheDir.absolutePath
    val fileDir = this.filesDir.absolutePath
    val ExternalStorageState = Environment.getExternalStorageState()
    val externalCacheDir = this.externalCacheDir
    val StorageDirectory = Environment.getExternalStorageDirectory().absolutePath
    Log.i("timo", "cacheDir=${cachePath},fileDir=${fileDir}")
    Log.i("timo", "externalCacheDir=${externalCacheDir}")
    Log.i("timo", "ExternalStorageState=${ExternalStorageState}")
    Log.i("timo", "StorageDirectory=${StorageDirectory}")

    val file1 = File(
        this.getExternalFilesDir(
            Environment.DIRECTORY_PICTURES
        ), "test"
    )
    if (file1?.mkdirs()) {
      Log.e("timo", "Directory  created")
    } else {
      Log.e("timo", "Directory not created")
    }

    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
          .add(R.id.fl_container, ShareFragment())
          .commit()
    }
    val file = File(this.filesDir, "filename")
    writeTxt2File("hello world", this)

  }

  fun writeTxt2File(
    content: String,
    context: Context
  ) {
    context.openFileOutput("xxx", Context.MODE_PRIVATE)
        .use {
          it.write(content.toByteArray())
        }
    context.openFileInput("xxx")
        .bufferedReader()
        .useLines { lines ->
          lines.fold("") { some, text ->
            "$some\n$text"
          }
        }
    var files: Array<String> = context.fileList()
    files.forEach {
      Log.i("timo", it)

    }

  }
}