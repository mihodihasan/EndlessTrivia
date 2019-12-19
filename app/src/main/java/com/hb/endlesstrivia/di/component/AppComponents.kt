package com.hb.endlesstrivia.di.component

import android.content.Context
import com.hb.endlesstrivia.data_source.local.AppDao
import com.hb.endlesstrivia.data_source.local.AppDb
import com.hb.endlesstrivia.di.modules.*
import com.hb.endlesstrivia.ui.details.DetailsTriviaActivity
import com.hb.endlesstrivia.ui.filter_trivia.FilterTriviaActivity
import com.hb.endlesstrivia.ui.list_trivia.MainActivity
import com.hb.endlesstrivia.ui.onbaording.OnboardingActivity
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AppModule::class,
        NetworkModule::class,
        RepositoryModule::class,
        CoroutinesModule::class,
        StorageModule::class
    ]
)
interface AppComponents {
    fun context(): Context

    fun retrofit(): Retrofit

    fun appDao(): AppDao

    fun appDatabase(): AppDb

    fun inject(mainActivity: MainActivity)
    fun inject(filterTriviaActivity: FilterTriviaActivity)
    fun inject(detailsTriviaActivity: DetailsTriviaActivity)
    fun inject(onboardingActivity: OnboardingActivity)
}