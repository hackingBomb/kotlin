package org.example.day3.MyKotlinClasses

open class Person (){
    var name : String = ""
    val dmmy1 = println("(3) Declaration of Person.name")
    var reg_id : Int = 0
    val dmmy2 = println("(4) Declaration of Person.reg_id")
    init {
        println("(5) Person.init{}")
    }
    constructor(nm: String, regID: Int,
                arg: Unit=println("(2) Person secondary constructor default argument")) : this() {
        println("(6) Person primary constructor, initializing Person.name, Person.reg_id")
        this.name = nm
        this.reg_id = regID
    }
    open fun print() {
        println("Person(name=%s, reg_id=%d)".format(this.name, this.reg_id))
    }
    override fun toString() : String {
        var str = "Person(name=%s, reg_id=%d)".format(this.name, this.reg_id)
        return str
    } }