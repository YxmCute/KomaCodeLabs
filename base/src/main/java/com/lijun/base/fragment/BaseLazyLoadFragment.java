package com.lijun.base.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Koma
 * @date 2018 4-21 1:00
 */
public abstract class BaseLazyLoadFragment extends Fragment {
  private boolean isPrepared;
  private boolean isVisible;
  private View rootView;


  @Nullable @Override public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    if (rootView == null) {
      rootView = inflater.inflate(setContentView(), container, false);
      init(rootView);
    }
    ViewGroup parent = (ViewGroup) rootView.getParent();
    if (parent != null) {
      parent.removeView(rootView);
    }

    return rootView;

  }


  @Override public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    isPrepared = true;
    lazyLoad();
  }


  @Override public void setUserVisibleHint(boolean isVisibleToUser) {
    super.setUserVisibleHint(isVisibleToUser);
    if (getUserVisibleHint()) {
      isVisible = true;
      onVisible();
    } else {
      isVisible = false;
      onInVisible();
    }
  }


  protected void lazyLoad() {
    if (!isVisible && !isPrepared) {
      return;
    }
  }


  protected void onVisible() {
    lazyLoad();
  }


  protected void onInVisible() {}


  /**
   * @return layoutId
   *  返回布局id
   */
  protected abstract int setContentView();
  protected abstract void init(View view);
}
