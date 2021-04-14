/*
----------------------------------------------- SEALED CLASS DECLARATION -----------------------------------------------
Sealed classes represent restricted class hierarchies that provide more control over inheritance. All subclasses of a
sealed class are known at compile time. No other subclasses may appear after a module with the sealed class is compiled.
For example, third-party clients can't extend your sealed class in their code. Thus, each instance of a sealed class has
a type from a limited set that is known when this class is compiled. Sealed classes are abstract classes and you cannot
create instances of sealed classes using constructors.

*/

fun main() {
    val simpleCheeseBurger = VegBurger("Simple Cheese", 2, 30.toDouble())
    val chickenBurger = NonVegBurger("Chicken", 1, 50.toDouble())

    println("Bill for ${simpleCheeseBurger.name} burger is ${getBill(simpleCheeseBurger)}")
    println("Bill for ${chickenBurger.name} burger is ${getBill(chickenBurger)}")
}

fun getBill(burger: Burger) = when (burger) {
    is VegBurger -> burger.price + (burger.patties * 10.5)
    is NonVegBurger -> burger.price + (burger.patties * 20.5)
}


sealed class Burger(val name: String)

// You must create subclass in same file only.
class VegBurger(name: String, val patties: Int = 1, val price: Double) : Burger(name)
class NonVegBurger(name: String, val patties: Int = 1, val price: Double) : Burger(name)