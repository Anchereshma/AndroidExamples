package com.example.myapplication.viewmodels

import android.app.Application
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel

/**
 * viewmodel for [LoginFragment]
 */

class LoginFragmentViewModel(application: Application) : AndroidViewModel(application) {
    val enterUserName = ObservableField<String>()
    val enterPassword = ObservableField<String>()

    fun onLoginButtonClick(){

    }



}