/*
---------------------------------------------------- INHERITANCE ----------------------------------------------------
Inheritance is a way of organizing code in a parent-child relationship that helps in reducing code duplication. You
define the functionality in a parent class that will be inherited by child classes. You don't need to define the same
functionality in a child class - child classes will have it from its parent. Inheritance is also known as IS-A
relationship. To inherit a class, parent class must be declared as open which indicates the class is open for
inheritance. One class can inherit only one parent at a time. When child class object is created, the parent's
constructor is called first and then child's constructor is called.

*/

fun main() {
    val phone = Phone()
    val smartphone = Smartphone()
    val tablet = Tablet()

    smartphone.name = "Samsung"
    tablet.name = "One Plus"

    phone.switchOn()
    smartphone.switchOn()
    tablet.switchOn()

    phone.makeCall("9876543210")
    smartphone.makeCall("9988776655")
    tablet.makeCall("9876556789")

    phone.showDetails()
    smartphone.showDetails()
    tablet.showDetails()

    phone.switchOff()
    smartphone.switchOff()
    tablet.switchOff()

    smartphone.playGame()
    tablet.playVideo()
}


open class Phone {
    var name = "Phone"
    open val simSlots = 1 // To override parent's property, the parent's target property must be declared as open.

    init {
        println("Phone constructor called.")
    }

    fun switchOn() {
        println("$name switched on.")
    }

    fun switchOff() {
        println("$name switched off.")
    }

    fun makeCall(number: String) {
        println("$name calling $number.")
    }

    // To override parent's function, the parent's target function must be declared as open.
    open fun showDetails() {
        println("Name: $name, Sim Slots: $simSlots")
    }
}


class Smartphone : Phone() {
    private val ram = 4
    override val simSlots = 2 // Overriding parent's property.

    init {
        println("Smartphone constructor called.")
    }

    fun playGame() {
        println("$name playing game.")
    }

    // Overriding parent's function.
    override fun showDetails() {
        println("Name: $name, Sim Slots: $simSlots, RAM: ${ram}GB")
    }
}


class Tablet : Phone() {
    private val ram = 2
    override val simSlots = 0

    init {
        println("Tablet constructor called.")
    }

    fun playVideo() {
        println("$name playing video.")
    }

    // Overriding parent's function.
    override fun showDetails() {
        println("Name: $name, Sim Slots: $simSlots, RAM: ${ram}GB")
    }
}