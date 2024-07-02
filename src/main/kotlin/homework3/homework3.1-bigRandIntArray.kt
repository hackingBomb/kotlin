package org.example.homework3


import java.util.Scanner



// TODO: RAND_MAX (32,767)보다 큰 값의 배열 크기 big_size와 offset이 인수로 전달받고,
//  (0 ~ big_size) + offset 범위의 중복되지 않는 정수형 난수 배열을 생성하는 함수
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

// TODO: 배열의 원소들 중 첫부분과 끝부분에서 한 줄에 per_line 개씩의 원소를 sample_lines 줄씩 출력하는 함수
fun printBigArraySample(bigArray: IntArray, per_line: Int, sample_lines: Int) {
    var count_line = 0
    for(i in 0 until sample_lines) {
        for(j in count_line until count_line+per_line){
            print("%10d ".format(bigArray[j]))
        }
        count_line += per_line
        println()

    }
    println("\n........\n")

    count_line = per_line * sample_lines
    var per_count = 0
    while(count_line != 0){
        if(per_count == per_line){
            println()
            per_count = 0
        }
        print("%10d ".format(bigArray[bigArray.size - count_line]))
        per_count++
        count_line--

    }
    println("\n")
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



fun main(args: Array<String>) {
    val cin = Scanner(System.`in`)
    var big_size: Int
    val offset = 0
    var bigRandIntArray: IntArray
    while (true) {
        print("input big_size (> 32767) to generate non-duplicated random big integer array (0 to terminate) : ")
        big_size = cin.nextInt()
        if (big_size == 0)
            break
        bigRandIntArray = genBigRandIntArray(big_size, offset)
        System.out.printf("Before sorting, size = %d, offset = %d\n", big_size, offset)
        printBigArraySample(bigRandIntArray, 10, 2)
        quickSort(bigRandIntArray)
        System.out.printf("After sorting, size = %d, offset = %d\n", big_size, offset)
        printBigArraySample(bigRandIntArray, 10, 2)
    }
}