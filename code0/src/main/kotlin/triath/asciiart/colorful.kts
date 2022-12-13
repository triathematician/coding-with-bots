//
// "colorful.kts" built with ChatGPT to draw a bunch of circles in ascii art with random colors and overlaid text
//   - highly iterative, beginning with getting it to draw a circle with ascii art
//   - took some massaging to get it to draw multiple circles
//   - adding a banner took quite a bit of work -- it drew in the center, but spacing was weird and it had a lot of trouble with the border
//
package triath.asciiart

import java.util.Random
import kotlin.math.absoluteValue

// Generate the ASCII art circle as a matrix of strings
fun generateCircle(x: Int, y: Int, radius: Int, matrix: Array<Array<String>>) {
    // The characters and colors that will be used to draw the circle
    val chars = arrayOf('#', '@', '%', '+', '=', ':', '.')
    val colors = arrayOf("\u001B[91m", "\u001B[92m", "\u001B[93m", "\u001B[94m", "\u001B[95m", "\u001B[96m")
    val color = colors.random()

    // Draw the circle
    for (j in -radius..radius) {
        val row = j + y + radius + 1
        for (i in -radius*2..radius*2) {
            val col = i + x + radius*2 + 1
            if (i/2 * i/2 + j * j <= radius * radius) {
                if (row in matrix.indices && col in matrix[0].indices) {
                    matrix[row][col] = "${color}${chars.random()}"
                }
            }
        }
    }
}

// Generate random circles on a matrix of strings
fun generateRandomCircles(matrix: Array<Array<String>>) {
    // Generate 10 random circles
    for (i in 1..10) {
        val radius = Random().nextInt(6) + 2 // Generate a random radius between 2 and 7
        val x = Random().nextInt(matrix[0].size - radius * 2 - 1) // Generate a random x-coordinate
        val y = Random().nextInt(matrix.size - radius - 1) // Generate a random y-coordinate
        generateCircle(x, y, radius, matrix) // Generate the circle at the specified coordinates
    }
}

// Generate banner text on a matrix of strings
fun generateBanner(_text: String, matrix: Array<Array<String>>) {
    // The character that will be used for the border
    val borderChar = '*'

    val text = " " + _text.toList().joinToString(" ") + " "

    // Calculate the width of the banner
    val bannerWidth = text.length + 2 // Add 2 for the border on each side

    // Calculate the x-coordinate of the banner
    val x = (matrix[0].size - bannerWidth) / 2

    // Draw the border and the text
    for (row in matrix.indices) {
        if (row == matrix.size /2 ) {
            for (col in matrix[0].indices) {
                if (col == x || col == x + bannerWidth - 1) {
                    // Draw the border
                    matrix[row][col] = "\u001B[90;1m$borderChar\u001B[0m"
                } else if (col > x && col < x + bannerWidth - 1) {
                    // Draw the text in the middle row
                    matrix[row][col] = "\u001B[97;1m${text[col - x - 1]}\u001B[0m"
                }
            }
        } else if ((row - matrix.size/2).absoluteValue == 1) {
            (x..x+bannerWidth-1).onEach {
                matrix[row][it] = "\u001B[90;1m$borderChar\u001B[0m"
            }
        }
    }
}

// Create an empty matrix of strings
val matrix = Array(20) { Array(120) { " " } }
// Generate random circles on the matrix
generateRandomCircles(matrix)
// Generate banner text on the matrix
generateBanner("The World Will Never Be The Same", matrix)

// Print the matrix
for (row in matrix) {
    for (col in row) {
        print(col)
    }
    println()
}
