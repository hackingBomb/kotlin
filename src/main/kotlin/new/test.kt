package org.example.new

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

fun main(args: Array<String>){
    val test_sizes = intArrayOf(12, 30000, 2000000, 10, 50, 100, 500, 1000, 5000, 10000, 50000, 100000)
    selection_sort(test_sizes)
    for(i in test_sizes.indices){
        print(test_sizes[i].toString() + " ")
    }
}