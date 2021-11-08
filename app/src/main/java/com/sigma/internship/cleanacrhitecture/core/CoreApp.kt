package com.sigma.internship.cleanacrhitecture.core

import android.app.Application
import com.sigma.internship.cleanacrhitecture.di.viewModelModule
import com.sigma.internship.cleanacrhitecture.di.repositoryModule
import com.sigma.internship.cleanacrhitecture.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CoreApp: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CoreApp)
            modules(listOf(repositoryModule(), useCaseModule(), viewModelModule()))
        }
    }
}