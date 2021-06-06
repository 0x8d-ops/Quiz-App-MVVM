package com.hernandez.parcial2.Model.Repository

import com.hernandez.parcial2.Model.Dao.QuestionDao
import com.hernandez.parcial2.Model.Entity.Question
import androidx.lifecycle.LiveData

class QuestionRepository(private val questionDao: QuestionDao) {

    val readAllData: LiveData<List<Question>> = questionDao.readAllQuestion()

    suspend fun addQuestion(question: Question){
        questionDao.addQuestion(question)
    }
}