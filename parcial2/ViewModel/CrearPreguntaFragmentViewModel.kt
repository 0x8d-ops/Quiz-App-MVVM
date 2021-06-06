package com.hernandez.parcial2.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.hernandez.parcial2.Model.Entity.Question
import com.hernandez.parcial2.Model.Database.QuestionDB
import com.hernandez.parcial2.Model.Repository.QuestionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CrearPreguntaFragmentViewModel(application: Application): AndroidViewModel(application){

    private val readAllData: LiveData<List<Question>>
    private val repository: QuestionRepository

    init {
        val questionDao = QuestionDB.getQuestionDatabase(application).questionDao()
        repository = QuestionRepository(questionDao)
        readAllData = repository.readAllData
    }

    fun addQuestion(question: Question){
        viewModelScope.launch(Dispatchers.IO){
            repository.addQuestion((question))
        }
    }
}