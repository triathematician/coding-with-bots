// Define the string template for the ASCII art
val template = """
    __ __
   /  V  \\
   \\    /
    \\  /
     \\/
  """

// Define the string template for the ASCII art
val template2 = """
   _____    
--/     \__/==  - - - - -
--\  /\  \ \
--/  \/  /_/
--\_____/  \==  - - - - - 
  """


// Create a variable to track the position of the art
var position = 0

// Create a simple animation loop
while (true) {
    // Split the template into individual lines
    val lines = template2.split("\n")

    // Add space to each line using padStart
    val paddedLines = lines.map { it.padStart(it.length + position, ' ') }

    // Join the lines back together
    val art = paddedLines.joinToString("\n")

    // Print the frame
    println(art)

    // Move the art to the right by one space
    position+=5

    // If the art has moved off the right side of the screen, reset its position
    if (position > 80) position = 0

    // Sleep for a short time before generating the next frame
    Thread.sleep(500)
}