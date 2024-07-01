package org.example.homework1

import java.util.Scanner

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
    printArray(intArray)





}