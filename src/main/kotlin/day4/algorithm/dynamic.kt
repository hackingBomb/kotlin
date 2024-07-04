package org.example.day4.algorithm

import java.io.*
import java.util.*

import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

fun insertion_sort(array: IntArray) {
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

fun _partition(array: IntArray, start: Int, end: Int): Int {
    var pivot = array[(start + end) / 2]
    var startIndex = start
    var endIndex = end
    while (startIndex <= endIndex) {
        while(array[startIndex] < pivot)
            startIndex++
        while(array[endIndex] > pivot)
            endIndex--
        if(startIndex <= endIndex){
            var temp = array[startIndex]
            array[startIndex] = array[endIndex]
            array[endIndex] = temp
            startIndex++
            endIndex--
        }
    }
    return startIndex
}

// TODO: 정수형 배열의 퀵정렬 알고리즘으로 정렬하는 함수
fun _quickSort(array: IntArray, start: Int, end: Int) {
    var pivot : Int

    pivot = _partition(array,start,end)

    if (start < pivot - 1){
        _quickSort(array,start,pivot-1)
    }
    if (pivot < end){
        _quickSort(array,pivot,end)
    }


}
fun quickSort(array: IntArray) {
    var size = array.size

    _quickSort(array, 0, size-1);

}

fun genBigRandIntArray(size: Int, offset: Int): IntArray {
    var bigRandIntArray: IntArray = IntArray(size)
    var j: Int

    for(i in 0 until size)
        bigRandIntArray[i] = i + offset

    for(i in 0 until size){
        j = (Math.random() * size).toInt()
        if (j == 1)
            continue
        var temp = bigRandIntArray[i]
        bigRandIntArray[i] = bigRandIntArray[j]
        bigRandIntArray[j] = temp
    }


    return bigRandIntArray
}

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

fun mergeSort(array: IntArray) {
    var tmp_array = array.copyOf()
    _mergeSort(array, tmp_array, 0, array.size-1);
}

fun _mergeSort(array: IntArray, tmp_array : IntArray, left: Int, right: Int) {
    //printf("... invoke MergeSort(left=%d, right=%d):\n", left, right);
    if (left >= right) return;
    var i:Int;
    var j:Int;
    var k:Int
    var mid = (left+right) / 2;
    _mergeSort(array, tmp_array, left, mid);
    _mergeSort(array, tmp_array, mid + 1, right);
    /* merge step 1 : copy both half subarrays to tmp_array[] */
    for (i in left.. mid) tmp_array[i] = array[i];
    for (j in 1.. right - mid)
        tmp_array[right - j + 1] = array[mid + j];
    /* merge step 2 : merge sub-arrays back to array[] */
    i=left; j=right; k=left
    while(k <= right)
    {
        if (tmp_array[i] < tmp_array[j]) array[k] = tmp_array[i++];
        else
            array[k] = tmp_array[j--]; k++
    }
}

fun main(args: Array<String>) {
    val cin = Scanner(System.`in`)
    var big_size: Int
    val test_sizes = intArrayOf(10, 20, 30, 40 ,50,60, 70)
    val offset = 0
    var bigRandIntArray: IntArray
    var tns_quick : Long
    var tns_merge : Long
    var tms_insert : Long
    var tms_select : Long
    println("Comparisons of Sorting Algorithms (measured time in milli-seconds)")
    println("%10s %15s %15s %15s %15s".format("test_size", "quick_sort[ns]",
        "merge_sort[ns]","insert_sort[ns]", "select_sort[ns]"))
    for (test_size in test_sizes) {
        bigRandIntArray = genBigRandIntArray(test_size, offset);
        tns_quick = measureNanoTime {  quickSort(bigRandIntArray) }
        shuffleBigIntArray(bigRandIntArray)
        tns_merge = measureNanoTime { mergeSort(bigRandIntArray) }
        shuffleBigIntArray(bigRandIntArray)
        tms_insert = measureNanoTime { insertion_sort(bigRandIntArray) }
        shuffleBigIntArray(bigRandIntArray)
        tms_select = measureNanoTime { selection_sort(bigRandIntArray) }
        println("%10d %15d %15d %15d %15d".format(test_size, tns_quick, tns_merge, tms_insert, tms_select)) }
}