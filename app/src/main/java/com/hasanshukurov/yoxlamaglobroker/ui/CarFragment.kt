package com.hasanshukurov.yoxlamaglobroker.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.hasanshukurov.yoxlamaglobroker.databinding.FragmentCarBinding
import com.hasanshukurov.yoxlamaglobroker.mvvm.CarViewModel
import com.hasanshukurov.yoxlamaglobroker.util.Constant.amountUsd
import com.hasanshukurov.yoxlamaglobroker.util.Constant.date
import com.hasanshukurov.yoxlamaglobroker.util.Constant.engine

class CarFragment : Fragment() {

    private var _binding: FragmentCarBinding? = null
    private val binding: FragmentCarBinding get() = _binding!!

    private lateinit var viewModel: CarViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ViewModelProvider(this).get(CarViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentCarBinding.inflate(inflater, container, false)
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
        val checkBenzine = binding.benzin
        val checkDiesel = binding.dizel
        val checkHybrid = binding.hybrid
        val checkElectric = binding.elektrik
        val result = binding.kassaTextView


        if (!checkBenzine.isChecked || !checkDiesel.isChecked || !checkHybrid.isChecked || !checkElectric.isChecked) {
            binding.kassaTextView.text = "Mühərrik Növünü Seçin"
        }


        if (checkBenzine.isChecked) {
            when {
                date!!.isEmpty() -> {
                    result.text = "Tarixi Qeyd Edin"
                }
                amountUsd == null -> {
                    result.text = "Dəyəri Daxil Edin"
                }
                engine == null -> {
                    result.text = "Mühərrik Həcmini Qeyd Edin"
                }

                else -> {
                    viewModel.calculateBenzineCarVM(date!!, amountUsd!!, engine!!)
                }
            }
        }

        if (checkDiesel.isChecked) {
            when {
                date!!.isEmpty() -> {
                    result.text = "Tarixi Qeyd Edin"
                }
                amountUsd == null -> {
                    result.text = "Dəyəri Daxil Edin"
                }
                engine == null -> {
                    result.text = "Mühərrik Həcmini Qeyd Edin"
                }
                else -> {
                    viewModel.calculateDieselCarVM(date!!, amountUsd!!, engine!!)
                }
            }
        }

        if (checkHybrid.isChecked) {
            when {
                date!!.isEmpty() -> {
                    result.text = "Tarixi Qeyd Edin"
                }
                amountUsd == null -> {
                    result.text = "Dəyəri Daxil Edin"
                }
                engine == null -> {
                    result.text = "Mühərrik Həcmini Qeyd Edin"
                }
                else -> {
                    viewModel.calculateHybridCarVM(date!!, amountUsd!!, engine!!)
                }
            }
        }

        if (checkElectric.isChecked) {
            if (amountUsd == null) {
                result.text = "Dəyəri Daxil Edin"
            } else if (engine == null || engine!! > 0) {
                result.text = "Mühərrik Həcmini 0 Qeyd Edin"
            } else if (date!!.isEmpty()) {
                result.text = "Tarixi Qeyd Edin"
            } else {
                viewModel.calculateElectricCarVM(date!!, amountUsd!!, engine!!)
            }



            when {
                date!!.isEmpty() -> {
                    result.text = "Tarixi Qeyd Edin"
                }
                amountUsd == null -> {
                    result.text = "Dəyəri Daxil Edin"
                }
                engine == null || engine!! > 0 -> {
                    result.text = "Mühərrik Həcmini 0 Qeyd Edin"
                }
                else -> {
                    viewModel.calculateElectricCarVM(date!!, amountUsd!!, engine!!)
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}