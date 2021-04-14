/*
--------------------------------------------- ABSTRACT CLASSES AND METHODS ---------------------------------------------
When we do not have any concrete body for a method we can declare it as a abstract method. The classes which contains
abstract methods must be declared as a abstract class such classes are called as abstract class. Abstract classes and
methods are by default public and open, and they cannot be instantiated. The class which inherits the abstract class
must implement all the abstract methods of the parent class or else must be declared as abstract class.

*/

fun main() {
    val bike = Bike()
    val aeroplane = Aeroplane()
    val ship = Ship()

    println(bike.start())
    println(aeroplane.start())
    println(ship.start())
}


abstract class Vehicle {
    abstract fun start(): String
}

class Bike : Vehicle() {
    override fun start() = "Bike is running."
}

class Aeroplane : Vehicle() {
    override fun start() = "Aeroplane is flying."
}

class Ship : Vehicle() {
    override fun start(): String = "Ship is sailing."
}