package com.hasanshukurov.yoxlamaglobroker.mvvm

import android.content.Context
import android.widget.EditText
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hasanshukurov.yoxlamaglobroker.model.CalculateModel
import com.hasanshukurov.yoxlamaglobroker.repo.CarRepository
import com.hasanshukurov.yoxlamaglobroker.repo.TruckRepository
import com.hasanshukurov.yoxlamaglobroker.util.Calendar

class TruckViewModel: ViewModel() {

    val repo = TruckRepository()
    var result = MutableLiveData<String>()

    fun calculateBigTruckVM(date: String, amount: Double, engine: Int) {

        val calculate = CalculateModel(date,amount,engine)

        result.value = repo.calculateBigTruck(calculate).toString()

    }


    fun calculateTrailerVM(date: String, amount: Double, engine: Int) {

        val calculate = CalculateModel(date,amount,engine)

        result.value = repo.calculateTrailer(calculate).toString()

    }


    fun calculateSmallTruckVM(date: String, amount: Double, engine: Int) {

        val calculate = CalculateModel(date,amount,engine)

        result.value = repo.calculateSmallTruck(calculate).toString()

    }


    fun makeCalendarVM(context: Context, tvDate: EditText){
        Calendar.calendar(context,tvDate)
    }
}