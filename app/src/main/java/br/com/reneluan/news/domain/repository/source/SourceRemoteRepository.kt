package br.com.reneluan.news.domain.repository.source

import br.com.reneluan.news.BuildConfig
import br.com.reneluan.news.model.SourceResponse
import br.com.reneluan.news.util.ExtractResult
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.Result
import retrofit2.http.*
import javax.inject.Inject

class SourceRemoteRepository @Inject constructor(retrofit: Retrofit) {

    val service: SourceService by lazy { retrofit.create(SourceService::class.java) }

    fun getAllSources(): Observable<SourceResponse>{
        return service
                .getAllSources()
                .compose(ExtractResult<SourceResponse>())
    }

    interface SourceService {
        @GET("sources")
        fun getAllSources(
//                @Query("apiKey") apiKey: String = BuildConfig.API_KEY
        ): Observable<Result<SourceResponse>>

        @GET("sources")
        fun getSources(
                @Query("category") category: String?
        ): Observable<Result<SourceResponse>>
    }
}