/*
---------------------------------------------------- GENERIC CLASS ----------------------------------------------------
Generics are the powerful features that allow us to define classes, methods and properties which are accessible using
different data types while keeping a check of the compile-time type safety. Generics means we use a class or an
implementation in a very generic manner. For example, the interface List allows us for code reuse. We are able to create
a list of Strings, of integer values and we will have the same operations even if we have different types. So the list
wraps a common functionality for each implementation.

*/

fun main() {
    // Creating generic class object for Int type.
    val intContainer = Container<Int>(500)
    println("Int container value: ${intContainer.getValue()}")

    // Creating generic class object for String type.
    val stringContainer = Container("Hello")
    println("String container value: ${stringContainer.getValue()}")
}

class Container<T>(private var mValue: T) {
    fun setValue(value: T) {
        mValue = value
    }

    fun getValue() = mValue
}