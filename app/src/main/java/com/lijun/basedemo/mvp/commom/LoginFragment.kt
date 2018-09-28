package com.lijun.basedemo.mvp.commom

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ProgressBar
import com.blankj.utilcode.util.ToastUtils
import com.lijun.basedemo.R
import kotlinx.android.synthetic.main.fragment_login_1.*

/**
 * @author Koma
 * @date 2018/9/26 16:31
 * @des
 */
class LoginFragment : Fragment(), LoginVIew {
  private var loginPresenterImpl: LoginPresenterImpl
  private val manager: InputMethodManager by lazy {
    activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
  }
  private lateinit var name: String
  private lateinit var password: String
  private lateinit var progressbar: ProgressBar
  private lateinit var edtName: EditText
  private lateinit var edtPassWord: EditText


  init {
    loginPresenterImpl = LoginPresenterImpl(this)
  }

  private var mainView: View? = null

  override fun onLoginSuccess(msg: String) {
    progressbar.visibility = ProgressBar.INVISIBLE
    toToast(msg)

  }

  override fun onLoginFailed(msg: String) {
    progressbar.visibility = ProgressBar.INVISIBLE
    toToast(msg)

  }

  override fun onLogining(msg: String) {
    Log.i("timo", Thread.currentThread().name)
    progressbar.visibility = ProgressBar.VISIBLE
    toToast(msg)

  }

  override fun onLoginComplete(msg: String) {
    toToast(msg)
  }

  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?
                            , savedInstanceState: Bundle?): View? {
    mainView ?: let {
      mainView = inflater.inflate(R.layout.fragment_login_1, container, false)


    }

    return mainView
  }

  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    rootView.viewTreeObserver.addOnPreDrawListener(object : ViewTreeObserver.OnPreDrawListener {
      override fun onPreDraw(): Boolean {
        Log.i("timo", canvasView.width.toString() + "/" + canvasView.height.toString())
        return true
      }


    })

    edtPassWord = edt_password
    edtName = edt_name
    progressbar = progressBar
    name = edtName.text.toString()
    password = edtPassWord.text.toString()
    btn_login.setOnClickListener {

      closeKeyBoard()
      loginPresenterImpl.doLogin(name, password)
    }

  }

  private fun toToast(msg: String) {
    ToastUtils.showShort(msg)
  }

  private fun closeKeyBoard() {
    activity?.currentFocus?.let {
      manager.hideSoftInputFromWindow(it.windowToken, 2)
    }
  }

}