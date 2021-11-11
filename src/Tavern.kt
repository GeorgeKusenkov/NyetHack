import java.util.*

fun main()  {
//    var beverage = readLine()?.replaceFirstChar { it.uppercaseChar() }
//    println(beverage)

    var beverage = readLine()?.let {
        if (it.isNotBlank()) {
            it.replaceFirstChar { it.uppercaseChar() }
        } else {
            "Buttered Ale"
        }
    }
//    beverage = null
    println(beverage)
}