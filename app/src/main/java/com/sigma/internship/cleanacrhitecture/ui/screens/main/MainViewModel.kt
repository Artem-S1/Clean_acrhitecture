package com.sigma.internship.cleanacrhitecture.ui.screens.main

import androidx.lifecycle.LiveData
import com.sigma.internship.cleanacrhitecture.ui.base.BaseViewModel
import domain.models.user.UserLocalModel

abstract class MainViewModel: BaseViewModel() {

    abstract fun adduser(firstName: String, lastName: String)
    abstract fun getUsers()
    abstract val getUserResponse: LiveData<List<UserLocalModel>>
}