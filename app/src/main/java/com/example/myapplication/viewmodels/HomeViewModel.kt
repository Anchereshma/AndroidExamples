package com.example.myapplication.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.myapplication.model.MultipleResource
import com.example.myapplication.repository.MultipleListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.*
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    application: Application,
    val multipleListRepository: MultipleListRepository
) : AndroidViewModel(application) {
    val multipleResourcesList = MutableLiveData<MultipleResource>()
    var job: Job? = null
    val multipleResourcesLoadError = MutableLiveData<String?>()
    val loading = MutableLiveData<Boolean>()
    val errorMessage = MutableLiveData<String>()
    val exceptionHandler = CoroutineExceptionHandler { coroutineContext, throwable ->
        onError("Exception handled : ${throwable.localizedMessage}")
    }


    fun doGetListResourcesList() {
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = multipleListRepository.doGetListResources()
            withContext(Dispatchers.Main) {
                if (response.isSuccessful) {
                    //Log.d("ANIL",response.body()?.toString() ?: "" )
                    multipleResourcesList.postValue(response.body())
                    loading.value = false
                } else {
                    onError("Error : ${response.message()} ")
                }
            }
        }


    }

    private fun onError(message: String) {
        errorMessage.value = message
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }


}


