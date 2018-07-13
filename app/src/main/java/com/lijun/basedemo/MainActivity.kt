package com.lijun.basedemo

import android.app.SearchManager
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.lijun.basedemo.listener.TestListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener,TestListener {
  override fun onTest() {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }


  override fun onClick(p0: View?) {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  var testListener: TestListener? = null
  fun setListener(listener: TestListener) {
    this.testListener = listener
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    this.setListener(this)
    tv_test.setOnClickListener({
      this.testListener!!.onTest()
    })
  }
}
