package br.com.reneluan.news.di.modules

import dagger.Module
import dagger.Provides
import  br.com.reneluan.news.ui.main.MainActivity

@Module
public class MainModule(val activity: MainActivity) {

    @Provides
    fun provideActivity() : MainActivity{
        return activity
    }

}
