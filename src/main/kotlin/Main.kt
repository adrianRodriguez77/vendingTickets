package org.example

import java.util.Scanner

var scanner = Scanner(System.`in`)

fun main() {

    var totalPreu = 0.0
    val detallsCompres = mutableListOf<String>()

    while (true) {
        println("Benvingut a la compra de bitllets!")

        var bitllet: String
        var zona: Int
        var quantitat: Int

        do {
            bitllet = opcMenuTickets()
            zona = opcZones()
            quantitat = quantitatTickets()

            val preu = preuTickets(bitllet, zona, quantitat)
            totalPreu += preu

            val detallCompra = "$quantitat $bitllet amb zona $zona    $preu€"
            detallsCompres.add(detallCompra)

            mostrarTicket(bitllet, zona, quantitat, preu)

            println("Vols afegir un altre bitllet? (s/n)")
        } while (scanner.next().equals("s", ignoreCase = true))

        // Mostrar resum només si s'han comprat bitllets
        if (totalPreu > 0) {
            mostrarTicketTotal(detallsCompres, totalPreu)

            // Sol·licitar els diners a l'usuari amb gestió d'errors
            var dinersIntroduits = 0.0
            var continuarIntroduint = true

            while (dinersIntroduits < totalPreu && continuarIntroduint) {
                print("Introdueix diners (només monedes i bitllets d'EURO): ")

                if (scanner.hasNextDouble()) {
                    when (val moneda = scanner.nextDouble()) {
                        in listOf(0.05, 0.10, 0.20, 0.50, 1.0, 2.0, 5.0, 10.0, 20.0, 50.0) -> {
                            dinersIntroduits += moneda
                            println("Diners introduïts: $dinersIntroduits€")

                            // Verificar si els diners són suficients
                            if (dinersIntroduits >= totalPreu) {
                                val canvi = dinersIntroduits - totalPreu
                                println("Compra satisfactòria. Canvi: $canvi€")
                                continuarIntroduint = false
                            }
                        }
                        else -> {
                            println("Moneda no vàlida. Introdueix una quantitat vàlida.")
                            scanner.nextLine() // Netegem el buffer del scanner
                        }
                    }
                } else {
                    println("Entrada no vàlida. Introdueix un nombre vàlid.")
                    scanner.nextLine() // Netegem el buffer del scanner
                }
            }
        }

        // Netegem l'espai
        scanner.nextLine()
    }
}

// Resta del codi...
