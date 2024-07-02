package org.example.homework3

import java.util.Scanner

import kotlin.system.measureNanoTime

fun shuffleBigIntArray(array: IntArray){
    var size = array.size
    var j : Int
    for(i in 0 until size){
        j = (Math.random() * size).toInt()
        if (j == 1)
            continue
        var temp = array[i]
        array[i] = array[j]
        array[j] = temp
    }
}


fun insertion_sort(array: IntArray){
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

fun selection_sort(array: IntArray){
    var minIdx: Int
    for(i in 0..array.size-1){
        minIdx = i
        for(j in i+1..array.size-1){
            if(array[j] < array[i]) {
                minIdx = j
            }
            val temp = array[minIdx]
            array[minIdx] = array[i]
            array[i] = temp



        }
    }
}


fun main() {
    val cin = Scanner(System.`in`)
    var big_size: Int
    val test_sizes = intArrayOf(10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000)
    val offset = 0
    var bigRandIntArray: IntArray
    var tns_quick : Long
    var tns_insert : Long
    var tns_select : Long
    System.out.printf("Comparisons of Sorting Algorithms (measured time in nano-seconds)\n")
    System.out.printf("%10s %10s %10s %10s\n", "test_size", "quick_sort", "insert_sort", "select_sort")
    for (test_size in test_sizes) {
        bigRandIntArray = genBigRandIntArray(test_size, offset);
        tns_quick = measureNanoTime { quickSort(bigRandIntArray) }
        shuffleBigIntArray(bigRandIntArray)
        tns_insert = measureNanoTime { insertion_sort(bigRandIntArray) }
        shuffleBigIntArray(bigRandIntArray)
        tns_select = measureNanoTime { selection_sort(bigRandIntArray) }
        System.out.printf("%10d %10d %10d %10d\n", test_size, tns_quick, tns_insert, tns_select) }
}