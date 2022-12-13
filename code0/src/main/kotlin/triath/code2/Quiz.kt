package triath.code2

class Quiz {
    val numQuestions = 3 // Number of questions to ask
    val questions = listOf(
        "本を読みますか。 (ほんをよみますか。) - Do you read __?",
        "書を書きますか。 (かをかきますか。) - Do you write __?",
        "食べ物は何ですか。 (たべものはなんですか。) - What is the __?"
    )
    val answers = listOf(
        listOf("1. Hair", "2. Run", "3. Bird", "4. Spicey", "5. Books", "6. Tall"),
        listOf("1. Cars", "2. Rice", "3. Hair", "4. Pictures", "5. Dogs", "6. Writing"),
        listOf("1. Drink", "2. Food", "3. Hat", "4. Pen", "5. Dog", "6. Car")
    )

    fun askQuestions() {
        for (i in 0 until numQuestions) {
            askQuestion(i)
        }
    }

    fun askQuestion(index: Int) {
        println(questions[index])
        for (answer in answers[index]) {
            println(answer)
        }
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Quiz().askQuestions()
        }
    }
}