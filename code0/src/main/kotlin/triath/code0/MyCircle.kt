//
// "MyCircle" created with ChatGPT
//   - [Q] i am writing a tornadofx app. i want to edit and visualize a list of circles. create a view model for editing a circle using tornadofx form and itemviewmodel
//   - [Q] can you fix the code. xProperty, etc. don't exist
//   - [Q] now create a class called CircleUi that provides a tornadofx form for editing the CircleViewModel
//   - [Q] use a spinner instead of a textfield for editing the numbers
//   - [Q] i needed to change it to instantiate spinner like "spinner(property = circleModel.x, min = -100.0, max = 100.0, amountToStepBy = 0.1)", and i needed to cast the bound properties "as DoubleProperty" -- can you add these changes in and provide the result
//
// i end up removing [ItemViewModel] stuff because things weren't quite right
//
//   - [Q] since the model doesn't have a color, update it. here is the current class:
//

package triath.code0

import javafx.scene.paint.Color
import tornadofx.getProperty
import tornadofx.property

// define a data class to represent a circle
class MyCircle {
    var x by property(100.0)
    var y by property(100.0)
    var radius by property (50.0)
    var color by property(Color.BISQUE)

    val xProperty = getProperty(MyCircle::x)
    val yProperty = getProperty(MyCircle::y)
    val rProperty = getProperty(MyCircle::radius)
    val colorProperty = getProperty(MyCircle::color)
}

