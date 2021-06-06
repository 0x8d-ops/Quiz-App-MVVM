package com.hernandez.parcial2.Model.Dao

import com.hernandez.parcial2.Model.Entity.Question
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface QuestionDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addQuestion(question: Question)

    @Query("SELECT * FROM question_table ORDER BY id ASC")
    fun readAllQuestion(): LiveData<List<Question>>
}