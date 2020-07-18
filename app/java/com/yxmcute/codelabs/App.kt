package com.yxmcute.codelabs

import android.app.Application
import android.content.pm.PackageManager
import android.util.Log
import com.yxmcute.codelabs.di.DaggerKomaCodeLabsAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import java.lang.reflect.InvocationTargetException
import javax.inject.Inject

/**
 * @author Koma
 * @date 2020/7/5 22:48
 * @filename  App
 * @description
 */
open class App : Application(), HasAndroidInjector {
  companion object {
    @JvmStatic
    lateinit var instance: App
      private set

    /** Logging tag  */
    const val TAG = "KomaApp"

    /** Key that contains the class name to replace the default application component.  */
    const val COMPONENT_OVERRIDE_KEY = "com.yxmcute.codelabs.application"
  }

  @set:Inject
  internal var androidInjector: DispatchingAndroidInjector<Any>? = null

  override fun onCreate() {
    super.onCreate()
    instance = this
    if (!overrideApplicationComponent(this)) {
      DaggerKomaCodeLabsAppComponent.builder().application(this).build().inject(this)
    }

  }

  private fun overrideApplicationComponent(app: App): Boolean {
    try {
      val applicationInfo = packageManager.getApplicationInfo(packageName, PackageManager.GET_META_DATA)
      val className = applicationInfo.metaData.getString(COMPONENT_OVERRIDE_KEY)
      if (className == null) {
        // Fail early
        Log.i(TAG, "Component override metadata not found, using default component.")
        return false
      }
      Log.i(TAG, className)
      val builderObject = Class.forName(className).getMethod("builder").invoke(null)
      val builderClass: Class<*> = builderObject.javaClass
      builderClass
          .getMethod("application", Application::class.java)
          .invoke(builderObject, app)
      val component = builderClass.getMethod("build").invoke(builderObject)
      component
          .javaClass
          .getMethod("inject", getCatalogApplicationClass())
          .invoke(component, app)
      return true
    } catch (e: PackageManager.NameNotFoundException) {
      Log.e(TAG, "Component override failed with exception:", e)
    } catch (e: ClassNotFoundException) {
      Log.e(TAG, "Component override failed with exception:", e)
    } catch (e: NoSuchMethodException) {
      Log.e(TAG, "Component override failed with exception:", e)
    } catch (e: InvocationTargetException) {
      Log.e(TAG, "Component override failed with exception:", e)
    } catch (e: IllegalAccessException) {
      Log.e(TAG, "Component override failed with exception:", e)
    }
    return false
  }

  protected open fun getCatalogApplicationClass(): Class<out App?>? {
    return App::class.java
  }

  override fun androidInjector(): AndroidInjector<Any> {
    return androidInjector!!
  }
}