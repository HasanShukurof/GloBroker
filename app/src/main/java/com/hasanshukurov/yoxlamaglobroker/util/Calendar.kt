package com.hasanshukurov.yoxlamaglobroker.util

import android.app.DatePickerDialog
import android.content.Context
import android.content.DialogInterface
import android.widget.EditText
import java.text.SimpleDateFormat
import java.util.*
import java.util.Calendar

object Calendar {

    fun calendar(context: Context, tvDate: EditText) {

        val calendar = Calendar.getInstance()

        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePicker = DatePickerDialog(context,
            DatePickerDialog.OnDateSetListener { datePicker, y, m, d ->
                tvDate.setText("$d.${m + 1}.$y").toString()
            }, year, month, day
        )

        datePicker.setTitle("Tarix Seçin")
        datePicker.setButton(DialogInterface.BUTTON_POSITIVE, "Ok", datePicker)
        datePicker.setButton(DialogInterface.BUTTON_NEGATIVE, "Cancel", datePicker)

        datePicker.show()
    }


    fun dateDifference(date: String) {

        val toDay = Date()
        val makeFormat = SimpleDateFormat("dd.MM.yyyy")
        val tarix: Date = makeFormat.parse(date)

        Constant.dateDifference = (toDay.time - tarix.time) / 86400000
    }

}