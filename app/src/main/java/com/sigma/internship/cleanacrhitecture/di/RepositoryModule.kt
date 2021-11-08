package com.sigma.internship.cleanacrhitecture.di

import data.db.TestDatabase
import data.repository.UserRepositoryImpl
import domain.repository.UserRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

fun repositoryModule() = module {

    single {
        TestDatabase.getInstance(androidApplication())
    }

    single {
        get<TestDatabase>().usersDao()
    }

    single<UserRepository> {
        UserRepositoryImpl(dao = get())
    }
}