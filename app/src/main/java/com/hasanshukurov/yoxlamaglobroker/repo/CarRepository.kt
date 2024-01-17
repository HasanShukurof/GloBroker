package com.hasanshukurov.yoxlamaglobroker.repo

import android.annotation.SuppressLint
import com.hasanshukurov.yoxlamaglobroker.model.CalculateModel
import com.hasanshukurov.yoxlamaglobroker.service.CarInterface
import com.hasanshukurov.yoxlamaglobroker.util.Constant.aksiz
import com.hasanshukurov.yoxlamaglobroker.util.Constant.edv
import com.hasanshukurov.yoxlamaglobroker.util.Constant.dateDifference
import com.hasanshukurov.yoxlamaglobroker.util.Constant.idxalRusumu
import com.hasanshukurov.yoxlamaglobroker.util.Constant.kohneUygunluq
import com.hasanshukurov.yoxlamaglobroker.util.Constant.result
import com.hasanshukurov.yoxlamaglobroker.util.Constant.vesiqePulu
import com.hasanshukurov.yoxlamaglobroker.util.Constant.xidmetHaqqi
import com.hasanshukurov.yoxlamaglobroker.util.Constant.yeniUygunluq
import com.hasanshukurov.yoxlamaglobroker.util.Constant.yigim
import com.hasanshukurov.yoxlamaglobroker.util.Calendar
import com.hasanshukurov.yoxlamaglobroker.util.Constant.date
import com.hasanshukurov.yoxlamaglobroker.util.Constant.amountAzn
import com.hasanshukurov.yoxlamaglobroker.util.Constant.amountUsd
import com.hasanshukurov.yoxlamaglobroker.util.Constant.engine
import java.util.*

class CarRepository : CarInterface {


    @SuppressLint("SuspiciousIndentation")
    override fun calculateBenzineCar(calcModel: CalculateModel): Double {

        amountUsd = calcModel.amount
        engine = calcModel.engine
        date = calcModel.date
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
            if (engine!! <= 1500) {
                if (dateDifference <= 365) {
                    idxalRusumu = engine!! * 0.68
                } else {
                    idxalRusumu = engine!! * 1.19
                }
            } else {
                if (dateDifference <= 365) {
                    idxalRusumu = engine!! * 1.19
                } else {
                    idxalRusumu = engine!! * 2.04
                }
            }
        }


        // ------- Aksiz vergisi -------

        if (engine != null) {
            if (engine!! <= 2000) {
                if (dateDifference >= 2555) {
                    aksiz = engine!! * 0.30 * 1.2
                } else {
                    aksiz = engine!! * 0.30
                }
            } else if (engine!! <= 3000) {
                if (dateDifference >= 2555) {
                    aksiz = ((engine!! - 2000.00) * 5.00 + 600.00) * 1.2
                } else {
                    aksiz = (engine!! - 2000.00) * 5.00 + 600.00
                }
            } else if (engine!! <= 4000) {
                if (dateDifference >= 2555) {
                    aksiz = ((engine!! - 3000.00) * 15.00 + 5600.00) * 1.2
                } else if (dateDifference >= 1095) {
                    aksiz = (engine!! - 3000.00) * 15.00 + 5600.00
                } else {
                    aksiz = (engine!! - 3000.00) * 13.00 + 5600.00
                }
            } else if (engine!! <= 5000) {
                if (dateDifference >= 2555) {
                    aksiz = ((engine!! - 4000.00) * 40.00 + 20600.00) * 1.2
                } else if (dateDifference >= 1095) {
                    aksiz = (engine!! - 4000.00) * 40.00 + 20600.00
                } else {
                    aksiz = (engine!! - 4000.00) * 35.00 + 18600.00
                }
            } else if (engine!! > 5000) {
                if (dateDifference >= 2555) {
                    aksiz = ((engine!! - 5000.00) * 80.00 + 60600.00) * 1.2
                } else if (dateDifference >= 1095) {
                    aksiz = (engine!! - 5000.00) * 80.00 + 60600.00
                } else {
                    aksiz = (engine!! - 5000.00) * 70.00 + 53600.00
                }
            }
        }


        //  EDV

        edv = ((amountAzn + idxalRusumu + aksiz + vesiqePulu) * 18) / 100


        if (dateDifference >= 365) {
            result = yigim + kohneUygunluq + vesiqePulu + idxalRusumu + aksiz + edv + xidmetHaqqi
        } else {
            result = yigim + yeniUygunluq + vesiqePulu + idxalRusumu + aksiz + edv + xidmetHaqqi
        }


        val changeFormatResult = String.format("%.2f", result)

