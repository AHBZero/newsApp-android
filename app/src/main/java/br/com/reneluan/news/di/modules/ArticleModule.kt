package br.com.reneluan.news.di.modules

import dagger.Module
import dagger.Provides
import br.com.reneluan.news.ui.article.ArticleActivity

// android-hipster-needle-module-provides-import


@Module
class ArticleModule(val activity: ArticleActivity) {

    @Provides
    fun provideActivity() : ArticleActivity{
        return activity
    }

    // android-hipster-needle-module-provides-method

}
