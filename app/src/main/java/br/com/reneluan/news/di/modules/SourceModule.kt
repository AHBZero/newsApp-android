package br.com.reneluan.news.di.modules

import dagger.Module
import dagger.Provides
import br.com.reneluan.news.ui.source.SourceActivity

// android-hipster-needle-module-provides-import


@Module
class SourceModule(val activity: SourceActivity) {

    @Provides
    fun provideActivity() : SourceActivity{
        return activity
    }

    // android-hipster-needle-module-provides-method

}
