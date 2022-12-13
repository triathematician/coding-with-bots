//
// "HelloWorld" TornadoFx app built with ChatGPT
//   - [EP] initially assumed inexperience with getting projects up and running, so lots of asking it to debug/fix dir structures, pom's, versions, etc.
//   - [Q] i have this MainView. Show me how to add CircleUi on the right side of this view (copied [MainView] skeleton)
//   - [Q] do this by injection
//   - [Q]
//   - [Q]
//   - [Q]
//   - [Q]
//   - [Q]

package triath.code0

import tornadofx.*

class Main : App(MainView::class) {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch<Main>()
        }
    }
}

class MainView : View() {
    // define the circle view
    val circleView: CircleUi by inject()

    override val root = borderpane {
        // add the circle view to the right side of the border pane
        right = circleView.root
        center = label("Hello World")
    }
}