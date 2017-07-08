package br.com.reneluan.news.di.components

import dagger.Component;
import br.com.reneluan.news.di.ActivityScope;
import br.com.reneluan.news.di.modules.ArticleModule;
import br.com.reneluan.news.ui.article.ArticleActivity;

// android-hipster-needle-component-injection-import

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class), modules = arrayOf(ArticleModule::class))
interface ArticleComponent {

    fun inject(activity: ArticleActivity)

    // android-hipster-needle-component-injection-method

}
