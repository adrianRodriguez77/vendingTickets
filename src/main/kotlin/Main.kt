package org.example

import java.util.Scanner

var scanner = Scanner(System.`in`)

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
    var opcMenu: Int
    do {
        menuTickets()
        print("SELECCIONA UNA OPCIÓ: ")
        if (scanner.hasNextInt()){
            opcMenu = scanner.nextInt()
            when(opcMenu){
                1 -> println()
                2 -> println()
                3 -> println()
                4 -> println()
                5 -> println()
            }
        } else {
            println("Has d'introduïr una opció del menú")
            scanner.nextLine()
            opcMenu = 0
        }

    }while (opcMenu !in 1..5)

}
fun zones(): Int{
    var opcZona: Int

    do {
        println("""
            ZONES DE DISTÀNCIA QUE VOL VIATJAR:
            
            1   2   3
            
        """.trimIndent())
        print("SELECCIONA UNA OPCIÓ: ")
        // Verificar si la entrada es un número entero
        if (scanner.hasNextInt()) {
            opcZona = scanner.nextInt()
            // Verificar si la opción es válida
            when(opcZona){
                1 -> println("Has escollit $opcZona zona.")
                2 -> println("Has escollit $opcZona zones.")
                3 -> println("Has escollit $opcZona zones.")
            }
        } else {
            println("Error! Has de seleccionar una zona. Intenta-ho una altre vegada!.")
            // Limpiar el buffer del Scanner
            scanner.nextLine()
            opcZona = 0 // Valor arbitrario para continuar el bucle
        }

    } while (opcZona !in 1..3)
    return opcZona
}

fun main() {
    opcMenuTickets()
    zones()

}