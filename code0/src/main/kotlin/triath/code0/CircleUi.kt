//
// "CircleViewModel" created with ChatGPT
//   - [N] see CirclePanel for some of the queries generating this
//   - [Q] this code is repetitive. can you extract the common spinner initialization code to a function
//   - [Q] remove amounttostepby, assume the value is always 0.5. make editable always true, so remove that parameter as well. specify min/max as a range instead of two properties
//   - [EP] tweaked to get the circle showing up again
//   - [Q] add a way to edit the color

package triath.code0

import javafx.beans.property.Property
import javafx.event.EventTarget
import tornadofx.*

class CircleUi : View() {
    // define a view model for editing a circle
    val model = MyCircle()

    override val root = form {
        fieldset("Circle") {
            field("X") {
                initSpinner(model.xProperty, -100.0..100.0)
            }
            field("Y") {
                initSpinner(model.yProperty, -100.0..100.0)
            }
            field("Radius") {
                initSpinner(model.rProperty, 0.0..100.0)
            }
            field("Color") {
                colorpicker(model.colorProperty)
            }
        }
    }

    // define the function for initializing spinners
    private fun EventTarget.initSpinner(
        property: Property<Double>,
        range: ClosedRange<Double>
    ) {
        spinner(property = property, min = range.start, max = range.endInclusive, amountToStepBy = 0.5, editable = true)
    }
}