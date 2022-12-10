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