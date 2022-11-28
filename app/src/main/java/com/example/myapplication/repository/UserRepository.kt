package com.example.myapplication.repository

import android.app.Application
import com.example.myapplication.database.AppDataBase
import com.example.myapplication.database.dao.UserDao
import com.example.myapplication.database.entity.User
import javax.inject.Inject

/**
 * Repository to access [UserDao]
 */
class UserRepository @Inject constructor(appDataBase: AppDataBase) {
    private val dao: UserDao = appDataBase.userDao()

    fun insert(user: User){
       dao.insert(user)
    }
    fun delete(user: User){
        dao.delete(user)
    }
    fun getAll(): List<User>{
        return dao.getAll()
    }
    fun getUser(username: String): List<User> {
        return dao.getUser(username)
    }
    fun readAllData(username: String,password:String):List<User>{
        return  dao.readAllData(username, password)
    }


}