package br.com.reneluan.news.ui.article

import br.com.reneluan.news.domain.interactors.article.ArticleInteractor
import br.com.reneluan.news.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject

class ArticlePresenter @Inject constructor() : BasePresenter<ArticleView>() {

    @Inject
    lateinit var articleInteractor: ArticleInteractor

    fun getAllArticles(sourceId: String) {
        articleInteractor
                .getAllArticles(sourceId)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        {
                            view?.showArticles(it)
                        },
                        {
                            Timber.e(it)
                        }
                )
    }

}
