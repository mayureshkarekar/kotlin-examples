/*
----------------------------------------------------- INTERFACES ------------------------------------------------------
Interfaces is another way to achieve abstraction. Similar to abstract classes, interfaces can have abstract methods as
well as concrete methods. Non-concrete methods in interfaces are by default abstract. The class which implements the
interface must override all abstract methods of the interface or else it must be declared as abstract class. An
interface can implement other interfaces. Interfaces and classes can implement multiple interfaces at a time.

*/

fun main() {
    val tiger = Tiger()
    val lion = Lion()
    val human = Human()

    // We can group objects together who has same behavior i.e. implementing same interface.
    val livingBeings = arrayOf(tiger, lion, human)
    doJump(livingBeings)
    eat(livingBeings)
}


interface Jumper {
    fun jump()
}


fun doJump(jumpers: Array<Jumper>) {
    for (jumper in jumpers) {
        jumper.jump()
    }
}


fun eat(livingBeings: Array<Jumper>) {
    for (livingBeing in livingBeings) {
        // "is" operator is used to check the type of the object.
        if (livingBeing is Human) {
            // Smart Casting: Kotlin smart casts the object to Human as it satisfied the condition.
            livingBeing.buyFood()
        } else {
            // Type Casting: "as" keyword is used to cast the object.
            (livingBeing as Animal).hunt()
        }
    }
}


abstract class Animal : Jumper {
    abstract fun hunt()
}

class Tiger : Animal() {
    override fun hunt() = println("Tiger is hunting.")
    override fun jump() = println("Tiger is jumping.")
}

class Lion : Animal() {
    override fun hunt() = println("Lion is hunting.")
    override fun jump() = println("Lion is jumping.")
}

class Human : Jumper {
    fun buyFood() = println("Human is buying food.")
    override fun jump() = println("Human is jumping.")
}