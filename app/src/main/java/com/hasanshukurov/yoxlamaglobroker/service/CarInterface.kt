package com.hasanshukurov.yoxlamaglobroker.service

import com.hasanshukurov.yoxlamaglobroker.model.CalculateModel

interface CarInterface {

    fun calculateBenzineCar(calcModel: CalculateModel): Double

    fun calculateDieselCar(calcModel: CalculateModel): Double

    fun calculateHybridCar(calcModel: CalculateModel): Double

    fun calculateElectricCar(calcModel: CalculateModel): Double

}