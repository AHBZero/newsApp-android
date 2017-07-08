package br.com.reneluan.news.di.components

import dagger.Component
import br.com.reneluan.news.di.ActivityScope
import br.com.reneluan.news.di.modules.MainModule
import br.com.reneluan.news.ui.main.MainActivity
import br.com.reneluan.news.ui.main.MainFragment

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(MainModule::class))
interface MainComponent {

  fun inject(activity: MainActivity)
  fun inject(fragment: MainFragment)

}

