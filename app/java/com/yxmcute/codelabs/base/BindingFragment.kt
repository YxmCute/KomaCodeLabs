package com.yxmcute.codelabs.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import java.lang.reflect.InvocationTargetException
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * <pre>
 *     author : LiJun
 *     e-mail : lijunyxm@qq.com
 *     time   : 2020/09/10 13:54
 *     desc   :
 *     link   :
 *     version: 1.0
 * </pre>
 */
abstract class BaseBindingFragment< T : ViewBinding> : Fragment() {
  private var _viewBinding: T? = null
  val viewBinding get() = _viewBinding!!

  lateinit var myContext: Context
  override fun onAttach(context: Context) {
    super.onAttach(context)
    myContext = context
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val superclass: Type? = javaClass.genericSuperclass
    val aClass = (superclass as ParameterizedType?)?.actualTypeArguments
        ?.get(0) as Class<*>?
    try {
      aClass?.also {
        val method: Method = aClass.getDeclaredMethod(
            "inflate", LayoutInflater::class.java, ViewGroup::class.java,
            Boolean::class.javaPrimitiveType
        )
        _viewBinding = method.invoke(null, layoutInflater, container, false) as T
        return viewBinding.root
      }
    } catch (e: NoSuchMethodException) {
      e.printStackTrace()
    } catch (e: IllegalAccessException) {
      e.printStackTrace()
    } catch (e: InvocationTargetException) {
      e.printStackTrace()
    }

    return super.onCreateView(inflater, container, savedInstanceState)
  }

  override fun onDestroyView() {
    _viewBinding = null
    super.onDestroyView()

  }
}