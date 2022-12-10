//
// "TicTacToeGame" built by ChatGPT
//   - very limited human involvement, it just created some duplicate var's, mixed up java get/set and kotlin notation a bit
//   - also some iteration to get it to take user input, and terminate the game when it is over
//

package triath.tictactoe

class TicTacToeGame {
    private val board = arrayOf(
        arrayOf(' ', ' ', ' '),
        arrayOf(' ', ' ', ' '),
        arrayOf(' ', ' ', ' ')
    )

    private var currentPlayer = 1
    private var gameOver = false
    private var gameWon = false
    private var lastMove: Pair<Int, Int>? = null
    private var winningPlayer: Int? = null

    val boardString: String
        get() {
            val sb = StringBuilder()
            for (i in 0 until 3) {
                for (j in 0 until 3) {
                    sb.append(board[i][j])
                    if (j < 2) {
                        sb.append("|")
                    }
                }
                sb.append("\n")
                if (i < 2) {
                    sb.append("-+-+-\n")
                }
            }
            return sb.toString()
        }

    fun playTurn(x: Int, y: Int) {
        if (gameOver || x < 0 || x > 2 || y < 0 || y > 2 || board[x][y] != ' ') {
            return
        }

        board[x][y] = if (currentPlayer == 1) 'X' else 'O'
        lastMove = Pair(x, y)
        checkGameOver()
    }

    private fun checkGameOver() {
        val emptySpaces = board.any { row -> row.any { it == ' ' } }
        gameOver = !emptySpaces

        if (lastMove != null) {
            val (x, y) = lastMove!!
            val token = board[x][y]
            gameWon = (board[0][y] == token && board[1][y] == token && board[2][y] == token) ||
                    (board[x][0] == token && board[x][1] == token && board[x][2] == token) ||
                    (board[0][0] == token && board[1][1] == token && board[2][2] == token) ||
                    (board[0][2] == token && board[1][1] == token && board[2][0] == token)

            if (gameWon) {
                winningPlayer = currentPlayer
            }
        }

        if (!gameOver) {
            currentPlayer = if (currentPlayer == 1) 2 else 1
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val game = TicTacToeGame()

            while (!game.gameOver) {
                // Print the current state of the board
                println(game.boardString)

                // Ask the current player for input
                print("Player ${game.currentPlayer}, enter coordinates (x y): ")
                val input = readLine()!!.split(" ")
                val x = input[0].toInt()
                val y = input[1].toInt()

                // Play the turn
                game.playTurn(x, y)

                // If the game is won, break out of the loop
                if (game.gameWon) {
                    break
                }
            }

            // Print the final state of the board
            println(game.boardString)

            // Print the result of the game
            if (game.gameWon) {
                println("Player ${game.winningPlayer} wins!")
            } else {
                println("It's a tie!")
            }
        }
    }
}
