package com.lijun.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Koma
 * @date 2018 4-21 1:00
 */
public abstract class BaseLazyLoadFragment extends Fragment {
  //因为setUserVisibleHint 比oncreatedview 先执行
  private boolean isPrepared;
  //标志当前视图是否可见
  private boolean isVisible;
  //加载的根布局
  private View rootView;
  //是否打印生命周期
  private boolean isPrint;
  private final String TAG = this.getClass().getSimpleName();
  //提供butterknife绑定视图
  //private Unbinder unbinder;


  @Override public void onAttach(Context context) {
    super.onAttach(context);

    printLog("onAttach");


  }


  @Override public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    printLog("onCreate");

  }


  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    if (rootView == null) {
      rootView = inflater.inflate(setContentView(), container, false);
      /*unbinder = ButterKnife.bind(this, rootView);
      init();*/
      init(rootView);
      printLog("onCreateView rootView == null");

    }
    ViewGroup parent = (ViewGroup) rootView.getParent();
    if (parent != null) {
      parent.removeView(rootView);
      printLog("onCreateView removeView(rootView)");

    }
    printLog("onCreateView");

    return rootView;

  }


  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    isPrepared = true;
    lazyLoad();
    printLog("onViewCreated");

  }


  @Override public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
    printLog("onActivityCreated");

  }


  @Override public void setUserVisibleHint(boolean isVisibleToUser) {

    super.setUserVisibleHint(isVisibleToUser);
    if (getUserVisibleHint()) {
      printLifeLog(isPrint);

      isVisible = true;
      onVisible();
    } else {

      isVisible = false;
      onInVisible();

    }
    printLog("setUserVisibleHint=" + "isVisibleToUser");

  }


  /**
   * 懒加载
   */
  protected void lazyLoad() {
    if (!isVisible && !isPrepared) {
      return;
    }
    // dosomething
  }


  /**
   * 视图可见
   */
  protected void onVisible() {
    lazyLoad();
  }


  /**
   * 视图不可见
   */

  protected void onInVisible() {}


  /**
   * 是否打印生命周期日志
   */

  protected void printLifeLog(boolean isPrint) {
    this.isPrint = isPrint;
  }


  /**
   * 打印日志
   */
  private void printLog(String msg) {
    if (this.isPrint) {
      Log.d(TAG, "——>" + msg);
    }
  }


  /**
   * @return layoutId
   * 返回布局id
   */
  protected abstract int setContentView();
  /**
   * 初始化布局id
   */
  protected abstract void init(View view);


  @Override public void onStart() {
    super.onStart();
    printLog("onStart");
  }


  @Override public void onResume() {
    super.onResume();
    printLog("onResume");

  }


  @Override public void onPause() {
    super.onPause();
    printLog("onPause");

  }


  @Override public void onStop() {
    super.onStop();
    printLog("onStop");

  }


  @Override public void onDestroyView() {
    super.onDestroyView();
    printLog("onDestroyView");
    /*if (unbinder != null) {
      unbinder.unbind();

    }*/
  }


  @Override public void onDestroy() {
    super.onDestroy();
    printLog("onDestroy");

  }


  @Override public void onDetach() {
    super.onDetach();
    printLog("onDetach");

  }
}
