package com.bignerdranch.nyethack

import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"

val patronList = mutableListOf("Eli", "Mordoc", "Sophie", "Borya", "Sanya")
val uniquePatrons = mutableSetOf<String>()
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val menuList = File("data/tavern-menu-data.txt")
    .readText()
    .split("\n")
val patronGold = mutableMapOf<String, Double>()

fun main()  {

//    println("*** Welcome to Taernyl's Folly ***\n")

    for (menuItem in menuList) {
        var (_, name, price) = menuItem.split(',')
        name = name.replaceFirstChar { it.uppercaseChar() }
        val nameLength = name.length
        val nameList = mutableListOf<Int>()
        nameList += nameLength
        val MAX_LENGHT = 25
        val dotToAdd = MAX_LENGHT - nameLength

        (0..dotToAdd).forEach {
            name += "."
        }

//        println("$name$price")

    }

    (0..9).forEach{
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }

    uniquePatrons.forEach{
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(
            uniquePatrons.shuffled().first(),
                menuList.shuffled().first())
        orderCount++
    }

//    com.bignerdranch.nyethack.displayPatronBalances()
}

fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}


private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[AEIOUaeiou]")) {
        val charSequence: CharSequence = when (it.value) {
            "A" -> "4"
            "E" -> "3"
            "I" -> "1"
            "O" -> "0"
            "U" -> "|_|"
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            else -> it.value
        }
        charSequence
    }

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
//    println("Madrigal speaks with $tavernMaster about their order.")
    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
//    val message = "Madrigal buys a $name ($type) for $price"
    val message = "$patronName buys a $name ($type) for $price."
    println(message)

    performPurchase(price.toDouble(), patronName)

    val phrase = if (name == "Dragon's Breath") {
//        "Madrigal exclaims: ${com.bignerdranch.nyethack.toDragonSpeak("Ah delicious $name!. IT'S GOT WHAT ADVENTURERS CRAVE!\n\n")}"
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}\n"
    } else {
//        "Madrigal says: Thanks for the $name.\n\n"
        "$patronName says: Thanks for the $name.\n\n"
    }
    println(phrase)
}

private fun displayPatronBalances() {
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}