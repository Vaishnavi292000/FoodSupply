package com.example.firstkotlinproject

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface Login_DAO {
    @Insert
    fun login(login: UserDetails)

    @Query ("select * from UserDetails")
    fun readlogin():List<UserDetails>

    @Delete
    fun delete(login: UserDetails)
}