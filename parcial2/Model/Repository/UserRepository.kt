package com.hernandez.parcial2.Model.Repository

import androidx.lifecycle.LiveData
import com.hernandez.parcial2.Model.Dao.UserDao
import com.hernandez.parcial2.Model.Entity.User

class UserRepository(private val userDao: UserDao) {

    val readAllData: LiveData<List<User>> = userDao.readAllData()

    suspend fun addUser(user: User){
        userDao.addUser(user)
    }
}