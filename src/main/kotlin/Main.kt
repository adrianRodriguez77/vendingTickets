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
fun opcMenuTickets(): String{
    var opcMenu = 0
    var tipusBitllet = ""
    do {
        //Mostrar els tickets
        menuTickets()

        print("Selecciona un bitllet: ")

        //Verificar que l'usuari intredueix un número
        if (scanner.hasNextInt()){

            do {
                //Entrada de l'usuari
                opcMenu = scanner.nextInt()
                println("Continuar (S/n)")
                val continuar = scanner.next()
                if (continuar == "n"){
                    println("Torna a seleccionar el bitllet: ")
                } else println("Segueix amb la compra")
            }while (continuar != "S")

            //Verificar l'opció de l'usuari
            when(opcMenu){
                1 -> tipusBitllet = "Bitllet Senzill"
                2 -> tipusBitllet = "TCasual"
                3 -> tipusBitllet = "TUsual"
                4 -> tipusBitllet = "TFamiliar"
                5 -> tipusBitllet = "TJove"
            }
        } else {
            //Control d'errors
            println("Has d'introduïr una opció del menú")
            scanner.nextLine()
        }
    }while (opcMenu !in 1..5)

    return tipusBitllet
}
fun zonesMenu(){
    println("""
        
            Zones de distància que vol viatjar:
            1   2   3
            
        """.trimIndent())
}
fun opcZones(): Int{
    var opcZona = 0

    do {
        zonesMenu()
        print("Selecciona una zona: ")

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
fun quantitatTickets(): Int{
    var tickets: Int
    do {
        tickets = scanner.nextInt()
        if (tickets > 3){
            println("No pots adquirir més de 3 bitllets per persona!")
        } else if (tickets < 0){
            println("Selecciona una opció corrceta!")
        }
    } while (tickets !in 1..3)
    return tickets
}
fun preuTickets(bitllet: String, zona: Int, quantitat: Int): Double {
    return when(bitllet){
        "Bitllet Senzill" -> {
            when(zona){
                1-> 2.40 * quantitat
                2-> 2.40 * 1.3125 * quantitat
                3-> 2.40 * 1.8443 * quantitat
                else -> 0.0
            }
        }
        "TCasual"-> {
            when(zona){
                1-> 11.35 * quantitat
                2-> 11.35 * 1.3125 * quantitat
                3-> 11.35 * 1.8443 * quantitat
                else -> {0.0}
            }
        }
        "TUsual"-> {
            when(zona){
                1-> 40.0 * quantitat
                2-> 40.0 * 1.3125 * quantitat
                3-> 40.0 * 1.8443 * quantitat
                else -> {0.0}
            }
        }
        "TFamiliar"-> {
            when(zona){
                1-> 10.0*quantitat
                2-> 10.0 * 1.3125 * quantitat
                3-> 10.0 * 1.8443 * quantitat
                else -> {0.0}
            }
        }
        "TJove"-> {
            when(zona){
                1-> 80.0*quantitat
                2-> 80.0 * 1.3125 * quantitat
                3-> 80.0 * 1.8443 * quantitat
                else -> {0.0}
            }
        }

        else -> {0.0}
    }
}
fun main() {
    while (true){
        val bitllet = opcMenuTickets()
        val zona = opcZones()
        print("\nQuants bitllets vols comprar? ")
        val quantitat = quantitatTickets()
        println("$bitllet amb zona $zona té un preu de ${preuTickets(bitllet, zona, quantitat)}€\n")
    }
}