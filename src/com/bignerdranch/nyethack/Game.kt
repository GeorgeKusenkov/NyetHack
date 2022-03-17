package com.bignerdranch.nyethack

fun main(args: Array<String>) {

    val player = Player("Egor", 99, true,false)
    val player2 = Player("Din")
    val player3 = Player("Kar")
    player.castFireball()

    val auraColor = player.auraColor(true)

    printPlayerStatus(player)
    printPlayerStatus(player2)
    printPlayerStatus(player3)

}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor(true)}) " +
                "(Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus(player.healthPoints, player.isBlessed)}")
}

//private fun castFireball(numFireballs: Int = 2) =
//    when(numFireballs) {
//        in 1..10 -> "Tipsy"
//        in 11..20 -> "Sloshed"
//        in 21..30 -> "Soused"
//        in 31..40 -> "Stewed"
//        in 41..50 -> "t0aSt3d"
//        else -> "A glass of Fireball springs into existence. (x$numFireballs)"
//    }

//    println("A glass of Fireball springs into existence. (x$numFireballs)")

