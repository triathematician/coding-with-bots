//
// "CircleViewModel" created with ChatGPT
//   - [Q] i am writing a tornadofx app. i want to edit and visualize a list of circles. create a view model for editing a circle using tornadofx form and itemviewmodel
//   - [Q] can you fix the code. xProperty, etc. don't exist
//   - [Q] now create a class called CircleUi that provides a tornadofx form for editing the CircleViewModel
//   - [Q] use a spinner instead of a textfield for editing the numbers
//   - [Q] i needed to change it to instantiate spinner like "spinner(property = circleModel.x, min = -100.0, max = 100.0, amountToStepBy = 0.1)", and i needed to cast the bound properties "as DoubleProperty" -- can you add these changes in and provide the result
//

package triath.code0

import javafx.beans.property.DoubleProperty
import tornadofx.*

// define a data class to represent a circle
data class Circle(var x: Double = 0.0, var y: Double = 0.0, var radius: Double = 0.0)

// define a view model for editing a circle
class CircleViewModel : ItemViewModel<Circle>() {
    // define properties for each field of the circle
    val x = bind(Circle::x)
    val y = bind(Circle::y)
    val radius = bind(Circle::radius)
}

class CircleUi : View() {
    // define a view model for editing a circle
    val circleModel = CircleViewModel()

    override val root = form {
        fieldset("Circle") {
            field("X") {
                spinner(property = circleModel.x as DoubleProperty, min = -100.0, max = 100.0, amountToStepBy = 0.1)
            }
            field("Y") {
                spinner(property = circleModel.y as DoubleProperty, min = -100.0, max = 100.0, amountToStepBy = 0.1)
            }
            field("Radius") {
                spinner(property = circleModel.radius as DoubleProperty, min = 0.0, max = 100.0, amountToStepBy = 0.1)
            }
        }
    }
}
