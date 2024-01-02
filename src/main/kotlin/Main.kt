package org.example

fun menuTickets(){
    println("""
        MENÚ VENDING TICKETS (Metro, bus i tren)
        1. Bitllet senzill
        2. TCasual
        3. TUsual
        4. TFamiliar
        5. TJove
    """.trimIndent())
}

fun opcMenuTickets(){
    print("Selecciona una opció: ")
    val opcMenu = readln().toInt()
    when(opcMenu){
        1 -> println()
        2 -> println()
        3 -> println()
        4 -> println()
        5 -> println()
    }
}
fun main() {
    menuTickets()
    opcMenuTickets()
}