import java.io.File
import kotlin.math.roundToInt

const val TAVERN_NAME = "Taernyl's Folly"

var playerGold = 100
var playerSilver = 10

val patronList = mutableListOf("Eli", "Mordoc", "Sophie", "Borya", "Sanya")
val uniquePatrons = mutableSetOf<String>()
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")
val menuList = File("data/tavern-menu-data.txt")
    .readText()
    .split("\n")

fun main()  {


    println("*** Welcome to Taernyl's Folly ***\n")



    for (menuItem in menuList) {
        val (_, name, price) = menuItem.split(',')
        var newName = name.replaceFirstChar { it.uppercaseChar() }
        val nameLength = newName.length
        val nameList = mutableListOf<Int>()
        nameList += nameLength
        val MAX_LENGHT = 25
        val dotToAdd = MAX_LENGHT - nameLength

        (0..dotToAdd).forEach {
            newName += "."
        }

        println("$newName$price")

    }
//    val (type, name, price) = tavernMenu.split(',')
//
//    println(type)

    (0..9).forEach{
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
//    println(uniquePatrons)
    println()

    var orderCount = 0

    while (orderCount <= 9) {

        placeOrder(uniquePatrons.shuffled().first(),
                menuList.shuffled().first())
        orderCount++

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

//    performPurchase(price.toDouble())

    val phrase = if (name == "Dragon's Breath") {
//        "Madrigal exclaims: ${toDragonSpeak("Ah delicious $name!. IT'S GOT WHAT ADVENTURERS CRAVE!\n\n")}"
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}\n"
    } else {
//        "Madrigal says: Thanks for the $name.\n\n"
        "$patronName says: Thanks for the $name.\n\n"
    }
    println(phrase)
}