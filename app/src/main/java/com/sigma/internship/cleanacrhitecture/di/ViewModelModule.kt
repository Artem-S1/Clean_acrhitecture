package com.sigma.internship.cleanacrhitecture.di

import com.sigma.internship.cleanacrhitecture.ui.screens.main.MainViewModel
import com.sigma.internship.cleanacrhitecture.ui.screens.main.MainViewModelImpl
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule() = module {

    viewModel<MainViewModel> {
        MainViewModelImpl(useCase = get())
    }
}