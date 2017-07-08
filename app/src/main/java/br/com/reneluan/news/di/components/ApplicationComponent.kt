package br.com.reneluan.news.di.components

import android.content.Context
import com.google.gson.Gson
import dagger.Component
import br.com.reneluan.news.application.App
import br.com.reneluan.news.di.ForApplication
import br.com.reneluan.news.di.modules.AndroidModule
import br.com.reneluan.news.di.modules.ApplicationModule
import br.com.reneluan.news.domain.executors.ThreadExecutor
import br.com.reneluan.news.di.components.DaggerApplicationComponent
import br.com.reneluan.news.network.OkHttpInterceptorsModule
import br.com.reneluan.news.environment.EnvironmentModule
import br.com.reneluan.news.storage.Storage
import br.com.reneluan.news.util.gson.GsonModule
import retrofit2.Retrofit
import io.reactivex.Scheduler
import javax.inject.Singleton

import org.greenrobot.eventbus.EventBus

// android-hipster-needle-component-injection-import

@Singleton
@Component(modules = arrayOf(
                            ApplicationModule::class,
                            AndroidModule::class,
                            OkHttpInterceptorsModule::class,
                            GsonModule::class,
                            EnvironmentModule::class))
interface ApplicationComponent {

    fun provideThreadExecutor(): Scheduler

    fun provideStorage(): Storage

    fun provideRetrofit(): Retrofit

    @ForApplication
    fun provideContext(): Context

    fun provideGson(): Gson

    fun inject(app: App)

    fun provideEventBus(): EventBus

    // android-hipster-needle-component-injection-method

    object Initializer {
        fun init(app: App): ApplicationComponent {
            return DaggerApplicationComponent.builder().androidModule(AndroidModule()).okHttpInterceptorsModule(OkHttpInterceptorsModule()).gsonModule(GsonModule()).applicationModule(ApplicationModule(app)).environmentModule(EnvironmentModule(app)).build()
        }
    }

}
