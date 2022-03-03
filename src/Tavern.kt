import java.util.*

const val TAVERN_NAME = "Taernyl's Folly"

fun main()  {

    placeOrder("shandy,Dragon's Breath,5.91")
    placeOrder("elixir,Shirley's Temple,4.12")
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


private fun placeOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

//    val data = menuData.split(',')
//    val type = data[0]
//    val name = data[1]
//    val price = data[2]

    val (type, name, price) = menuData.split(',')
    val message = "Madrigal buys a $name ($type) for $price"
    println(message)

//    val phrase = "Ah, delicious $name!"
//    println("Madrigal exclaims: ${toDragonSpeak(phrase)}")

    val phrase = if (name == "Dragon's Breath") {
        "Madrigal exclaims: ${toDragonSpeak("Ah delicious $name!. IT'S GOT WHAT ADVENTURERS CRAVE!")}"
    } else {
        "Madrigal says: Thanks for the $name."
    }
    println(phrase)
}