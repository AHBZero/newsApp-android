package br.com.reneluan.news.environment;

import br.com.reneluan.news.network.OkHttpInterceptors
import br.com.reneluan.news.network.OkHttpNetworkInterceptors
import br.com.reneluan.news.di.ForApplication
import br.com.reneluan.news.BuildConfig
import br.com.reneluan.news.application.App


import android.app.Application
import android.content.Context
import android.support.annotation.NonNull
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
class EnvironmentModule(val app: App) {

    @Provides
    @Singleton
    fun provideOkHttpClient(@ForApplication app: Context,
                                     @OkHttpInterceptors @NonNull interceptors: Array<Interceptor>,
                                     @OkHttpNetworkInterceptors @NonNull networkInterceptors: Array<Interceptor>): OkHttpClient {

        val cacheDir = File(app.cacheDir, "http")
        val cache = Cache(cacheDir, 1000000)

        val okHttpBuilder = OkHttpClient.Builder()

        for (interceptor in interceptors) {
            okHttpBuilder.addInterceptor(interceptor)
        }

        for (networkInterceptor in networkInterceptors) {
            okHttpBuilder.addNetworkInterceptor(networkInterceptor)
        }

        okHttpBuilder.cache(cache)
        okHttpBuilder.readTimeout(30, TimeUnit.SECONDS)
        okHttpBuilder.writeTimeout(30, TimeUnit.SECONDS)
        okHttpBuilder.connectTimeout(30, TimeUnit.SECONDS)

        return okHttpBuilder.build()

    }

    @Provides
    @Singleton
    fun provideRestAdapter(okHttpClient: OkHttpClient, gson: Gson): Retrofit  {
        val restAdapter = Retrofit.Builder()
                .baseUrl(BuildConfig.API_ENDPOINT_LOCAL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build()
        return restAdapter
    }

    

}
