package com.hernandez.parcial2.Model.Database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hernandez.parcial2.Model.Dao.UserDao
import com.hernandez.parcial2.Model.Entity.User

@Database(entities =  [User::class], version = 1, exportSchema = false)
abstract class UserDB : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object{
        @Volatile
        private var INSTANCE: UserDB? = null

        fun getUserDataBase(context: Context): UserDB{
            val tempInstance = INSTANCE
            if(tempInstance != null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext, UserDB::class.java,
                    "user_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}