/*
---------------------------------------------------- POLYMORPHISM ----------------------------------------------------
Poly means many and morph means forms i.e. the same method behaves differently based on the object. Here we have
different forms of the method that exhibits different behavior based on the object. It helps to write extensible and
hence maintainable code.

*/

fun main() {
    /* Upcasting: Parent can hold reference of its child class. In below example Shape is parent class and its holding
    the reference of its child classes. It can access the properties/functions which are common in parent and child.
    i.e. area() function. */
    val circle: Shape = Circle(4.0)
    val square: Shape = Square(4.0)
    val triangle: Shape = Triangle(3.0, 3.0)

    // We can group objects together having same parent class.
    val shapes = arrayOf<Shape>(circle, square, triangle)
    calculateAreas(shapes)
}

fun calculateAreas(shapes: Array<Shape>) {
    for (shape in shapes) {
        /* Object will invoke appropriate area() function depending on the type of it. i.e. variable circle is holding
        the instance of Circle class hence it will invoke Circle.area() function & variable square will invoke
        Square.area() function. */
        println("Area: ${shape.area()}")
    }
}


open class Shape {
    open fun area() = 0.0
}

class Circle(private val radius: Double) : Shape() {
    override fun area() = Math.PI * radius * radius
}

class Square(private val side: Double) : Shape() {
    override fun area() = side * side
}

class Triangle(private val base: Double, private val height: Double) : Shape() {
    override fun area() = 0.5 * base * height
}