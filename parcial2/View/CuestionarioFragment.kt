package com.hernandez.parcial2.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hernandez.parcial2.R
import com.hernandez.parcial2.databinding.CuestionariofragmentBinding


class CuestionarioFragment : Fragment(R.layout.cuestionariofragment) {

    private var cuestionarioBinding : CuestionariofragmentBinding? = null
    private val cbinding get() = cuestionarioBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        cuestionarioBinding = CuestionariofragmentBinding.inflate(inflater, container, false)
        return  cbinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }

    override fun onDestroy() {
        super.onDestroy()
        cuestionarioBinding = null
    }


}