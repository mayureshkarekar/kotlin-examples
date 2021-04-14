/*
-------------------------------------------------- OBJECT DECLARATION --------------------------------------------------
In Kotlin object keyword is used to declare singleton classes. Singleton classes are used where only single instance of
a class is needed. An object class can contain properties/variables, functions and init block. Constructors are not
allowed in object class. Objects cannot be instantiated like normal classes. An object gets instantiated when it is used
for the first time. A singleton object can be defined inside a class but it cannot be defined inside an inner class.

Anonymous Classes: Objects are also uses to define anonymous classes. These anonymous classes can also inherit other
                   classes and interfaces.

*/

fun main() {
    Facebook.incrementLike()
    Facebook.incrementLike()
    Facebook.incrementLike()

    Facebook.incrementComments()
    Facebook.incrementComments()

    Facebook.incrementShares()
    Facebook.incrementShares()
    Facebook.incrementShares()
    Facebook.incrementShares()

    Facebook.printDetails()


    // Defining anonymous class.
    val anonObject = object {
        fun sayHello() {
            println("Hello from anonObject.")
        }
    }
    anonObject.sayHello()


    // Defining anonymous classes with parent class.
    val anonAnimal = object : Animal() {
        override fun hunt() {
            println("AnonAnimal is hunting.")
        }

        override fun jump() {
            println("AnonAnimal is jumping.")
        }
    }
    anonAnimal.hunt()
    anonAnimal.jump()
}

object Facebook {
    init {
        println("Facebook init called.")
    }

    private var likes = 0
    private var comments = 0
    private var shares = 0

    fun incrementLike() = likes++
    fun incrementComments() = comments++
    fun incrementShares() = shares++
    fun printDetails() = println("Likes: $likes | Comments: $comments | Shares: $shares")
}