/*
--------------------------------------------------- SCOPED FUNCTIONS ---------------------------------------------------
1. apply: The context object is available as a receiver (this). The return value is the object itself. Use apply for
          code blocks that don't return a value and mainly operate on the members of the receiver object. The common
          case for apply is the object configuration. Such calls can be read as “ apply the following assignments to the
          object.”

2. let  : The context object is available as an argument (it). The return value is the lambda result i.e. the return
          value of the list line. let can be used to invoke one or more functions on results of call chains.

3. with : A non-extension function, the context object is passed as an argument, but inside the lambda, it's available
          as a receiver (this). The return value is the lambda result. In the code, with can be read as “ with this
          object, do the following.”

4. run  : The context object is available as a receiver (this). The return value is the lambda result. run does the
          same as with but invokes as let- as an extension function of the context object. run is useful when your
          lambda contains both the object initialization and the computation of the return value.

5. also : The context object is available as an argument (it ). The return value is the object itself. also is good for
          performing some actions that take the context object as an argument. Use also for actions that need a
          reference rather to the object than to its properties and functions, or when you don't want to shadow this
          reference from an outer scope. When you see also in the code, you can read it as “ and also do the following
          with the object.”

*/
fun main() {
    val leo: Employee?
    leo = Employee(1001)

    leo.apply {
        println("Inside apply.")
        firstName = "Leo"
        lastName = "Parker"
        email = "leo.parker@mail.com"
        age = 35
        city = "Carolina"
    }

    leo.let {
        println("Inside let.")
        println("Employee Id: ${it.id}")
        println("First Name: ${it.firstName}")
        println("Last Name: ${it.lastName}")
        println("Email: ${it.email}")
        println("Age: ${it.age}")
        println("City: ${it.city}")
    }

    with(leo) {
        println("Inside with.")
        println("Employee Id: $id")
        println("First Name: $firstName")
        println("Last Name: $lastName")
        println("Email: $email")
        println("Age: $age")
        println("City: $city")
    }

    leo.run {
        println("Inside run.")
        println("Employee Id: $id")
        println("First Name: $firstName")
        println("Last Name: $lastName")
        println("Email: $email")
        println("Age: $age")
        println("City: $city")
    }

    leo.also {
        it.age = 36
        it.city = "New York"
        println("Inside also.")
        println("Employee Id: ${it.id}")
        println("First Name: ${it.firstName}")
        println("Last Name: ${it.lastName}")
        println("Email: ${it.email}")
        println("Age: ${it.age}")
        println("City: ${it.city}")
    }
}

data class Employee(val id: Int) {
    var firstName: String? = null
    var lastName: String? = null
    var email: String? = null
    var age: Int = 0
    var city: String? = null
}