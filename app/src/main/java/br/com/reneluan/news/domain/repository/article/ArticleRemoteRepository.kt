package br.com.reneluan.news.domain.repository.article

import javax.inject.Inject

import retrofit2.adapter.rxjava2.Result
import retrofit2.Retrofit
import retrofit2.http.GET

import io.reactivex.Observable

class ArticleRemoteRepository @Inject constructor(retrofit: Retrofit) {

    val service: ArticleService by lazy { retrofit.create(ArticleService::class.java) };

    interface ArticleService {
        @GET("articles")
        fun foo(): Observable<Result<Void>>
    }
}
