package br.com.reneluan.news.domain.repository.article

import br.com.reneluan.news.model.Article
import br.com.reneluan.news.model.ArticleResponse
import br.com.reneluan.news.util.ExtractResult
import javax.inject.Inject

import retrofit2.adapter.rxjava2.Result
import retrofit2.Retrofit
import retrofit2.http.GET

import io.reactivex.Observable
import retrofit2.http.Query

class ArticleRemoteRepository @Inject constructor(retrofit: Retrofit) {

    val service: ArticleService by lazy { retrofit.create(ArticleService::class.java) };

    fun getAllArticles(sourceId: String): Observable<ArticleResponse> {
        return service
                .getAllArticles(sourceId)
                .compose (ExtractResult<ArticleResponse>())
    }

    interface ArticleService {
        @GET("articles")
        fun getAllArticles(
                @Query("source") sourceId: String
        ): Observable<Result<ArticleResponse>>
    }
}
