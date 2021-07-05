package com.cleantool.indiacleantool.utils.dateutils

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeFormatter.ISO_LOCAL_DATE
import java.util.*

class CalendarUtils {

    companion object {

        const val APP_LEVEL_PATTERN="yyyy-MM-dd@HH:mm:ss.SSSZ"
        const val STANDARD_TIME_FORMAT = "hh:mm"
        const val STANDARD_DATE_FORMAT="yyyy-MM-dd"

        @SuppressLint("NewApi")
        fun formatTimeInStandFormat(): DateTimeFormatter? {
           return DateTimeFormatter.ofPattern(STANDARD_TIME_FORMAT)
        }

        @SuppressLint("NewApi")
        fun getCurrentDateInStandFormat(): String? {
            return LocalDate.now().format(
                    DateTimeFormatter.ofPattern(
                            STANDARD_DATE_FORMAT,
                            Locale.ENGLISH
                    )
            )
        }

        fun getTimeInStandFormat(time: String?) : String {

            val simpleDateFormat = SimpleDateFormat(APP_LEVEL_PATTERN, Locale.ENGLISH)
            val date = simpleDateFormat.parse(time)
            val timeFormat = SimpleDateFormat(STANDARD_TIME_FORMAT)
            return timeFormat.format(date)
        }

        @SuppressLint("NewApi")
        fun getDateInStandFormat(date: String): String? {
            val formatter = DateTimeFormatter.ofPattern(STANDARD_DATE_FORMAT)
            return LocalDate.parse(date, formatter).toString()

            val date = LocalDate.now()
            val text = date.format(ISO_LOCAL_DATE)
            val parsedDate = LocalDate.parse(text, formatter)
        }

    }

}