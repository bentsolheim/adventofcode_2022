package no.solheim.adventofcode2022.tasks

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

enum class Move(val score: Int) {
    Rock(1),
    Paper(2),
    Scissors(3)
}

class Game(val p1Move: Move, val p2Move: Move) {
    val p1Score get(): Int {
        return 0
    }
}

@Component
class Day2(@Value("classpath:/inputs/day_2.txt") val input: Resource) : DayTask {
    override fun run() {
        val input = this.input.file.readText()
        input.split("\n").map { 
            val (him, me) = it.split(" ") 
            val hisMove = when(him) {
                "A" -> Move.Rock
                "B" -> Move.Paper
                else -> Move.Scissors
            }
            val myMove = when(me) {
                "X" -> Move.Rock
                "Y" -> Move.Paper
                else -> Move.Scissors
            }

            val game = Game(myMove, hisMove)
            println(game.p1Score)
        }
    }
}
