package br.com.reneluan.news.ui.article

import android.os.Bundle;
import br.com.reneluan.news.di.ActivityScope
import br.com.reneluan.news.ui.base.BaseActivity
import br.com.reneluan.news.di.HasComponent
import br.com.reneluan.news.R
import br.com.reneluan.news.application.App
import br.com.reneluan.news.di.components.DaggerArticleComponent
import br.com.reneluan.news.di.components.ArticleComponent
import br.com.reneluan.news.di.modules.ArticleModule


import javax.inject.Inject

@ActivityScope
class ArticleActivity : BaseActivity<ArticlePresenter>(), ArticleView, HasComponent<ArticleComponent> {

    @Inject
    lateinit var articlePresenter: ArticlePresenter

    lateinit var articleComponent: ArticleComponent

    override fun injectModule() {
        articleComponent = DaggerArticleComponent.builder().applicationComponent(App.get(this).getComponent()).articleModule(ArticleModule(this)).build()
        articleComponent.inject(this)
        
    }

    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_article
    }

    override fun getComponent():  ArticleComponent {
        return articleComponent
    }

    
    override fun onResume() {
        super.onResume()
        getPresenter().takeView(this)
    }

    override fun onPause() {
        super.onPause()
        getPresenter().dropView()
    }

    override fun getPresenter(): ArticlePresenter = articlePresenter
}
