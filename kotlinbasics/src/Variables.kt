/*
------------------------------------------------------ VARIABLES ------------------------------------------------------
Variables are memory blocks to store the data. The size of the memory block can vary according to the types of data it
holds.

Data types defines the type of data the variable can hold in it.
1. Integer (Byte, Short, Int, Long): Stores whole numbers. eg. -1, 0, 5
2. Floating Point (Float, Double)  : Stores decimals. eg. -2.5, 0.4, 9.1
3. Boolean                         : Stores boolean values. eg. true, false
4. Character (Char, String)        : Stores character values. eg. 'a', "Hello"

Arrays: Arrays are used to store the multiple values of same data type in a single variable. Arrays are of fixed size.


Access/Visibility Modifiers: Access/Visibility modifiers are used modify the access of a variable or a function i.e. how
                             it can be accessed within the files or modules.
1. public    : The variable/function is accessible publicly (i.e. Everywhere in same/different modules).
2. internal  : The variable/function is accessible within the current module only.
3. private   : The variable/function is accessible withing the current file/class only.
4. protected : The variable/function is accessible within he current file/class and its subclass only. (protected is not
               allowed for top-level declaration i.e can be declared in a class only.)

*/

fun main(args: Array<String>) {
    // Move the cursor to variable name and press CTRL + SHIFT + P to find the variable data type.

    // Type Inference: According to value assigned, the variable data type is defined.
    // Type Checking : Once the value is assigned to the variable, its data type cannot be changed.

    // val is used to define a CONSTANT whose VALUE CANNOT BE CHANGED.
    val pi = 3.14

    // var is used to define a VARIABLE whose VALUE CAN BE CHANGED.
    var integerVar = 1
    var floatingPointVar = 0.5
    var booleanVal = true
    var stringVar = "Hello World"

    println("pi: $pi")
    println("integerVar: $integerVar")
    println("floatingPointVar: $floatingPointVar")
    println("booleanVal: $booleanVal")
    println("stringVar: $stringVar")


    var stringArray = arrayOf("Apple", "Orange", "Banana")
    println("stringArray[0]: ${stringArray[0]}")
    println("stringArray[1]: ${stringArray[1]}")
    println("stringArray[2]: ${stringArray[2]}")
}