package br.com.reneluan.news.network;

import javax.inject.Singleton

import dagger.Module
import dagger.Provides
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import timber.log.Timber

@Module
class OkHttpInterceptorsModule {

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor { message -> Timber.d(message) }
    }

    @Provides
    @OkHttpInterceptors
    @Singleton
    fun provideOkHttpInterceptors(httpLoggingInterceptor: HttpLoggingInterceptor): Array<Interceptor> {
        return arrayOf(httpLoggingInterceptor)
    }

    @Provides
    @OkHttpNetworkInterceptors
    @Singleton
    fun provideOkHttpNetworkInterceptors(): Array<Interceptor> {
        return arrayOf()
    }
}
