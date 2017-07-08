package br.com.reneluan.news.environment;

import android.app.Application
import android.os.StrictMode
import br.com.reneluan.news.BuildConfig;
import br.com.reneluan.news.di.ForApplication;

import timber.log.Timber;
import br.com.reneluan.news.util.logging.CrashReportingTree; 
import javax.inject.Inject
import javax.inject.Singleton
import rx.schedulers.Schedulers

@Singleton
class EnvironmentConfiguration @Inject constructor() {

    @field:[Inject ForApplication]
    lateinit var app: Application

    fun configure() {
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.Builder().detectAll().penaltyLog().build())
        StrictMode.setVmPolicy(StrictMode.VmPolicy.Builder().detectAll().penaltyLog().build())
        
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }
    }

}
