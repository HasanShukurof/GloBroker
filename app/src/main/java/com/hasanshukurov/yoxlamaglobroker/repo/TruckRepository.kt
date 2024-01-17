package com.hasanshukurov.yoxlamaglobroker.repo

import com.hasanshukurov.yoxlamaglobroker.model.CalculateModel
import com.hasanshukurov.yoxlamaglobroker.service.TruckInterface
import com.hasanshukurov.yoxlamaglobroker.util.Calendar
import com.hasanshukurov.yoxlamaglobroker.util.Constant
import com.hasanshukurov.yoxlamaglobroker.util.Constant.date
import com.hasanshukurov.yoxlamaglobroker.util.Constant.dateDifference
import com.hasanshukurov.yoxlamaglobroker.util.Constant.amountAzn
import com.hasanshukurov.yoxlamaglobroker.util.Constant.amountUsd
import com.hasanshukurov.yoxlamaglobroker.util.Constant.edv
import com.hasanshukurov.yoxlamaglobroker.util.Constant.idxalRusumu
import com.hasanshukurov.yoxlamaglobroker.util.Constant.kohneUygunluq
import com.hasanshukurov.yoxlamaglobroker.util.Constant.engine
import com.hasanshukurov.yoxlamaglobroker.util.Constant.result
import com.hasanshukurov.yoxlamaglobroker.util.Constant.vesiqePulu
import com.hasanshukurov.yoxlamaglobroker.util.Constant.vesiqePuluQoshqu
import com.hasanshukurov.yoxlamaglobroker.util.Constant.xidmetHaqqi
import com.hasanshukurov.yoxlamaglobroker.util.Constant.yeniUygunluq
import com.hasanshukurov.yoxlamaglobroker.util.Constant.yigim

class TruckRepository: TruckInterface {

    override fun calculateBigTruck(calcModel: CalculateModel): Double {

        date = calcModel.date
        amountUsd = calcModel.amount
        engine = calcModel.engine
        amountAzn = amountUsd!! * 1.70

        Calendar.dateDifference(date!!)



        // --------- Gomruk Yigimi ----------

        when {
            amountAzn <= 1000 -> {
                yigim = 15
            }
            amountAzn <= 10000 -> {
                yigim = 60
            }
            amountAzn <= 50000 -> {
                yigim = 120
            }
            amountAzn <= 100000 -> {
                yigim = 200
            }
            amountAzn <= 500000 -> {
                yigim = 300
            }
            amountAzn <= 1000000 -> {
                yigim = 600
            }
            else -> {
                yigim = 1000
            }
        }



        //   EDV

        edv = ((amountAzn + vesiqePulu) * 18) / 100


        if (dateDifference >= 365){
            result = yigim + kohneUygunluq + vesiqePulu + edv + xidmetHaqqi
        }else{
            result = yigim + yeniUygunluq + vesiqePulu + edv + xidmetHaqqi
        }


        val changeFormatResult = String.format("%.2f", result)

        return changeFormatResult.toDouble()
    }



    override fun calculateTrailer(calcModel: CalculateModel): Double {

        date = calcModel.date
        amountUsd = calcModel.amount
        engine = calcModel.engine
        amountAzn = amountUsd!! * 1.70

        Calendar.dateDifference(date!!)

        // --------- Gomruk Yigimi ----------

        when {
            amountAzn <= 1000 -> {
                yigim = 15
            }
            amountAzn <= 10000 -> {
                yigim = 60
            }
            amountAzn <= 50000 -> {
                yigim = 120
            }
            amountAzn <= 100000 -> {
                yigim = 200
            }
            amountAzn <= 500000 -> {
                yigim = 300
            }
            amountAzn <= 1000000 -> {
                yigim = 600
            }
            else -> {
                yigim = 1000
            }
        }



        // ------- Idxal rusumu -------
        if (amountUsd != null) {
            idxalRusumu = amountAzn * 5 / 100
        }


        //   EDV

        edv = ((amountAzn + idxalRusumu + vesiqePuluQoshqu) * 18) / 100


        result = yigim + vesiqePuluQoshqu + idxalRusumu + edv + xidmetHaqqi



        val changeFormatResult = String.format("%.2f", result)

        return changeFormatResult.toDouble()
    }



    override fun calculateSmallTruck(calcModel: CalculateModel): Double {

        date = calcModel.date
        amountUsd = calcModel.amount
        engine = calcModel.engine
        amountAzn = amountUsd!! * 1.70

        Calendar.dateDifference(date!!)


        // --------- Gomruk Yigimi ----------

        when {
            amountAzn <= 1000 -> {
                yigim = 15
            }
            amountAzn <= 10000 -> {
                yigim = 60
            }
            amountAzn <= 50000 -> {
                yigim = 120
            }
            amountAzn <= 100000 -> {
                yigim = 200
            }
            amountAzn <= 500000 -> {
                yigim = 300
            }
            amountAzn <= 1000000 -> {
                yigim = 600
            }
            else -> {
                yigim = 1000
            }
        }


        // ------- Idxal rusumu -------
        if (engine != null) {
            if (dateDifference >= 365){
                idxalRusumu = engine!! * 0.7 * 1.7
            }else{
                idxalRusumu = amountAzn * 5/100
            }
        }


        //   EDV
        edv = ((amountAzn + idxalRusumu + vesiqePulu) * 18) / 100


        if (dateDifference >= 365){
            result = yigim + kohneUygunluq + vesiqePulu + idxalRusumu + edv + xidmetHaqqi
        }else{
            result = yigim + yeniUygunluq + vesiqePulu + idxalRusumu + edv + xidmetHaqqi
        }

        val changeFormatResult = String.format("%.2f", result)

        return changeFormatResult.toDouble()
    }
}