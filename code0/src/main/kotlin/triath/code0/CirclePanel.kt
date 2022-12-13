//
// "CirclePanel" created with ChatGPT
//   - [Q] now replace the label in the main with a javafx panel, containing a circle with the given size and position. i want the circle to be bound to the form, so when you edit the form the circle updates
//   - [Q] move that panel definition to a new class
//
// it creates fantasy "panel {}" and "circle {}" calls that kinda look right, but don't work
//
//   - [Q] using "panel {}" isn't quite right since that doesn't exist in javafx. can you create the component directly, using a constructor and "apply { }"
//   - [Q] hmm, Panel doesn't appear to be a JavaFx thing. can you suggest a different component that is javafx
//
// runs after tweaking code to use an ellipse, but nothing shows up ...
// ended up being hard enough to debug code that i threw it mostly out ...
//

package triath.code0

import javafx.scene.layout.Pane
import tornadofx.*

class CirclePanel(val circleModel: MyCircle = MyCircle()) : View() {
    override val root = Pane().apply {
        children += javafx.scene.shape.Circle().apply {
            centerXProperty().bind(circleModel.xProperty)
            centerYProperty().bind(circleModel.yProperty)
            radiusProperty().bind(circleModel.rProperty)
            fillProperty().bind(circleModel.colorProperty)
        }
    }
}