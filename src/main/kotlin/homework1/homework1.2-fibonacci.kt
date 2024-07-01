package org.example.homework1

import java.util.Scanner


fun fibonacci(n: Int):  Long{
    if(n == 1){
        return 1
    }
    else if(n == 2){
        return 1
    }
    else if(n > 2){
        return fibonacci(n-1) + fibonacci(n-2)
    }
    else return 0
}

fun main(args: Array<String>) {
    val cin = Scanner(System.`in`)
    print("Input n to generate Fibonacci series (0~n) : ")
    val count = cin.nextInt()
    for(i in 1..count){
        print("Fibo(%3d) = %20d".format(i, fibonacci(i)))
        println()
    }
}