package com.nailnafir.personalspace.utility

import java.util.Date
import java.util.concurrent.TimeUnit

fun Date.isMoreThan7DaysFromNow(current: Date = Date()): Boolean {
    val diffInMillis = current.time - this.time
    val diffInDays = TimeUnit.MILLISECONDS.toDays(diffInMillis)
    return diffInDays > 7
}