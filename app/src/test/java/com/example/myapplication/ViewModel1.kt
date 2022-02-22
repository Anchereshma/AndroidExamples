package com.example.myapplication

import android.app.Application
import android.content.Context
import androidx.constraintlayout.utils.widget.MockView
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.test.core.app.ApplicationProvider
import com.example.myapplication.viewmodels.SignUpFragmentViewModel
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
open class ViewModel1 {

    @get:Rule
     val rule: MockitoRule = MockitoJUnit.rule()

 /*   @Mock
    lateinit var view:View*/
    @Mock
    lateinit var navController: NavController

    @Test
    fun test() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val mockview = MockView(context)
        val navController = TestNavHostController(context)
        //Given
        val signUpFragmentViewModel =
            SignUpFragmentViewModel(context as Application)
        signUpFragmentViewModel.enterUserName.set("raaviswami")
        signUpFragmentViewModel.setPassword.set("anil1234")
        signUpFragmentViewModel.enterEmail.set("raavi.swami@gmail.com")
        signUpFragmentViewModel.enterMobileNumber.set("9491020302")
       // Navigation.findNavController(view)
        Navigation.setViewNavController(mockview, navController)
        //Mockito.`when`(mockview.findNavController()).thenReturn(navController)

        //When
        signUpFragmentViewModel.onSignUpButtonClick(mockview)

        //Then
        Assert.assertEquals(10, 10)
    }
}