package org.example

import java.util.Scanner

var scanner = Scanner(System.`in`)

fun main() {

    while (true){
        val bitllet = opcMenuTickets()

        val zona = opcZones()

        val quantitat = quantitatTickets()

        // Juntamos precio final en una variable y redondeamos a formato 2 decimales (euros)
        val preu = preuTickets(bitllet, zona, quantitat)
        /*val preuRedondeado = String.format("%.2f", preu).toDouble()*/

        println("$GREEN_BACKGROUND_BRIGHT$WHITE_BOLD_BRIGHT $quantitat $bitllet amb zona $zona - Preu: $preu€ - COMPRAT AMB ÈXIT!!! $WHITE_BACKGROUND_BRIGHT$BLUE_BOLD_BRIGHT$RESET\n"
                )

        when (bitllet) {
            "Bitllet Senzill" -> asciiBitlletSenzill()
            "TCasual" -> asciiTCasual()
            "TUsual" -> asciiTUsual()
            "TFamiliar" -> asciiTFamiliar()
            "TJove" -> asciiTJove()
        }
        //Netejar buffer
        scanner.nextLine()

    }


}