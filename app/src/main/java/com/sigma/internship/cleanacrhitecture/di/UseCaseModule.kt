package com.sigma.internship.cleanacrhitecture.di

import domain.usecase.user.UserUseCase
import org.koin.dsl.module

fun useCaseModule() = module {

    single {
        UserUseCase(repository = get())
    }
}