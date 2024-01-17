package com.hasanshukurov.yoxlamaglobroker.service

import com.hasanshukurov.yoxlamaglobroker.model.CalculateModel

interface TruckInterface {

    fun calculateBigTruck(calcModel: CalculateModel): Double

    fun calculateTrailer(calcModel: CalculateModel): Double

    fun calculateSmallTruck(calcModel: CalculateModel): Double

}