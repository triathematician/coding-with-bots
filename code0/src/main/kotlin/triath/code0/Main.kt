//
// "HelloWorld" TornadoFx app built with ChatGPT
//   - initially assumed inexperience with getting projects up and running, so lots of asking it to debug/fix dir structures, pom's, versions, etc.
//
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
    override val root = label("Hello World")
}