package org.example

import java.util.Scanner

var scanner = Scanner(System.`in`)

fun main() {

    var totalPreu = 0.0
    val detallsCompres = mutableListOf<String>()

    while (true) {
        println("Benvingut a la compra de bitllets!")

        val (bitllet, zona, quantitat) = demanarTickets()

        val preu = preuTickets(bitllet, zona, quantitat)
        totalPreu += preu

        val detallCompra = "$quantitat $bitllet amb zona $zona    $preu€"
        detallsCompres.add(detallCompra)

        mostrarTicket(bitllet, zona, quantitat, preu)

        println("Vols afegir un altre bitllet? (s/n)")
        val resposta = scanner.next()

        if (resposta.equals("n", ignoreCase = true)) {
            // Si l'usuari no vol afegir més bitllets, mostrar el resum i gestionar el pagament
            if (totalPreu > 0) {
                mostrarTicketTotal(detallsCompres, totalPreu)
                gestionarPagament(totalPreu)
            }

            // Netegem l'espai
            scanner.nextLine()

            // Sortim del bucle principal
            break
        }
    }
}



