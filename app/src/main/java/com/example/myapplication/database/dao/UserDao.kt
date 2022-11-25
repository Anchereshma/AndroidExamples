package com.example.myapplication.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.myapplication.database.entity.User

@Dao
interface UserDao {
   @Insert
   fun insert( user: User)
   @Query("SELECT * FROM user")
   fun getAll(): List<User>
   @Delete
   fun delete(user: User)
   @Query("SELECT * FROM user WHERE user.userName LIKE :username")
   fun getUser(username: String): List<User>

   @Query("SELECT * FROM user WHERE user.userName LIKE :username AND password LIKE :passWord")
   fun readAllData(username: String,passWord: String) :List<User>


}