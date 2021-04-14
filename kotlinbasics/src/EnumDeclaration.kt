/*
------------------------------------------------ ENUM CLASS DECLARATION ------------------------------------------------
Enum or Enumeration are a special type of class which is a group of constants. In programming there may come a situation
where input must be from a certain values. To accomplish this, enums were introduced. Example Gender can be either Male
or Female. Enums can contain properties and functions too in it. The constructor of enum may or may not have parameters.
An instance of enum class cannot be created using constructors. Each of the enum constants acts as separate instances of
the class and separated by commas.

*/

fun main() {
    val weekDay = WeekDays.TUESDAY
    println("Weekday is $weekDay and week number is ${weekDay.weekNumber}.")
}

enum class WeekDays(val weekNumber: Int) {
    /* Semicolon (";") must be added after last enum constant if enum has properties or functions too in it. Its a good
    practice to add semicolon even if there are no properties or functions in enum. */
    SUNDAY(1), MONDAY(2), TUESDAY(3), WEDNESDAY(4),
    THURSDAY(5), FRIDAY(6), SATURDAY(7);

    private val msg = "Hello World"
    fun printMessage() = println(msg)
}