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
        @Volatile
        private var INSTANCE: AppDataBase? = null
        private const val databaseName:String = "user_database"

        fun getDatabase(context: Context): AppDataBase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    databaseName
                ).allowMainThreadQueries().build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}