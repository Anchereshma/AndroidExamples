package com.example.myapplication.viewmodels

import android.app.Application
import android.view.View
import android.widget.Toast
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * viewmodel for [LoginFragment]
 */
@HiltViewModel
class LoginFragmentViewModel @Inject constructor(application: Application, val userRepository: UserRepository) : AndroidViewModel(application) {
    val enterUserName = ObservableField<String>()
    val enterPassword = ObservableField<String>()

    fun onLoginButtonClick(view :View) {
        if (enterUserName.get() != null && enterPassword.get() != null) {

            viewModelScope.launch {
                try {
                    val loginResponse = userRepository.readAllData(
                        enterUserName.get() as String,
                        enterPassword.get() as String
                    )
                    if (loginResponse.isNotEmpty()) {
                        Toast.makeText(getApplication(), "Success", Toast.LENGTH_LONG).show()
                        view.findNavController().navigate(R.id.action_logInFragemnt_to_homeFragment)
                    }
                } catch (e: java.lang.Exception) {

                    return@launch

                }
            }
        }
    }



}