package com.example.myapplication.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.database.entity.User
import com.example.myapplication.database.dao.UserDao

@Database(entities = [User::class], version = 1)
abstract class AppDataBase : RoomDatabase(){
    abstract fun userDao(): UserDao

    companion object {
        // Singleton prevents multiple instances of database opening at the same time.
        const val databaseName:String = "user_database"
    }
}