        return changeFormatResult.toDouble()
    }

    override fun calculateDieselCar(calcModel: CalculateModel): Double {

        amountUsd = calcModel.amount
        engine = calcModel.engine
        date = calcModel.date
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
            if (engine!! <= 1500) {
                if (dateDifference <= 365) {
                    idxalRusumu = engine!! * 0.68
                } else {
                    idxalRusumu = engine!! * 1.19
                }
            } else {
                if (dateDifference <= 365) {
                    idxalRusumu = engine!! * 1.19
                } else {
                    idxalRusumu = engine!! * 2.04
                }
            }
        }


        // ------- Aksiz vergisi -------

        if (engine != null) {
            if (engine!! <= 2000) {
                if (dateDifference >= 2555) {
                    aksiz = engine!! * 0.30 * 1.5
                } else {
                    aksiz = engine!! * 0.30
                }
            } else if (engine!! <= 3000) {
                if (dateDifference >= 2555) {
                    aksiz = ((engine!! - 2000.00) * 5.00 + 600.00) * 1.5
                } else {
                    aksiz = (engine!! - 2000.00) * 5.00 + 600.00
                }
            } else if (engine!! <= 4000) {
                if (dateDifference >= 2555) {
                    aksiz = ((engine!! - 3000.00) * 15.00 + 5600.00) * 1.5
                } else if (dateDifference >= 1095) {
                    aksiz = (engine!! - 3000.00) * 15.00 + 5600.00
                } else {
                    aksiz = (engine!! - 3000.00) * 13.00 + 5600.00
                }
            } else if (engine!! <= 5000) {
                if (dateDifference >= 2555) {
                    aksiz = ((engine!! - 4000.00) * 40.00 + 20600.00) * 1.5
                } else if (dateDifference >= 1095) {
                    aksiz = (engine!! - 4000.00) * 40.00 + 20600.00
                } else {
                    aksiz = (engine!! - 4000.00) * 35.00 + 18600.00
                }
            } else if (engine!! > 5000) {
                if (dateDifference >= 2555) {
                    aksiz = ((engine!! - 5000.00) * 80.00 + 60600.00) * 1.5
                } else if (dateDifference >= 1095) {
                    aksiz = (engine!! - 5000.00) * 80.00 + 60600.00
                } else {
                    aksiz = (engine!! - 5000.00) * 70.00 + 53600.00
                }
            }
        }


        // EDV
        edv = ((amountAzn + idxalRusumu + aksiz + vesiqePulu) * 18) / 100


        if (dateDifference >= 365) {
            result = yigim + kohneUygunluq + vesiqePulu + idxalRusumu + aksiz + edv + xidmetHaqqi
        } else {
            result = yigim + yeniUygunluq + vesiqePulu + idxalRusumu + aksiz + edv + xidmetHaqqi
        }


        val changeFormatResult = String.format("%.2f", result)

        return changeFormatResult.toDouble()
    }

    override fun calculateHybridCar(calcModel: CalculateModel): Double {

        amountUsd = calcModel.amount
        engine = calcModel.engine
        date = calcModel.date
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
            if (engine!! <= 1500) {
                if (dateDifference <= 365) {
                    idxalRusumu = engine!! * 0.68
                } else {
                    idxalRusumu = engine!! * 1.19
                }
            } else {
                if (dateDifference <= 365) {
                    idxalRusumu = engine!! * 1.19
                } else {
                    idxalRusumu = engine!! * 2.04
                }
            }
        }


        // ------- Aksiz vergisi -------

        if (engine != null) {
            if (engine!! <= 2000) {
                if (dateDifference >= 2555) {
                    aksiz = engine!! * 0.30 * 1.2
                } else {
                    aksiz = engine!! * 0.30
                }
            } else if (engine!! <= 3000) {
                if (dateDifference >= 2555) {
                    aksiz = ((engine!! - 2000.00) * 5.00 + 600.00) * 1.2
                } else {
                    aksiz = (engine!! - 2000.00) * 5.00 + 600.00
                }
            } else if (engine!! <= 4000) {
                if (dateDifference >= 2555) {
                    aksiz = ((engine!! - 3000.00) * 15.00 + 5600.00) * 1.2
                } else if (dateDifference >= 1095) {
                    aksiz = (engine!! - 3000.00) * 15.00 + 5600.00
                } else {
                    aksiz = (engine!! - 3000.00) * 13.00 + 5600.00
                }
            } else if (engine!! <= 5000) {
                if (dateDifference >= 2555) {
                    aksiz = ((engine!! - 4000.00) * 40.00 + 20600.00) * 1.2
                } else if (dateDifference >= 1095) {
                    aksiz = (engine!! - 4000.00) * 40.00 + 20600.00
                } else {
                    aksiz = (engine!! - 4000.00) * 35.00 + 18600.00
                }
            } else if (engine!! > 5000) {
                if (dateDifference >= 2555) {
                    aksiz = ((engine!! - 5000.00) * 80.00 + 60600.00) * 1.2
                } else if (dateDifference >= 1095) {
                    aksiz = (engine!! - 5000.00) * 80.00 + 60600.00
                } else {
                    aksiz = (engine!! - 5000.00) * 70.00 + 53600.00
                }
            }
        }


        // EDV

        if (engine!! <= 2500 && dateDifference <= 1095) {
            edv = 0.00
        } else {
            edv = ((amountAzn + idxalRusumu + aksiz + vesiqePulu) * 18) / 100
        }



        if (dateDifference >= 365) {
            result = yigim + kohneUygunluq + vesiqePulu + idxalRusumu + aksiz + edv + xidmetHaqqi
        } else {
            result = yigim + yeniUygunluq + vesiqePulu + idxalRusumu + aksiz + edv + xidmetHaqqi
        }


        val changeFormatResult = String.format("%.2f", result)

        return changeFormatResult.toDouble()
    }

    override fun calculateElectricCar(calcModel: CalculateModel): Double {

        amountUsd = calcModel.amount
        engine = calcModel.engine
        date = calcModel.date
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

        if (dateDifference >= 1095) {
            idxalRusumu = amountAzn * 15 / 100
        } else {
            idxalRusumu = 0.00
        }


        result = yigim + vesiqePulu + idxalRusumu + xidmetHaqqi



        val changeFormatResult = String.format("%.2f", result)

        return changeFormatResult.toDouble()
    }


}