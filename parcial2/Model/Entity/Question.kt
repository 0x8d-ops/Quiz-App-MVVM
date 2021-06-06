package com.hernandez.parcial2.Model.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "question_table")
data class Question (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val qText:String,
    val option1:String,
    val option2:String,
    val option3:String,
    val option4:String,
    val correctAnswer:Int ){

}