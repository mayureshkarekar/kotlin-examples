/*
------------------------------------------------------ OPERATORS ------------------------------------------------------
Arithmetic Operators: Arithmetic operators are used to perform basic mathematical operations like Addition, Subtraction,
Multiplication and Division.

1. Addition (+)      : Used to perform the ADDITION between two values.
2. Subtraction (-)   : Used to perform the SUBTRACTION between two values.
3. Multiplication (*): Used to perform the MULTIPLICATION between two values.
4. Division (/)      : Used to perform the DIVISION between two values.
5. Modulus (%)       : Used get the REMAINDER of the division.


Relational Operators: Relational operators are used to check the relation between the values like 1 is less than 10, 5
is equals to 5.

1. Greater Than (>)           : Used to check if left operand is GREATER THAN right operand.
2. Less Than (<)              : Used to check if left operand is LESS THAN right operand.
3. Greater Than Equals To (>=): Used to check if left operand is GREATER THAN OR EQUALS TO right operand.
4. Less Than Equals To (<=)   : Used to check if left operand is LESS THAN OR EQUALS TO right operand.
5. Equals To (==)             : Used to check if left operand is EQUALS TO right operand.
6. Not Equals To (!=)         : Used to check if left operand is NOT EQUALS TO right operand.


Logical Operators: Logical operators are used to connect two or more conditions.
1. And (&&): Returns true if both statements are true.
2. Or (||) : Returns true if one of the statements is true.
3. Not (!) : Reverse the result, returns false if the result is true.

*/

fun main(args: Array<String>) {
    val a = 2.5
    val b = 50
    val c = 100

    println("$a + $b = ${a + b}")
    println("$a - $b = ${a - b}")
    println("$a * $b = ${a * b}")
    println("$a / $b = ${a / b}")
    println("$a % $b = ${a % b}")

    println("$a > $b = ${a > b}")
    println("$a < $b = ${a < b}")
    println("$a >= $b = ${a >= b}")
    println("$a <= $b = ${a <= b}")
    println("$b == $c = ${b == c}")
    println("$b != $c = ${b != c}")
}