package br.com.reneluan.news.util.gson

import com.google.gson.Gson
import com.google.gson.GsonBuilder


import org.joda.time.DateTime
import org.joda.time.DateTimeZone

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class GsonModule {

    @Provides
    @Singleton
    fun provideDefaultGsonBuilder(): GsonBuilder {
        val gsonBuilder = GsonBuilder()
        
        gsonBuilder.registerTypeAdapter(DateTime::class.java, DateTimeTypeConverter())
        gsonBuilder.registerTypeAdapter(DateTimeZone::class.java, DateTimeZoneTypeConverter()) 
        return gsonBuilder
    }

    @Provides
    @Singleton
    fun provideGson(gsonBuilder: GsonBuilder): Gson {
        return gsonBuilder.create()
    }

}
