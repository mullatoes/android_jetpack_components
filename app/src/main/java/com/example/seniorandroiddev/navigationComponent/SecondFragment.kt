package com.example.seniorandroiddev.navigationComponent

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.seniorandroiddev.R
import com.example.seniorandroiddev.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {


    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false)

        var input = arguments?.getString("user_input")
        binding.textView.text = input.toString()

        return binding.root
    }

}