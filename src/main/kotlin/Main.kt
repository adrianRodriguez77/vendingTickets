package org.example

import java.util.Scanner

var scanner = Scanner(System.`in`)

fun menuTickets(){
    //Mostrar menú de tickets
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
    var opcMenu = 0
    do {
        //Mostrar els tickets
        menuTickets()

        print("SELECCIONA UNA OPCIÓ: ")

        //Verificar que l'usuari intredueix un número
        if (scanner.hasNextInt()){

            //Entrada de l'usuari
            opcMenu = scanner.nextInt()

            //Verificar l'opció de l'usuari
            when(opcMenu){
                1 -> println()
                2 -> println()
                3 -> println()
                4 -> println()
                5 -> println()
            }
        } else {
            //Control d'errors
            println("Has d'introduïr una opció del menú")
            scanner.nextLine()

        }

    }while (opcMenu !in 1..5)

}
fun zones(): Int{
    var opcZona = 0

    do {
        println("""
            ZONES DE DISTÀNCIA QUE VOL VIATJAR:
            
            1   2   3
            
        """.trimIndent())
        print("SELECCIONA UNA OPCIÓ: ")

        // Verificar que l'entrada sigui un número
        if (scanner.hasNextInt()) {

            //Entrada de l'usuari
            opcZona = scanner.nextInt()

            // Verificar si la opció es vàlida
            when(opcZona){
                1 -> println("Has escollit $opcZona zona.")
                2 -> println("Has escollit $opcZona zones.")
                3 -> println("Has escollit $opcZona zones.")
            }
        } else {
            println("Error! Has de seleccionar una zona. Intenta-ho una altre vegada!.")
            // Netejar el buffer del Scanner
            scanner.nextLine()
        }

    } while (opcZona !in 1..3)
    return opcZona
}

fun main() {
    opcMenuTickets()
    zones()
}