package com.yxmcute.codelabs.di

import android.app.Application
import com.yxmcute.codelabs.App
import dagger.BindsInstance
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * @author Koma
 * @date 2020/7/7 22:03
 * @filename  KomaCodeLabsAppComponet
 * @description
 */
@Singleton
@dagger.Component(modules = [AndroidInjectionModule::class])

public interface KomaCodeLabsAppComponent {

  fun inject(app: App)

  @dagger.Component.Builder
  interface Builder {
    @BindsInstance
    fun application(application: Application): Builder
    fun build(): KomaCodeLabsAppComponent
  }
}