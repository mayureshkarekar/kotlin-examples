/*
-------------------------------------------- COLLECTION'S UTILITY FUNCTIONS --------------------------------------------
1. filter : Filter is used to filter the list. In the parameter it accepts a function which is accepting an integer and
            returning a boolean. The values for which true has returned will be kept in the list. The filter function
            will return the filtered list at last.

2. map    : Map is used to map the list to another form. In simple words the map will perform the given operation to
            each element in the list and will return the updated list.

3. forEach: For each is used to iterate the list through each element in the list. It is similar to for each loop.

*/

fun main() {
    val numbersOneToTen = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)


    val funIsEven = ::isEven
    // Passing the function variable as an argument.
    val evenNumbers = numbersOneToTen.filter(funIsEven)

    // Passing the function as an argument.
    val oddNumbers = numbersOneToTen.filter(::isOdd)

    // Passing the anonymous function as an argument.
    val multiplesOfThree = numbersOneToTen.filter(fun(a: Int): Boolean {
        return a % 3 == 0
    })

    // Passing the lambda as an argument.
    val multiplesOfFour = numbersOneToTen.filter({ a: Int -> a % 4 == 0 })

    // Passing the lambda as an argument outside of parenthesis.
    val multiplesOfFive = numbersOneToTen.filter { a: Int -> a % 5 == 0 }

    // Lambdas with single parameter can use "it" to refer the parameter.
    val multiplesOfSix = numbersOneToTen.filter { it % 6 == 0 }

    println("Even numbers: $evenNumbers")
    println("Odd numbers: $oddNumbers")
    println("Multiples of 3: $multiplesOfThree")
    println("Multiples of 4: $multiplesOfFour")
    println("Multiples of 5: $multiplesOfFive")
    println("Multiples of 6: $multiplesOfSix")


    val numPlusTen = numbersOneToTen.map { it + 10 }
    println("Number + 10: $numPlusTen")


    numbersOneToTen.forEach {
        print("$it ")
    }
}

fun isEven(num: Int) = num % 2 == 0

fun isOdd(num: Int) = !isEven(num)