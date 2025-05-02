package com.nailnafir.personalspace.utility

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun formatDateIndonesian(
    date: Date,
    format: String = "dd MMMM yyyy",
): String {
    val localeID = Locale("in", "ID")
    val formatter = SimpleDateFormat(format, localeID)
    return formatter.format(date)
}