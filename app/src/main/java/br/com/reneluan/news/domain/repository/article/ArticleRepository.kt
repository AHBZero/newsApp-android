package br.com.reneluan.news.domain.repository.article;

import br.com.reneluan.news.model.Article
import io.reactivex.Observable
import javax.inject.Inject;

class ArticleRepository @Inject constructor() {

    @Inject
    lateinit var remoteRepository: ArticleRemoteRepository

    fun getAllArticles(sourceId: String): Observable<List<Article>> {
        return remoteRepository
                .getAllArticles(sourceId)
                .map {
                    it.articles
                }
    }

}
