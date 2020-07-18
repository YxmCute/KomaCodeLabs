package com.yxmcute.codelabs.base.mvp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yxmcute.codelabs.R
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.DaggerActivity
import kotlinx.android.synthetic.main.activity_mvp.button
import javax.inject.Inject
import javax.inject.Named

/**
 * @author Li Jun
 * @date 2020/7/10 23:05
 * @filename  MvpActivity
 * @description
 */
class MvpActivity : AppCompatActivity(), MainView, LoginView {

  @set:Inject
  var mainPresenter: MainPresenter? = null
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_mvp)
    DaggerMainComponent.builder()
        .mainModule(MainModule(this,this))
        .build()
        .inject(this)

    button.setOnClickListener {
      mainPresenter?.loadData()
      mainPresenter?.login("123", "xxx")
    }

  }

  override fun showMainUi() {
    Toast.makeText(this, "showmainui", Toast.LENGTH_SHORT)
        .show()
  }

  override fun login(
    account: String,
    pwd: String
  ) {
    Toast.makeText(this, "$account+$pwd", Toast.LENGTH_LONG)
        .show()

  }
}

class MainPresenter constructor(var view: MainView) {

  @Inject
  constructor(
    view: MainView,
    loginView: LoginView
  ) : this(view) {
    this.loginView = loginView
  }

  var loginView: LoginView? = null

  fun loadData() {
    //调用model层方法，加载数据
    //        ...
    // 回调方法成功时
    view?.showMainUi()

  }

  fun login(
    account: String,
    pwd: String
  ) {
    loginView?.login(account, pwd)

  }
}

interface MainView {
  fun showMainUi()
}

interface LoginView {
  fun login(
    account: String,
    pwd: String
  )
}

@Component(modules = [MainModule::class])
interface MainComponent {
  fun inject(activity: MvpActivity)
}

@Module
class MainModule {
  var view: MainView
  lateinit var loginView: LoginView

  constructor(view: MainView) {
    this.view = view
  }

  constructor(
    view: MainView,
    loginView: LoginView
  ) {
    this.view = view
    this.loginView = loginView
  }


  @Provides
  fun provideMainView() = view


  @Provides
  fun provideLoginView() = loginView

}