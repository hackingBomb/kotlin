package org.example

import java.util.*
import kotlin.system.measureTimeMillis

val FIBO_MAX = 1000
/*
Global variable 쓰지마라. 위험한 새끼다



 */

fun Fibo_SR(n : Int) : Double {
    if (n < 0) {
        println("Error in Fibonacci series, given n (%d) is negative !!".format(n))
    }
    if ((n >= 0) && (n <= 1)) {
        return n.toDouble()
    } else {
        var fibo_n = Fibo_SR(n - 2) + Fibo_SR(n - 1)
        return fibo_n
    }
}

var fibo_tbl : DoubleArray = DoubleArray(FIBO_MAX + 1){-1.0}
fun Fibo_Dyn(n : Int) : Double {
    if (n > FIBO_MAX) {
        println("Exception in Fibo_Dyn - given n (%d) is beyond the FIBO_MAX(%d)")
        return -1.0
    }
    var fibo_n: Double
    if ((n >= 0) && (n <= 1)) {
        return n.toDouble()
    } else if (fibo_tbl[n] != -1.0)
        return fibo_tbl[n]
    else {
        fibo_n = Fibo_Dyn(n - 1) + Fibo_Dyn(n - 2)
        fibo_tbl[n] = fibo_n
        return fibo_n
    }
}



fun main(args: Array<String>) {
    val cin = Scanner(System.`in`)
    print("Input range (start, end (up to 100), step) of Fibonacci series :")
    val start = cin.nextInt()
    val end = cin.nextInt()
    val Fibo_step = cin.nextInt()

    print("By Simple Recursive (SR) or Dynamic Programming (Dyn) : ")
    var mode = cin.next()
    var fibo_n : Double
    var tms_fibo : Long

    if (mode == "SR") {
        println("Fibonacci Series (by Simple Recursive)")
        for(n in start..end step Fibo_step){
            tms_fibo =  measureTimeMillis{
                fibo_n = Fibo_SR(n)
            }
            println("%3d-th Fibo_n = %25.0f (took %8d nano sec)".format(n, fibo_n, tms_fibo))
        }
    }
    else {
        println("Fibonacci Series (by Dynamic Programming)")
        for (n in start..end step Fibo_step) {
            tms_fibo = measureTimeMillis{
                fibo_n = Fibo_Dyn(n)
            }
            println("%3d-th Fibo_n = %25.0f (took %8d nano sec)".format(n, fibo_n, tms_fibo)) }
    }
    cin.close()
}

