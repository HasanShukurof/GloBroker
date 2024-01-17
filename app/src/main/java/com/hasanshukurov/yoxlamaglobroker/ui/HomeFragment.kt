package com.hasanshukurov.yoxlamaglobroker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.hasanshukurov.yoxlamaglobroker.R
import com.hasanshukurov.yoxlamaglobroker.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.minikAvtomobiliImageView.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToCarFragment())
        }

        binding.yukAvtomobiliImageView.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToTruckFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}