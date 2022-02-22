package com.example.myapplication.viewmodels

import android.app.Application
import android.util.Log
import android.view.View
import androidx.databinding.ObservableField
import androidx.lifecycle.AndroidViewModel
import androidx.navigation.findNavController
import com.example.myapplication.R
import com.example.myapplication.database.entity.User
import com.example.myapplication.repository.UserRepository

/**
 * ViewModel for [SignUpFragment].
 */
class SignUpFragmentViewModel(application: Application) : AndroidViewModel(application) {
    private val TAG = "SignUpFragmentViewModel"
    val enterUserName = ObservableField<String>()

    val enterMobileNumber = ObservableField<String>()

    val enterEmail = ObservableField<String>()

    val setPassword = ObservableField<String>()

    val userRepository = UserRepository(getApplication())


    /** Handles signup button.*/
    fun onSignUpButtonClick(v: View) {
        if (enterUserName.get() != null && enterMobileNumber.get() != null && enterEmail.get()
            != null && setPassword.get()
            != null
        ) {
            userRepository.insert(
                User(
                    0,
                    enterUserName.get() as String,
                    enterMobileNumber.get() as String,
                    enterEmail.get() as String,
                    setPassword.get() as String
                )
            )
            Log.d(TAG, "onSignUpButtonClick: " + userRepository.getAll())
            Log.d(TAG, "new user : " + userRepository.getUser(enterUserName.get().toString()))
            v.findNavController().navigate(R.id.action_signUpFragemnt_to_logInFragment)
        }

    }

    /** Handles login button.*/
    fun onLogInButtonClick(v: View) {
        v.findNavController().navigate(R.id.action_signUpFragemnt_to_logInFragment)
        //  Navigate user to login Fragment using Navigation component.
    }

    override fun onCleared() {

        super.onCleared()
    }

}