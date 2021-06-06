package com.hernandez.parcial2.View

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.hernandez.parcial2.Model.Entity.Question
import com.hernandez.parcial2.R
import com.hernandez.parcial2.ViewModel.CrearPreguntaFragmentViewModel
import com.hernandez.parcial2.databinding.CrearPreguntaFragmentBinding



class CrearPreguntaFragment : Fragment(R.layout.crear_pregunta_fragment) {

    private lateinit var crearPreguntaViewModel : CrearPreguntaFragmentViewModel
    private var preguntaBinding : CrearPreguntaFragmentBinding? = null
    private val pBinding get() = preguntaBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        crearPreguntaViewModel = ViewModelProvider(this).get(CrearPreguntaFragmentViewModel::class.java)
        preguntaBinding = CrearPreguntaFragmentBinding.inflate(inflater, container, false)
        return pBinding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            pBinding.insertButton.setOnClickListener {
                insertToDatabaseQ()
            }

    }

    private fun insertToDatabaseQ() {
        val questionText = pBinding.questionTextField.text.toString()
        val optionfield1 = pBinding.option1TextField.text.toString()
        val optionfield2 = pBinding.option2TextField.text.toString()
        val optionfield3 = pBinding.option3TextField.text.toString()
        val optionfield4 = pBinding.option4TextField.text.toString()
        val optionCorrect = pBinding.correctOptionTextField.text

       if(inputCheck(questionText, optionfield1, optionfield2, optionfield3, optionfield4,
               optionCorrect!!
           )){

           val question = Question(0, questionText, optionfield1, optionfield2, optionfield3,
               optionfield4, Integer.parseInt(optionCorrect.toString()))

           crearPreguntaViewModel.addQuestion(question)
           Toast.makeText(requireContext(), "Agregada correctamente", Toast.LENGTH_SHORT).show()
       }else{
           Toast.makeText(requireContext(), "Por favor completar todos los datos", Toast.LENGTH_SHORT).show()
       }

    }

    private fun inputCheck(questionText: String, optionfield1: String, optionfield2: String, optionfield3: String,
    optionfield4: String, optionCorrect: Editable): Boolean{

        return !(TextUtils.isEmpty(questionText) && TextUtils.isEmpty(optionfield1) && TextUtils.isEmpty(optionfield3)
                && TextUtils.isEmpty(optionfield2) && TextUtils.isEmpty(optionfield4) && TextUtils.isEmpty(optionCorrect) )

    }

    override fun onDestroy() {
        super.onDestroy()
        preguntaBinding = null
    }



}