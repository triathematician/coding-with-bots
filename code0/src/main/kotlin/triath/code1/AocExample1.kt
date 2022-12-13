//
// "AocExample1" built by ChatGPT to be an abstract AOC puzzle solver template
//
package triath.code1

class AocExample1: AdventOfCodeSolver() {
    override fun extractData(input: String, prompt: String): List<List<Int>> {
        val rows = input.split("\n")
            .map { it.split(" ").map { it.toInt() } }
        return rows
    }

    override fun solveChallenge(data: Any): Any {
        val rows = data as List<List<Int>>
        val checksum = rows.map { it.maxOrNull()!! - it.minOrNull()!! }.sum()
        return checksum
    }
}

fun main() {
    val solver = AocExample1()
    val input = """
5 1 9 5
7 5 3
2 4 6 8
""".trimIndent()
    val prompt = "What is the checksum for the spreadsheet in your puzzle input?"
    val answer = solver.parseAdventOfCodeInput(input, prompt)
    println(answer)
}