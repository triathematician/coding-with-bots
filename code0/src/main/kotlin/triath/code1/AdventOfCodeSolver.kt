//
// "AdventOfCodeSolver" built by ChatGPT to be an abstract AOC puzzle solver template
//
package triath.code1

abstract class AdventOfCodeSolver {
    abstract fun extractData(input: String, prompt: String): Any
    abstract fun solveChallenge(data: Any): Any

    fun parseAdventOfCodeInput(input: String, prompt: String): Any {
        val data = extractData(input, prompt)
        val answer = solveChallenge(data)
        return answer
    }
}