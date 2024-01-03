package org.example

import java.util.Scanner

var scanner = Scanner(System.`in`)

fun main() {

    while (true){
        val bitllet = opcMenuTickets()
        val zona = opcZones()
        print("\nQuants bitllets vols comprar? ")
        val quantitat = quantitatTickets()
        println("$bitllet amb zona $zona té un preu de ${preuTickets(bitllet, zona, quantitat)}€\n")
    }

}