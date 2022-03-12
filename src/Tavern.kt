import java.io.File
import java.util.*
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 100
var playerSilver = 10

val patronList = mutableListOf("Eli", "Mordoc", "Sophie")
val menuList = File ("data/tavern-menu-data.txt")
    .readText()
    .split("\n")

fun main()  {

//    if (patronList.contains("Eli")) {
//        println("The tavern master says: Eli's in the back playing cards.")
//    } else {
//        println("The tavern master says: Eli isn't here.")
//    }
//
//    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
//        println("The tavern master says: Yea, they're seated by the stew kettle.")
//    } else {
//        println("The tavern master says: Nay, they departed hours ago.")
//    }

//    placeOrder("shandy,Dragon's Breath,5.91")
//    println(patronList.getOrElse(4) { "Unknown Patron" })
//    placeOrder("elixir,Shirley's Temple,4.12")

    patronList.forEachIndexed { index, patron ->
        println("Good evening, $patron - you're #${index + 1} in line.")
//        placeOrder(patron, "shandy,Dragon's Breath,5.91")
        placeOrder(patron, menuList.shuffled().first())
    }

    menuList.forEachIndexed { index, data ->
        println("$index : $data")
    }

    for (patron in patronList) {
        println("Good evening, $patron")
    }
}

fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    val  remainingBalance: Double

    if (totalPurse > price) {
        remainingBalance = totalPurse - price
        println("Remaining balance: ${"%.2f".format(remainingBalance)}")
    } else {
        remainingBalance = totalPurse
        println("Taernyl say: You have not money for this")
    }

    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold, Silver: $playerSilver")
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

    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
//        "Madrigal exclaims: ${toDragonSpeak("Ah delicious $name!. IT'S GOT WHAT ADVENTURERS CRAVE!\n\n")}"
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}\n\n"
    } else {
//        "Madrigal says: Thanks for the $name.\n\n"
        "$patronName says: Thanks for the $name.\n\n"
    }
    println(phrase)
}