//
// "marvel.kts" built by ChatGPT to simulate battles between marvel characters
//   - no corrections made
//
package triath.stuff

enum class Power {
    STRENGTH,
    HAND_TO_HAND_COMBAT,
    INTELLIGENCE,
    MIND_WARS,
    SPEED,
    FLIGHT,
    INVISIBILITY,
    ENERGY_BLASTS
}

class Character(val name: String, val powers: Set<Power>) {
    fun fight(opponent: Character): Character? {
        var winner: Character? = null
        when {
            Power.HAND_TO_HAND_COMBAT in powers && Power.MIND_WARS in opponent.powers -> winner = this
            Power.MIND_WARS in powers && Power.HAND_TO_HAND_COMBAT in opponent.powers -> winner = opponent
            Power.HAND_TO_HAND_COMBAT in powers && Power.HAND_TO_HAND_COMBAT in opponent.powers ->
                winner = if (Power.STRENGTH in powers) this else opponent
            Power.MIND_WARS in powers && Power.MIND_WARS in opponent.powers ->
                winner = if (Power.INTELLIGENCE in powers) this else opponent
        }
        return winner
    }
}

// Define some characters
val thor = Character("Thor", setOf(Power.STRENGTH, Power.HAND_TO_HAND_COMBAT, Power.FLIGHT))
val loki = Character("Loki", setOf(Power.INTELLIGENCE, Power.MIND_WARS, Power.INVISIBILITY))
val hulk = Character("Hulk", setOf(Power.STRENGTH, Power.HAND_TO_HAND_COMBAT))
val captainAmerica = Character("Captain America", setOf(Power.HAND_TO_HAND_COMBAT, Power.STRENGTH, Power.SPEED))
val ironMan = Character("Iron Man", setOf(Power.INTELLIGENCE, Power.ENERGY_BLASTS))

// Simulate a battle between Thor and Loki
var winner = thor.fight(loki)
println(winner?.name) // Thor

// Simulate a battle between Thor and Hulk
winner = thor.fight(hulk)
println(winner?.name) // Hulk

// Simulate a battle between Captain America and Iron Man
winner = captainAmerica.fight(ironMan)
println(winner?.name) // Captain America
