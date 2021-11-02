fun main(args: Array<String>) {

    val name = "Madrigal"
    var healthPoints = 89
    val isBlessed = true
    val isImmortal = false

    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    val fireball  =     castFireball(5)
    printPlayerStatus(auraColor, isBlessed, name, healthStatus, fireball)
//    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String,
    fireball: String
) {
    println(
        "(Aura: $auraColor) " +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$name $healthStatus")
    println("$fireball")
}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =
    if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"


private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }


private fun castFireball(numFireballs: Int = 2) =
    when(numFireballs) {
        in 1..10 -> "Tipsy"
        in 11..20 -> "Sloshed"
        in 21..30 -> "Soused"
        in 31..40 -> "Stewed"
        in 41..50 -> "t0aSt3d"
        else -> "A glass of Fireball springs into existence. (x$numFireballs)"
    }

//    println("A glass of Fireball springs into existence. (x$numFireballs)")

