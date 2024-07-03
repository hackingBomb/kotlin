package org.example.day3.MyKotlinPackage

class MyGenericArray<T>(private val capacity: Int) {
}

fun main(args: Array<String>) {
    val hm_num_name = HashMap<Int, String>()
    val num_names = arrayOf(
        "Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"
    )

    for(i in 0..9){
        hm_num_name[i] = num_names[i]
    }

    val keys: Set<Int> = hm_num_name.keys
    val it = keys.iterator()
    while (it.hasNext()){
        val key = it.next()
        val value = hm_num_name[key]
        println("($key, $value)")
    }
}