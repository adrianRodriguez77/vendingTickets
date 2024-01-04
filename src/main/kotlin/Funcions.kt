package org.example

import java.util.*

const val errorMSG = "Introduce lo que se te pide, por favor."

fun menuTickets(){
    //Mostrar menú de tickets
    println(
        """
        $YELLOW_BOLD$BLACK_BACKGROUND MENÚ VENDING TICKETS (Metro - Bus - Tren) $RESET
        $YELLOW_BOLD$BLACK_BACKGROUND                                           $RESET
        $YELLOW_BOLD$BLACK_BACKGROUND 1. Bitllet senzill                        $RESET
        $YELLOW_BOLD$BLACK_BACKGROUND 2. TCasual                                $RESET
        $YELLOW_BOLD$BLACK_BACKGROUND 3. TUsual                                 $RESET
        $YELLOW_BOLD$BLACK_BACKGROUND 4. TFamiliar                              $RESET
        $YELLOW_BOLD$BLACK_BACKGROUND 5. TJove                                  $RESET
        
    """.trimIndent())
}
fun opcMenuTickets(): String{
    var opcMenu = 0
    var tipusBitllet = ""
    do {
        //Mostrar els tickets
        menuTickets()

        println("$WHITE_BACKGROUND_BRIGHT$BLUE_BOLD_BRIGHT Selecciona un bitllet:                    $RESET")

        //Verificar que l'usuari intredueix un número
        if (scanner.hasNextInt()){


                //Entrada de l'usuari
                opcMenu = scanner.nextInt()

                println("$WHITE_BACKGROUND_BRIGHT$BLUE_BOLD_BRIGHT Continuar (S/n):                          $RESET")
                val continuar = scanner.next()
                val continuarMIN = continuar.lowercase(Locale.getDefault())

                when (continuarMIN) {
                    "n" -> {
                        println("$WHITE_BACKGROUND_BRIGHT$BLUE_BOLD_BRIGHT Torna a seleccionar el bitllet: $RESET")
                    }
                    "s" -> {
                        println("$GREEN_BACKGROUND_BRIGHT$WHITE_BOLD_BRIGHT Segueix amb la compra!                    $RESET")
                    }
                    else -> {
                        println("$WHITE_BACKGROUND_BRIGHT$BLUE_BOLD_BRIGHT Has d'introduïr 'S' o 'N'$RESET")
                    }
                }


            //Verificar l'opció de l'usuari
            when(opcMenu){
                1 -> tipusBitllet = "Bitllet Senzill"
                2 -> tipusBitllet = "TCasual"
                3 -> tipusBitllet = "TUsual"
                4 -> tipusBitllet = "TFamiliar"
                5 -> tipusBitllet = "TJove"
                else -> println("Introdueïx una d'aquestes opcions: 1, 2, 3, 4, 5")
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
        $WHITE_BACKGROUND_BRIGHT$BLUE_BOLD_BRIGHT Zones de distància que vol viatjar:       $RESET
        $WHITE_BACKGROUND_BRIGHT$BLUE_BOLD_BRIGHT            1   2   3                      $RESET
            
        """.trimIndent())
}
fun opcZones(): Int{
    var opcZona = 0

    do {
        zonesMenu()
        println("$WHITE_BACKGROUND_BRIGHT$BLUE_BOLD_BRIGHT Selecciona una zona:                      $RESET")

        // Verificar que l'entrada sigui un número
        if (scanner.hasNextInt()) {

            //Entrada de l'usuari
            opcZona = scanner.nextInt()

            // Verificar si la opció es vàlida
            when(opcZona){
                1 -> println("$BLUE_BACKGROUND_BRIGHT$WHITE_BOLD_BRIGHT Has escollit $opcZona zona.                      $RESET")
                2 -> println("$BLUE_BACKGROUND_BRIGHT$WHITE_BOLD_BRIGHT Has escollit $opcZona zones.                     $RESET")
                3 -> println("$BLUE_BACKGROUND_BRIGHT$WHITE_BOLD_BRIGHT Has escollit $opcZona zones.                     $RESET")
                else -> println("$BLUE_BACKGROUND_BRIGHT$WHITE_BOLD_BRIGHT Opcions disponibles: 1, 2, 3              $RESET")
            }

        } else {
            println("$RED_BACKGROUND_BRIGHT$WHITE_BOLD_BRIGHT Error! Intenta-ho una altre vegada!       $RESET")
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
        println("\n$WHITE_BACKGROUND_BRIGHT$BLUE_BOLD_BRIGHT Quants bitllets vols comprar?             $RESET")

        val tickets = ""

        sortidaInt = readInt(tickets, errorMSG)

        if (sortidaInt > 3) {
            println("$RED_BACKGROUND_BRIGHT$WHITE_BOLD_BRIGHT No pots adquirir més de 3 bitllets per persona!$RESET")
        } else if (sortidaInt <= 0) {
            println("$RED_BACKGROUND_BRIGHT$WHITE_BOLD_BRIGHT Has de seleccionar mínim 1 bitllet!!!     $RESET")
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