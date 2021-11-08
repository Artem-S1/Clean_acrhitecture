package  com.sigma.internship.cleanacrhitecture.ui.base

import android.util.Log
import androidx.annotation.CallSuper
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.*
import java.util.concurrent.ConcurrentHashMap

abstract class BaseViewModel : ViewModel(), BaseVM, CoroutineScope {

    val publicExceptionHandlerLiveData = MutableLiveData<Throwable>()
    private val TAG = BaseViewModel::class.java.simpleName
    override val isLoading: MutableLiveData<Boolean> = MutableLiveData()
    private val indicatorLoaderScopeMap = ConcurrentHashMap<Any, CoroutineScope>()

    override val coroutineContext =
        SupervisorJob() + Dispatchers.IO + CoroutineExceptionHandler { _, throwable ->
            baseExceptionHandler(throwable)
        }

    private fun baseExceptionHandler(throwable: Throwable) {
        Log.e(TAG, throwable.message, throwable)
        publicExceptionHandlerLiveData.postValue(throwable)
    }

    @CallSuper
    open fun onCreated() {
    }

    override fun onCleared() {
        super.onCleared()
        coroutineContext.cancel()
    }

    fun CoroutineScope.launchWithProgress(
        indicatorLiveData: MutableLiveData<Boolean>,
        block: suspend CoroutineScope.() -> Unit
    ): Job = run {
        fun createNewLoaderJob() = launch(start = CoroutineStart.LAZY) {
            indicatorLiveData.postValue(true)
        }.apply {
            invokeOnCompletion {
                indicatorLiveData.postValue(false)
                indicatorLoaderScopeMap.remove(indicatorLiveData)
            }
        }

        val loaderScope = indicatorLoaderScopeMap[indicatorLiveData]
            ?.takeIf { it.isActive }
            ?: (this + createNewLoaderJob())
                .also { coroutineScope ->
                    indicatorLoaderScopeMap[indicatorLiveData] = coroutineScope
                }
        loaderScope.launch {
            block()
        }
    }
}