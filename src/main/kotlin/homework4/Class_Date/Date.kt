package org.example.homework4.Class_Date

import java.util.*


class Date {
    private var year = 0
    private var month = 0
    private var day = 0
    internal enum class WEEKDAY {
        SUN, MON, TUE, WED, THR, FRI, SAT
    }
    internal enum class MONTH {
        Dummy, JAN, FED, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC
    }
    val weekDayName = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")
    val weekDayNameShort = arrayOf("SUN", "MON", "TUE", "WED", "THR", "FRI", "SAT")
    val monthName = arrayOf(
        "", "January", "February", "March", "April", "May", "June", "July", "August", "September",
        "October", "November", "December" )
    constructor() { //default constructor
        year = 0; month = 0; day = 0
    }
    //constructor with given arguments
    constructor(y: Int, m: Int, d: Int) {
        setDate(y, m, d)
    }

    private fun isValidDate(y: Int, m: Int, d: Int): Boolean {
        val days_month = intArrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        if (this.isLeapYear(y))
            days_month[2] = 29
        return if (m>=1 || m <= 12 || d >= 1 || d <= days_month[m]){
            true
        }
        else {
            println("ilegal data! (month = %d, day = %d)".format(m,d))
            false
        }
    }

    private fun setDate(y: Int, m: Int, d: Int) {
        if (isValidDate(y, m, d)) {
            year = y
            month = m
            day = d
        }
        else {
            println("Ilegal date! (%d, %d, %d) ==> Program aborted.".format(y, m, d))
        }
    }

    fun getYearDay(year: Int, month: Int, day: Int): Int {
        val days_month = intArrayOf(0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        var yearDay = 0
        for (m in 1 until month)
            yearDay += days_month[m]
        yearDay += day
        if(month > 2 && isLeapYear(year))
            yearDay += 1
        return yearDay
    }
    fun getElapsedDaysFromAD010101(): Int {
        .... //직접구현할것.
    }
    private fun getElapsedDaysFromAD010101(d: Date): Int {
        .... //직접구현할것.
    }
    fun getWeekDay(d: Date): Int {
        .... //직접구현할것.
    }
    fun inputDate() {
        .... //직접구현할것.
    }
    fun isLeapYear(y: Int): Boolean {
        return if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0) true else false
    }
    private fun isLeapYear(): Boolean {
        return isLeapYear(year)
    }
    override fun toString() : String {
        .... //직접구현할것.
    }
}