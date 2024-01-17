package com.hasanshukurov.yoxlamaglobroker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.hasanshukurov.yoxlamaglobroker.R
import com.hasanshukurov.yoxlamaglobroker.databinding.FragmentHomeBinding
import com.hasanshukurov.yoxlamaglobroker.databinding.FragmentTruckBinding
import com.hasanshukurov.yoxlamaglobroker.mvvm.CarViewModel
import com.hasanshukurov.yoxlamaglobroker.mvvm.TruckViewModel
import com.hasanshukurov.yoxlamaglobroker.util.Constant
import com.hasanshukurov.yoxlamaglobroker.util.Constant.amountUsd
import com.hasanshukurov.yoxlamaglobroker.util.Constant.date
import com.hasanshukurov.yoxlamaglobroker.util.Constant.engine
import dagger.hilt.android.AndroidEntryPoint


class TruckFragment : Fragment() {

    private var _binding: FragmentTruckBinding? = null
    private val binding: FragmentTruckBinding get() = _binding!!
    private lateinit var viewModel: TruckViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(TruckViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentTruckBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.hesablaId.setOnClickListener {
            calculate()
        }


        viewModel.result.observe(viewLifecycleOwner) {
            binding.kassaTextView.text = "Kassa: $it AZN"
        }


        binding.istehsalTarixiText.setOnClickListener {
            viewModel.makeCalendarVM(requireContext(), binding.istehsalTarixiText)
        }

    }

    private fun calculate() {

        date = binding.istehsalTarixiText.text.toString()
        amountUsd = binding.deyerText.text.toString().toDoubleOrNull()
        engine = binding.matorText.text.toString().toIntOrNull()
        val checkBigTruck = binding.dartici
        val checkTrailer = binding.qoshqu
        val checkSmallTruck = binding.yuk
        val result = binding.kassaTextView


        if (!checkBigTruck.isChecked || !checkTrailer.isChecked || !checkSmallTruck.isChecked) {
            result.text = "Nəqliyyat Vasitəsinin Növünü Seçin"
        }

        if (checkBigTruck.isChecked) {

            when {
                amountUsd == null -> {
                    result.text = "Dəyəri Daxil Edin"
                }
                engine == null -> {
                    result.text = "Mühərrik Həcmini Qeyd Edin"
                }
                date!!.isEmpty() -> {
                    result.text = "Tarixi Qeyd Edin"
                }
                else -> {
                    viewModel.calculateBigTruckVM(date!!, amountUsd!!, engine!!)
                }
            }
        }

        if (checkTrailer.isChecked) {

            when {
                amountUsd == null -> {
                    result.text = "Dəyəri Daxil Edin"
                }
                engine == null || engine!! > 0 -> {
                    result.text = "Mühərrik Həcmini   0   Qeyd Edin"
                }
                date!!.isEmpty() -> {
                    result.text = "Tarixi Qeyd Edin"
                }
                else -> {
                    viewModel.calculateTrailerVM(date!!, amountUsd!!, engine!!)
                }
            }
        }

        if (checkSmallTruck.isChecked) {
            when {
                amountUsd == null -> {
                    result.text = "Dəyəri Daxil Edin"
                }
                engine == null -> {
                    result.text = "Mühərrik Həcmini Qeyd Edin"
                }
                date!!.isEmpty() -> {
                    result.text = "Tarixi Qeyd Edin"
                }
                else -> {
                    viewModel.calculateSmallTruckVM(date!!, amountUsd!!, engine!!)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}