package com.cleantool.indiacleantool.utils.dateutils

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class CalendarUtils {

    companion object {

        const val STANDARD_TIME_FORMAT = "hh:mm"
        const val STANDARD_DATE_FORMAT="yyyy-MM-dd"

        fun formatTimeInStandFormat(): DateTimeFormatter? {
           return DateTimeFormatter.ofPattern(STANDARD_TIME_FORMAT)
        }

        fun getCurrentDateInStandFormat(): String? {
            return LocalDate.now().format(
                DateTimeFormatter.ofPattern(
                    STANDARD_DATE_FORMAT,
                    Locale.ENGLISH
                )
            )
        }

        fun getTimeInStandFormat(time: String) : String? {

            val simpleDateFormat = SimpleDateFormat("dd-MM-yyyy hh:mm:ss")
            val date = simpleDateFormat.parse(time)
            val timeFormat = SimpleDateFormat("hh:mm")
            return timeFormat.format(date)
        }

        fun getDateInStandFormat(date: String): String? {
            val formatter = DateTimeFormatter.ofPattern(STANDARD_DATE_FORMAT)
            return LocalDate.parse(date, formatter).toString()
        }

    }

}