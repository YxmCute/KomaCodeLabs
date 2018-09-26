package com.lijun.basedemo.mvp_one.ui

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.lijun.basedemo.R
import com.lijun.basedemo.mvp_one.LoginVIew
import kotlinx.android.synthetic.main.fragment_login_1.*

/**
 * @author Koma
 * @date 2018/9/26 16:31
 * @des
 */
class LoginFragment : Fragment(), LoginVIew {
  private var mainView: View? = null

  override fun onLoginSuccess(msg: String) {
  }

  override fun onLoginFailed(msg: String) {
  }

  override fun onLoginning(msg: String) {
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
    btn_login.setOnClickListener(object : View.OnClickListener {
      override fun onClick(v: View?) {
        toToast("haah")
      }
    })

  }

  fun toToast(msg: String) {
    Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show()
  }

}