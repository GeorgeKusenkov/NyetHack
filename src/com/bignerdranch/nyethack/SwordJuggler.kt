package com.bignerdranch.nyethack

import java.lang.Exception

class SwordJuggler {
}

fun main() {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if(isJugglingProficient) {
        swordsJuggling = 2
    }

    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    } catch (e: Exception) {
        println(e)
    }

    println("You juggle $swordsJuggling swords!")
}

fun proficiencyCheck (swordJuggling: Int?) {
      checkNotNull(swordJuggling) { "com.bignerdranch.nyethack.Player cannot juggle swords" }
//    swordJuggling ?: throw com.bignerdranch.nyethack.UnskilledSwordJugglerException()
//    swordJuggling ?: throw IllegalStateException("com.bignerdranch.nyethack.Player cannot juggle swords")
}

class UnskilledSwordJugglerException: IllegalStateException("com.bignerdranch.nyethack.Player cannot juggle swords")