package com.example.laboratorio3

abstract class Food(val nombre: String, val precio: Double) {
    abstract fun cook(): String
}

class Burger(nombre: String, precio: Double) : Food(nombre, precio) {
    override fun cook(): String {
        return "Cocinando la " + super.nombre
    }
}

class Pizza(nombre: String, precio: Double) : Food(nombre, precio) {
    override fun cook(): String {
        return "Cocinando la " + super.nombre
    }
}

interface Dessert {
    fun eat(): String
}

class IceCream(nombre: String, precio: Double) : Food(nombre, precio), Dessert {
    override fun cook(): String {
        return "Preparando el " + super.nombre
    }

    override fun eat(): String {
        return "Comiendo el " + super.nombre
    }
}

abstract class Drink(nombre: String, precio: Double) : Food(nombre, precio) {
    abstract fun pour(): String
}

class Juice(nombre: String, precio: Double) : Drink(nombre, precio) {
    override fun pour(): String {
        return "Sirviendo el " + super.nombre
    }

    override fun cook(): String {
        return "Preparando el " + super.nombre
    }
}

fun Food.discountedPrice(descuento: Double): Double {
    return precio * (1 - (descuento / 100))
}

fun main() {
    val hamburguesa = Burger("Hamburguesa doble", 60.00)
    val pizza = Pizza("Pizza suprema", 120.00)
    val helado = IceCream("Helado de chocolate", 15.00)
    val jugo = Juice("Jugo de frutas", 10.00)

    println(hamburguesa.cook())
    println(pizza.cook())
    println(helado.cook())
    println(jugo.cook())
    println(helado.eat())

    val descuento = 50.0

    if (descuento < 100 && descuento > 0) {
        println("\nPrecio con descuento de la hamburguesa: ${hamburguesa.discountedPrice(descuento)}")
    } else {
        println("\nEl descuento debe estar entre 0% y 100%")
    }
}