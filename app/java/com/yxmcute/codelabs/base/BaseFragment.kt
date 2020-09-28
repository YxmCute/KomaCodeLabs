package com.yxmcute.codelabs.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.annotation.LayoutRes
import dagger.android.support.DaggerFragment

/**
 * @author Koma
 * @date 2020/7/7 23:03
 * @filename  BaseFragment
 * @description
 */
open class BaseFragment(@LayoutRes val layoutId: Int = -1) : DaggerFragment() {
  protected var rootView: View? = null
  override fun onAttach(context: Context) {
    super.onAttach(context)
    //https://developer.android.google.cn/reference/kotlin/androidx/activity/OnBackPressedDispatcher
    requireActivity().onBackPressedDispatcher.addCallback(object : OnBackPressedCallback(true) {
      override fun handleOnBackPressed() {

      }
    })
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    rootView = if (layoutId != -1) {
      inflater.inflate(layoutId, container, false)
    } else {
      super.onCreateView(inflater, container, savedInstanceState)
    }
    return rootView
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)
  }

}