package com.xrest.finalassignment


import androidx.room.*
import com.xrest.finalassignment.Class.Person

@Dao
interface UserDAO {

    @Insert
    suspend fun  insert(person: Person)


    @Query("select * from Person where username=(:username) and password = (:password)")
    suspend fun login(username:String,password:String):Person

    @Query("select * from Person")
    suspend fun getPerson():MutableList<Person>

    @Delete
    suspend fun delete(user:Person)
    @Update
    suspend fun update(user:Person)
}