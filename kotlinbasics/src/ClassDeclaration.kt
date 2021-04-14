/*
-------------------------------------------------- CLASS DECLARATION --------------------------------------------------
Class : Kotlin class is similar to Java class, a class is a blueprint for the objects which have common properties. In
        simple words class is a structure for the object. Classes can contain variable/properties , methods and
        inner/nested classes. Kotlin classes are declared using keyword class. Kotlin class has a class header which
        specifies its type parameters, constructor etc. and the class body which is surrounded by curly braces. To
        create instance of classes, constructors are used. Constructors can be parameterized or parameterless. If we do
        not define the constructor, JVM will provide default constructor which does not have parameters.

Object: Objects are the instances of the classes. A class can have multiple objects. Each object holds a unique instance
        of the class.

*/

fun main() {
    val samsungPhone = Mobile("Samsung", "Black", 59999.99)
    val xiaomiPhone = Mobile("Xiaomi", "Grey", 39999.50)

    println("Samsung phone color is: ${samsungPhone.color}")
    println("Xiaomi phone color is: ${xiaomiPhone.color}")

    samsungPhone.doCall("9876543210")
    xiaomiPhone.doCall("9988776655")

    samsungPhone.captureImage()
    xiaomiPhone.captureImage()


    val audiCar = Car("Audi")
    val ferrariCar = Car("Ferrari", 2)

    audiCar.printSeats()
    ferrariCar.printSeats()


    val tree = Tree()
    tree.giveOxygen()
}


class Mobile(private val name: String, var color: String, private var price: Double) {
    var isCalling = false

    fun doCall(phoneNumber: String) {
        println("$name is calling $phoneNumber.")
        isCalling = true
    }

    fun endCall() {
        println("$name ended the call.")
        isCalling = false
    }

    fun captureImage() {
        println("$name is capturing image.")
    }
}

// Primary constructor (Optional). If you do not create primary constructor, Kotlin will provide default constructor.
class Car(private val name: String) {
    private var mSeats = 4;

    /* Secondary constructor (Optional). If class has primary constructor then secondary constructor must call primary
    constructor. */
    /* NOTE: If you don't use val or var for constructor parameter then it will act as a simple function parameter and
    cannot be accessed as a class parameter. */
    constructor(name: String, seats: Int) : this(name) {
        this.mSeats = seats
        println("Car: Inside secondary constructor.")
    }

    /* Init blocks (Optional) are used to perform initialization tasks when the class object is created. There can be
    multiple init blocks in a class, they executes in the sequence they come. */
    init {
        println("Car: Inside init block1.")
    }

    init {
        println("Car: Inside init block2.")
    }

    fun printSeats() {
        println("Total seats of $name: $mSeats")
    }
}


// Using default constructor.
class Tree {
    fun giveOxygen() {
        println("Giving oxygen.")
    }
}