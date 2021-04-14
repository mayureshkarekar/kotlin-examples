/*
--------------------------------------------------- FACTORY PATTERN ---------------------------------------------------
Factory pattern is used to restrict the creation of the objects of a class. In factory pattern the constructor is
private and a method is responsible to create the object for that class. The factory method may accept parameters and
according to value of parameter it decides the way to create the object. The Factory Method Pattern is also known as
Virtual Constructor.

*/

fun main() {
    val margheritaPizza = Pizza.prepare(Pizza.MARGHERITA)
    println("Margherita Pizza: $margheritaPizza")

    val cheesePizza = Pizza.prepare(Pizza.CHEESE_BURST)
    println("Cheese Pizza: $cheesePizza")

    val mushroomPizza = Pizza.prepare(Pizza.MUSHROOM_SPICY)
    println("Mushroom Pizza: $mushroomPizza")
}

class Pizza private constructor(private val toppings: String, private val extraCheese: Boolean) {
    companion object {
        const val MARGHERITA = "margherita"
        const val MUSHROOM_SPICY = "mushroom_spicy"
        const val CHEESE_BURST = "cheese_burst"

        fun prepare(name: String) = when (name) {
            MARGHERITA -> Pizza("Tomato", true)
            MUSHROOM_SPICY -> Pizza("Mushroom", false)
            CHEESE_BURST -> Pizza("Capsicum", true)
            else -> null
        }
    }

    override fun toString(): String {
        return "Toppings: $toppings\tExtra Cheese: $extraCheese"
    }
}