package br.com.reneluan.news.di.components

import dagger.Component;
import br.com.reneluan.news.di.ActivityScope;
import br.com.reneluan.news.di.modules.SourceModule;
import br.com.reneluan.news.ui.source.SourceActivity;

// android-hipster-needle-component-injection-import

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(SourceModule::class))
interface SourceComponent {

    fun inject(activity: SourceActivity)

    // android-hipster-needle-component-injection-method

}
