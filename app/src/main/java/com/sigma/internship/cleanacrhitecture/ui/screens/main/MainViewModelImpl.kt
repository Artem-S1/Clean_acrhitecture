package com.sigma.internship.cleanacrhitecture.ui.screens.main

import androidx.lifecycle.MutableLiveData
import domain.models.user.UserLocalModel
import domain.usecase.user.UserUseCase

class MainViewModelImpl(private val useCase: UserUseCase): MainViewModel() {

    override val getUserResponse = MutableLiveData<List<UserLocalModel>>()

    override fun adduser(firstName: String, lastName: String) {
        launchWithProgress(isLoading){
            useCase.addUser(firstName, lastName)
        }
    }

    override fun getUsers() {
       launchWithProgress(isLoading){
           val users = useCase.getUsers()
           getUserResponse.postValue(users)
       }
    }
}