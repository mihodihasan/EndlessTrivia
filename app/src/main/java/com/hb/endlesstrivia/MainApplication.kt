package com.hb.endlesstrivia

import android.app.Application
import com.facebook.stetho.Stetho
import com.hb.endlesstrivia.di.component.AppComponents
import com.hb.endlesstrivia.di.component.DaggerAppComponents
import com.hb.endlesstrivia.di.modules.AppModule
import com.hb.endlesstrivia.di.modules.StorageModule
import timber.log.Timber

open class MainApplication : Application() {

    companion object {
        lateinit var appComponents: AppComponents
    }

    override fun onCreate() {
        super.onCreate()
        appComponents = initDagger(this)
        initStetho()
        initTimber()
    }

    private fun initDagger(app: MainApplication): AppComponents =
        DaggerAppComponents.builder()
            .appModule(AppModule(app))
            .storageModule(StorageModule(app))
            .build()

    private fun initStetho() {
        if (BuildConfig.DEBUG)
            Stetho.initializeWithDefaults(this)
    }

    private fun initTimber() {
        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
    }
}