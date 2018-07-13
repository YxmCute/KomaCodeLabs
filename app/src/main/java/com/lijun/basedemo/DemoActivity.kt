package com.lijun.basedemo

import android.os.TestLooperManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.lijun.basedemo.listener.TestListener

class DemoActivity : AppCompatActivity(), TestListener {
  private var listener: TestListener? = null


  private fun setListener(listener: TestListener) {
    this.listener = listener
  }


  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_demo)
    setListener(this)
    findViewById<View>(R.id.tv_test).setOnClickListener {
      if (listener != null) {
        listener!!.onTest()
      }
    }

  }


  override fun onTest() {
    Toast.makeText(this, "hi", Toast.LENGTH_LONG).show()
  }
}
