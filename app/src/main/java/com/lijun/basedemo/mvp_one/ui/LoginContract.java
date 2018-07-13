package com.lijun.basedemo.mvp_one.ui;

import com.lijun.basedemo.mvp_one.base.BasePresenter;
import com.lijun.basedemo.mvp_one.base.BaseView;

/**
 * @author Koma
 * @date 13 41
 * @des
 */
public interface LoginContract {
  interface View extends BaseView<Presenter> {
    void loginError(String msg);
    void loginSuccess();
    void loginStart();
    String getAccount();
    String getPassword();
  }


  interface Presenter extends BasePresenter {
    void login();
  }
}
