package org.example


import java.util.Scanner
import kotlin.math.*;

//fun sum(a: Int, b: Int): Int {
//    return a + b;
//}
//
//fun print2DArray(mtrx : Array<DoubleArray>){
//    for(row in mtrx){
//        for(element in row){
//            print("%5.1f".format(element))
//        }
//        println()
//    }
//}

fun main(args : Array<String>) {

    val cin = Scanner(System.`in`);


    /****************************************************************** Double 연산 구현
    while(true){
    println("\nEnter 2 double data in a line (input 0 0 to quit)")
    var x = cin.nextDouble();
    var y = cin.nextDouble();
    if(x.equals(0.0) && y.equals(0.0)){
    break;
    }
    println("x(%7.3f) + y(%7.3f) = %7.3f".format(x,y,x+y))
    println("x(%7.3f) + y(%7.3f) = %7.3f".format(x,y,x-y))
    println("x(%7.3f) + y(%7.3f) = %7.3f".format(x,y,x*y))
    println("x(%7.3f) + y(%7.3f) = %7.3f".format(x,y,x/y))
    }
    cin.close()
     ********************************************************************/

    /****************************************************************** 구구단 테이블
    println("9 x 9 Multiplication Table")
    print("   |")
    for(i in 1..9)
    print("%3d".format(i))
    println()
    print("--+")
    for(i in 1..19)
    print("--")
    println()

    for(i in 1..9) {
    print("%3d|".format(i))
    for (j in 1..9) {
    print("%3d".format(i * j))
    }
    println()
    }
    */

    /** ****************************************************** 삽입 정렬
    fun insertionSort(arr : IntArray){
    val size = arr.size
    for(i in 1..size-1){
    val key = arr[i]
    var j = i
    while(j > 0){
    if (arr[j-1] <= key)
    break
    arr[j] = arr[j-1]
    j--
    }
    arr[j] = key
    }
    }

    fun printArray(arr : IntArray){
    val size = arr.size
    for(i in 0..size-1){
    print("%3d".format(arr[i]))
    }
    println()
    }

    val intArray = IntArray(10)
    var data : Int
    print("Enter 10 integers : ")
    for(i in 0..9){
    data = cin.nextInt()
    intArray[i] = data
    }

    print("Input data befor sorting : ")
    printArray(intArray)
    insertionSort(intArray)
    print("input data after sorting : ")
    printArray(intArray)
     */

    /********************************************************* 피보나치 수열
    fun Fibo(n : Int) : Int {
    var fibo_n : Int
    if (n<=1){
    fibo_n = n;
    } else {
    fibo_n = Fibo(n - 2) + Fibo(n - 1)
    }
    return fibo_n;
    }

    print("Input n to generate Fibonaacci series (0~n) : ")
    val n = cin.nextInt()
    var fibo_i : Int
    for (i in 0..n){
    fibo_i = Fibo(i);
    print("Fibo(%3d) = %20d\n".format(i, fibo_i))
    }
    cin.close()
     */

    /********************************************************* Down to Step
    for(i in 10 downTo 1 step 2){
        print("$i ")
    }
    println()
    */

    /* ******************************************************* listOf forEach
    val fruits = listOf("apple", "banana", "kiwi")
    val animals = listOf("tiger", "lion", "bear", "cat", "dog")

    println("List of fruits : ")
    fruits.forEach(::println)

    print("List of animals : ")
    animals.forEach{ item -> print("%5s ".format(item))}
    println()

    */

    /********************************************************* 2-Dimension
    val mtrx = arrayOf(
        doubleArrayOf(0.0, 0.1, 0.2, 0.3),
        doubleArrayOf(1.0, 1.1, 1.2, 1.3),
        doubleArrayOf(2.0, 2.1, 2.2)
    )

    print2DArray(mtrx);
    */





    /*
     * 1. 배열 선언은 IntArray 이런식으로 선언.
     * 2. switch-case 구문은 when{else} 구문을 사용
     * 3. 인스턴스마다 해시코드를 가지고 있어서 컴파일러에서 해시코드를 가지고 각 인스턴스를 비교한다.
     * 4. ? 은 Safety call Operator 이다.
     *
     */



}