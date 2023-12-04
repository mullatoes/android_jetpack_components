package com.example.seniorandroiddev.navigationComponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.seniorandroiddev.R
import com.example.seniorandroiddev.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.button2.setOnClickListener {
            val bundle = bundleOf("user_input" to binding.editTextText.toString())
            it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)
        }
        return binding.root
    }

}