package br.com.reneluan.news.application

import android.app.Application
import android.content.Context
import android.support.multidex.MultiDex

import br.com.reneluan.news.R
import br.com.reneluan.news.di.ForApplication
import br.com.reneluan.news.di.components.ApplicationComponent
import br.com.reneluan.news.environment.EnvironmentConfiguration

import net.danlew.android.joda.JodaTimeAndroid

import uk.co.chrisjenx.calligraphy.CalligraphyConfig
import com.bumptech.glide.Glide

import javax.inject.Inject


class App : Application() {

    var graph:ApplicationComponent? = null

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    @field:[Inject ForApplication]
    lateinit var context: Context

    @Inject
    lateinit var environmentConfiguration: EnvironmentConfiguration

    override fun onCreate() {
        super.onCreate()

        JodaTimeAndroid.init(this)
        
        
        CalligraphyConfig.initDefault(CalligraphyConfig.Builder().setDefaultFontPath("fonts/Roboto-Regular.ttf").setFontAttrId(R.attr.fontPath).build()) 

        graph = createComponent()
        environmentConfiguration.configure()
    }

    companion object {
        @JvmStatic fun get(context: Context): App {
            return context.applicationContext as App
        }
    }

    fun getComponent(): ApplicationComponent {
        if (graph == null) {
            createComponent()
        }
        return graph!!
    }

    private fun createComponent(): ApplicationComponent {
        val applicationComponent = ApplicationComponent.Initializer.init(this)
        applicationComponent.inject(this)
        return applicationComponent
    }

    fun recreateComponents() {
        graph = ApplicationComponent.Initializer.init(this)
        graph!!.inject(this)
        environmentConfiguration.configure()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)
        Glide.get(this).trimMemory(level)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        Glide.get(this).clearMemory()
    }

}
