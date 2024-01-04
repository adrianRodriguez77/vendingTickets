package org.example

import java.util.*

const val errorMSG = "Introduce lo que se te pide, por favor."

fun menuTickets(){
    //Mostrar menú de tickets
    println(
        YELLOW_BOLD + BLACK_BACKGROUND + """
        MENÚ VENDING TICKETS (Metro - Bus - Tren)
        
        1. Bitllet senzill
        2. TCasual
        3. TUsual
        4. TFamiliar
        5. TJove
        
    """.trimIndent() + WHITE_BACKGROUND_BRIGHT + BLUE_BOLD_BRIGHT)
}
fun opcMenuTickets(): String{
    var opcMenu = 0
    var tipusBitllet = ""
    do {
        //Mostrar els tickets
        menuTickets()

        println("Selecciona un bitllet: ")

        //Verificar que l'usuari intredueix un número
        if (scanner.hasNextInt()){


                //Entrada de l'usuari
                opcMenu = scanner.nextInt()

                println("Continuar (S/n)")
                val continuar = scanner.next()
                val continuarMIN = continuar.lowercase(Locale.getDefault())

                when (continuarMIN) {
                    "n" -> {
                        println("Torna a seleccionar el bitllet: (1, 2, 3, 4, 5)")
                    }
                    "s" -> {
                        println("Segueix amb la compra")
                    }
                    else -> {
                        println("Debes introducir 'S' o 'N'")
                    }
                }


            //Verificar l'opció de l'usuari
            when(opcMenu){
                1 -> tipusBitllet = "Bitllet Senzill"
                2 -> tipusBitllet = "TCasual"
                3 -> tipusBitllet = "TUsual"
                4 -> tipusBitllet = "TFamiliar"
                5 -> tipusBitllet = "TJove"
                else -> println("Introduce una de estas opciones: 1, 2, 3, 4, 5")
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
        println("Selecciona una zona: ")

        // Verificar que l'entrada sigui un número
        if (scanner.hasNextInt()) {

            //Entrada de l'usuari
            opcZona = scanner.nextInt()

            // Verificar si la opció es vàlida
            when(opcZona){
                1 -> println("Has escollit $opcZona zona.")
                2 -> println("Has escollit $opcZona zones.")
                3 -> println("Has escollit $opcZona zones.")
                else -> println("Opcions disponibles: 1, 2, 3")
            }

        } else {
            println("Error! Has de seleccionar una zona. Intenta-ho una altre vegada!.")
            // Netejar el buffer del Scanner
            scanner.nextLine()
        }
    } while (opcZona !in 1..3)
    return opcZona
}
fun quantitatTickets(): Int {

    val ticketList = mutableListOf(1, 2, 3)
    var sortidaInt: Int

    do {
        println("\nQuants bitllets vols comprar? ")

        val tickets: String = ""

        sortidaInt = readInt(tickets, errorMSG)

        if (sortidaInt > 3) {
            println("No pots adquirir més de 3 bitllets per persona!")
        } else if (sortidaInt <= 0) {
            println("Has d'elegir mínim 1 bitllet!!!")
        }

    } while (sortidaInt !in ticketList)
    return sortidaInt
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