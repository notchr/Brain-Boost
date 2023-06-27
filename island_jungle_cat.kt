// Line 1:
import kotlin.math.absoluteValue

// Line 2:
fun main(args : Array<String>){

// Line 3:
    println("Welcome to Brain Boost!")

// Line 4:
    val userName = readLine()?.let {

// Line 5:
        if (it.isBlank()) {
            println("Please enter your name.")
            readLine()
        } else {
            it
        }

// Line 6:
    } ?: ""

// Line 7:
    println("Nice to meet you, $userName!")

// Line 8:
    var difficulty = 0

// Line 9:
    while (difficulty !in 1..3) {
        print("Please enter the difficulty level from 1 to 3: ")
        difficulty = readLine()?.toIntOrNull() ?: 0
    }

// Line 10:
    var questions = 0

// Line 11:
    while (questions !in 5..10) {
        print("Please enter the number of questions from 5 to 10: ")
        questions = readLine()?.toIntOrNull() ?: 0
    }

// Line 12:
    val brainBoostGame = BrainBoostGame(difficulty, questions)

// Line 13:
    brainBoostGame.startGame()

// Line 14:
    val score = brainBoostGame.calculateScore()

// Line 15:
    println("Congratulations, $userName! Your score is: $score")

// Line 16:
    val rating = when (score.absoluteValue) {
        in 0..20 -> "Beginner"
        in 21..50 -> "Intermediate"
        in 51..100 -> "Advanced"
        else -> "Professional"
    }

// Line 17:
    println("You are now a $rating Brain Boost player!")

// Line 18:
    println("Thanks for playing Brain Boost!")
}

// Line 19:
//Brain Boost class
class BrainBoostGame(val difficulty: Int, val questions: Int) {

// Line 20:
    private var answer: Int = 0

// Line 21:
    private var score = 0

// Line 22:
    fun startGame() {
        for (i in 1..questions) {
            println("Question $i:")
            val a = (Math.random() * difficulty * 10).toInt()
            val b = (Math.random() * difficulty * 10).toInt()

// Line 23:
            print("What is the sum of $a and $b? ")
            answer = readLine()?.toIntOrNull() ?: 0

// Line 24:
            if (answer == a + b) {
                println("Correct!")
                score += 10
            } else {
                println("Wrong answer! The correct answer is ${a + b}")
            }
        }
    }

// Line 25:
    fun calculateScore(): Int = score 
}