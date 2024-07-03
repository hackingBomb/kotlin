package org.example.day3

import org.example.day3.MyKotlinClasses.Person
import org.example.day3.MyKotlinClasses.Student
import org.example.day3.MyKotlinClasses.Employee

fun main(){
    val st_nm = "Kim"
    val regID = 10000
    val stID = 20000
    val mjr = "ICT"
    var c1 = Student(st_nm, regID, stID, mjr)
    println("c1 = " + c1)
    println()
    var e1 = Employee("Choi", 12000, 7654, "Samsung", "MobileNetwork")
    println("e1 = " + e1)
}