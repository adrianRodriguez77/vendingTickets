package org.example

import java.util.*

const val errorMSG = "Introduce lo que se te pide, por favor."

/**
 * This method shows the main menu of the program
 * @author adrianRodriguez77
 * @author oscarsxrrano
 * @since 04/01/2024
 * @sample menuTickets
 */

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

/**
 * This method offers the possibility of choosing a ticket to the user.
 * @author adrianRodriguez77
 * @author oscarsxrrano
 * @since 04/01/2024
 * @sample opcMenuTickets
 * @return tipusBitllet
 */

fun opcMenuTickets(): String{
    var opcMenu = 0
    var tipusBitllet = ""
    do {
        //Mostrar els tickets
        menuTickets()

        println("$WHITE_BACKGROUND_BRIGHT$BLUE_BOLD_BRIGHT Selecciona un bitllet:                    $RESET")

        //Verificar que l'usuari intredueix un número
        if (scanner.hasNextInt()){

            do {
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

            }while (continuar != "s")


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

/**
 * This method shows the zones menu
 * @author adrianRodriguez77
 * @author oscarsxrrano
 * @since 04/01/2024
 * @sample zonesMenu
 */

fun zonesMenu(){
    println("""
        $WHITE_BACKGROUND_BRIGHT$BLUE_BOLD_BRIGHT Zones de distància que vol viatjar:       $RESET
        $WHITE_BACKGROUND_BRIGHT$BLUE_BOLD_BRIGHT            1   2   3                      $RESET
            
        """.trimIndent())
}

/**
 * This method asks the user and calculates the areas of the bill
 * @author adrianRodriguez77
 * @author oscarsxrrano
 * @since 04/01/2024
 * @sample opcZones
 * @return opcZona
 */

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

/**
 * This method reads the number of the amount of bills that the user wants
 * @author adrianRodriguez77
 * @author oscarsxrrano
 * @since 04/01/2024
 * @sample quantitatTickets
 * @return sortidaInt
 */

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

/**
 * This method calculates the price of the different tickets
 * @author adrianRodriguez77
 * @author oscarsxrrano
 * @since 04/01/2024
 * @sample preuTickets
 * @param bitllet
 * @param quantitat
 * @return bitllet
 */


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

/**
 * This method shows the ticket with its respective price
 * @author adrianRodriguez77
 * @author oscarsxrrano
 * @since 04/01/2024
 * @sample mostrarTicket
 */

fun mostrarTicket(bitllet: String, zona: Int, quantitat: Int, preu: Double) {
    println("""
        _____________________________TICKET______________________________    
        $quantitat $bitllet amb zona $zona                              $preu€    
        _________________________________________________________________
    """.trimIndent())
}

/**
 * This method shows the set of all tickets
 * @author adrianRodriguez77
 * @author oscarsxrrano
 * @since 04/01/2024
 * @sample mostrarTicketTotal
 */

fun mostrarTicketTotal(detallCompra: List<String>, totalPreu: Double) {
    println("""
        _____________________________TICKET TOTAL______________________________    
    """.trimIndent())

    for ((index, detall) in detallCompra.withIndex()) {
        println(detall)
    }

    println("""
        _______________________________________________________________________
        Total Preu:                                               $totalPreu€
    """.trimIndent())
}

/**
 * This method creates the final ticket
 * @author adrianRodriguez77
 * @author oscarsxrrano
 * @since 04/01/2024
 * @sample demanarTickets
 * @return Triple
 */

fun demanarTickets(): Triple<String, Int, Int> {
    val bitllet = opcMenuTickets()
    val zona = opcZones()
    val quantitat = quantitatTickets()

    return Triple(bitllet, zona, quantitat)
}

/**
 * This method manages the payment of the ticket
 * @author adrianRodriguez77
 * @author oscarsxrrano
 * @since 04/01/2024
 * @sample gestionarPagament
 * @return tipusBitllet
 * @param totalPreu
 */

fun gestionarPagament(totalPreu: Double) {
    var dinersIntroduits = 0.0

    while (dinersIntroduits < totalPreu) {
        print("Introdueix diners (només monedes i bitllets d'EURO): ")

        if (scanner.hasNextDouble()) {
            val moneda = scanner.nextDouble()

            when {
                moneda in setOf(0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0) -> {
                    dinersIntroduits += moneda
                    println("Diners introduïts: $dinersIntroduits€")
                }
                else -> {
                    mostrarMonedaNoValida()
                }
            }

            if (dinersIntroduits >= totalPreu) {
                val canvi = dinersIntroduits - totalPreu
                mostrarCompraSatisfactoria(canvi)
            }
        } else {
            mostrarEntradaNoValida()
        }
    }
}

/**
 * This method gives the money change
 * @author adrianRodriguez77
 * @author oscarsxrrano
 * @since 04/01/2024
 * @sample mostrarCompraSatisfactoria
 */

fun mostrarCompraSatisfactoria(canvi: Double) {
    println("Compra satisfactòria. Torna: $canvi€")
}

/**
 * This method shows an invalid coin
 * @author adrianRodriguez77
 * @author oscarsxrrano
 * @since 04/01/2024
 * @sample mostrarMonedaNoValida
 */

fun mostrarMonedaNoValida() {
    println("Moneda no vàlida. Introdueix una quantitat vàlida.")
    scanner.nextLine() // Netegem el buffer del scanner
}

/**
 * This method shows an invalid input
 * @author adrianRodriguez77
 * @author oscarsxrrano
 * @since 04/01/2024
 * @sample mostrarEntradaNoValida
 */

fun mostrarEntradaNoValida() {
    println("Entrada no vàlida. Introdueix un nombre vàlid.")
    scanner.nextLine() // Netegem el buffer del scanner
}
