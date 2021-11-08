package  com.sigma.internship.cleanacrhitecture.ui.base

import androidx.lifecycle.LiveData

interface BaseVM {

    val isLoading: LiveData<Boolean>
}