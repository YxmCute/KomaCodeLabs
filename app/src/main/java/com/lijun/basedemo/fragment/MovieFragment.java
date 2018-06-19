package com.lijun.basedemo.fragment;

import android.view.View;
import com.lijun.base.fragment.BaseLazyLoadFragment;

/**
 * @author Koma
 */
public class MovieFragment extends BaseLazyLoadFragment {
  @Override protected int setContentView() {
    return 0;
  }


  @Override protected void init(View view) {

  }


  @Override protected void printLifeLog(boolean isPrint) {
    super.printLifeLog(true);
  }
}
