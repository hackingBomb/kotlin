package org.example.homework2

import java.util.Scanner
import kotlin.math.*

fun printArray(array: IntArray) {
    for(i in array){
        print("$i ")
    }
    println()
}

fun insertionSort(array: IntArray) {
    for(i in 1..array.size-1){
        var j = i
        val tempVal = array[i]
        while(j > 0){
            if(array[j-1] <= tempVal)
                break
            array[j] = array[j-1]
            j--
        }
        array[j] = tempVal

    }
}

fun reverseInsertionSort(array: IntArray) {
    for(i in 1..array.size-1){
        var j = i
        val tempVal = array[i]
        while(j > 0){
            if(array[j-1] >= tempVal)
                break
            array[j] = array[j-1]
            j--
        }
        array[j] = tempVal

    }
}

fun arrayAvg(array: IntArray): Double{
    var sum = 0.0
    for(i in 0..array.size-1){
        sum += array[i]
    }
    return sum / array.size
}

fun arrayVar(array: IntArray): Double{
    val average = arrayAvg(array)
    var sumVar = 0.0
    for(i in 0..array.size-1){
        sumVar += Math.pow(abs(array[i] - average),2.0)
    }
    return sumVar / array.size
}


fun main(args: Array<String>) {
    val cin = Scanner(System.`in`)
    print("Enter array Size: ")
    val arraySize = cin.nextInt()
    print("Enter $arraySize integers : ")

    val intArray = IntArray(arraySize)

    for(i in 0 until arraySize) {
        intArray[i] = cin.nextInt()
    }
    print("Input data before sorting : ")
    printArray(intArray)
    print("Input data after sorting : ")
    insertionSort(intArray)
    val minValue = intArray[0]
    printArray(intArray)
    print("In reverse order : ")
    reverseInsertionSort(intArray)
    val maxValue = intArray[0]
    printArray(intArray)
    val arrayAvg = arrayAvg(intArray)
    val arrayVar = arrayVar(intArray)
    print("Statistics :Statistics of the array: min(%d), max(%d), avg(%.3f), var(%.3f), std(%.3f)"
        .format(minValue, maxValue, arrayAvg, arrayVar, sqrt(arrayVar)))



}