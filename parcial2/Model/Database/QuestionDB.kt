package com.hernandez.parcial2.Model.Database

import com.hernandez.parcial2.Model.Dao.QuestionDao
import com.hernandez.parcial2.Model.Entity.Question
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Question::class], version = 1, exportSchema = false)
abstract class QuestionDB: RoomDatabase() {

    abstract fun questionDao(): QuestionDao

    companion object{
        private var INSTANCE: QuestionDB? = null
        fun getQuestionDatabase(context: Context): QuestionDB {
            val tempInstance = INSTANCE
            if(tempInstance!=null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    QuestionDB::class.java,
                    "question_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}