package br.com.reneluan.news.network

import android.content.Context
import br.com.reneluan.news.BuildConfig
import br.com.reneluan.news.di.ForApplication
import br.com.reneluan.news.storage.Storage
import okhttp3.*
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Luan on 06/07/2017.
 */
@Singleton
class HttpInterceptor
@Inject
constructor(private val storage: Storage, @ForApplication private val context: Context) : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {

        val url = chain.request().url()
                .newBuilder()
                .addQueryParameter("apiKey", BuildConfig.API_KEY)
                .build()

        var request = chain.request()
        val builder = request.newBuilder()

        builder.addHeader("Content-Type", "application/json")

        request = builder.url(url).build()
        val response = chain.proceed(request)

        if (response.code() == 401) {

        }

        return response
    }

}