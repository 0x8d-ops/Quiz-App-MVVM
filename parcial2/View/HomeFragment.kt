package com.hernandez.parcial2.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.hernandez.parcial2.R
import com.hernandez.parcial2.databinding.HomeFragmentBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment(R.layout.home_fragment) {

    private var _binding : HomeFragmentBinding ? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.crearPreguntaLinkButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_crearPreguntaFragment)
        }
        binding.enterButton.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_homeFragment_to_cuestionarioFragment)
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding= null
    }
}