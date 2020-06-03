package com.example.firstkotlinproject

import androidx.room.Database
import androidx.room.RoomDatabase

@Database (entities = [(UserDetails::class)] ,version = 1)
abstract class AppDB: RoomDatabase() {
    abstract fun loginDao():Login_DAO
}