package com.hasanshukurov.yoxlamaglobroker.mvvm

import android.content.Context
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasanshukurov.yoxlamaglobroker.model.CalculateModel
import com.hasanshukurov.yoxlamaglobroker.repo.CarRepository
import com.hasanshukurov.yoxlamaglobroker.util.Calendar

class CarViewModel: ViewModel() {

    val repo = CarRepository()
    var result = MutableLiveData<String>()


    fun calculateBenzineCarVM(date: String, amount: Double, engine: Int) {

        val calculate = CalculateModel(date,amount,engine)

        result.value = repo.calculateBenzineCar(calculate).toString()

    }


    fun calculateDieselCarVM(date: String, amount: Double, engine: Int) {

        val calculate = CalculateModel(date,amount,engine)

        result.value = repo.calculateDieselCar(calculate).toString()

    }


    fun calculateHybridCarVM(date: String, amount: Double, engine: Int) {

        val calculate = CalculateModel(date,amount,engine)

        result.value = repo.calculateHybridCar(calculate).toString()

    }


    fun calculateElectricCarVM(date: String, amount: Double, engine: Int) {

        val calculate = CalculateModel(date,amount,engine)

        result.value = repo.calculateElectricCar(calculate).toString()

    }

    fun makeCalendarVM(context: Context, tvDate: EditText){
        Calendar.calendar(context,tvDate)
    }


}