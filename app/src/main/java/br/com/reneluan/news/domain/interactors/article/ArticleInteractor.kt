package br.com.reneluan.news.domain.interactors.article

import io.reactivex.Scheduler
import br.com.reneluan.news.domain.interactors.base.BaseInteractor
import br.com.reneluan.news.domain.repository.article.ArticleRepository
import br.com.reneluan.news.model.Article

import javax.inject.Inject
import io.reactivex.Observable

class ArticleInteractor @Inject constructor(executor: Scheduler) : BaseInteractor(executor)  {

    @Inject
    lateinit var articleRepository: ArticleRepository

    fun getAllArticles(sourceId: String): Observable<List<Article>>{
        return articleRepository
                .getAllArticles(sourceId)
                .subscribeOn(executor)
    }

}
