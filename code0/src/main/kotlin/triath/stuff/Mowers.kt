//
// "Mowers.kt" built by ChatGPT to generate a random lawnmower name
//
package triath.stuff

// list of potential words for the lawnmower name
val words = listOf("mighty", "guardian", "leviathan", "gladiator", "voyager",
    "terminator", "glory", "guardian", "legend", "goliath")

// list of potential verbs for the lawnmower name
val verbs = listOf("clearing", "cutting", "slicing", "mowing", "trimming",
    "shearing", "slashing", "whacking", "chopping", "hacking")

// define a function to generate a lawnmower name
fun generateLawnmowerName(): String {
    // choose a random word and verb from the lists
    val word = words.random()
    val verb = verbs.random()

    // use the chosen word and verb to create the lawnmower name
    return "The ${word.capitalize()} Mower of ${verb.capitalize()}"
}

fun main() {
    repeat(10) { println(generateLawnmowerName()) }
}