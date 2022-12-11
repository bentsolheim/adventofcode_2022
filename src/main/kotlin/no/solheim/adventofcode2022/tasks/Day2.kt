package no.solheim.adventofcode2022.tasks

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import no.solheim.adventofcode2022.tasks.Day2.Companion.Move.P
import no.solheim.adventofcode2022.tasks.Day2.Companion.Move.R
import no.solheim.adventofcode2022.tasks.Day2.Companion.Move.S
import nonBlankLines

@Component
class Day2(@Value("classpath:/inputs/day_2.txt") val input: Resource) : DayTask {
    override fun run() {
        val codedMoves = input.nonBlankLines()
            .map { it.split(" ").let { (him, code) -> him to code } }

        val sumFirstStrategy = codedMoves
            .map { (him, code) -> moves[him]!! to moves[code]!! }
            .sumOf { (him, me) -> me.score(him) }
        println(sumFirstStrategy)

        val sumSecondStrategy = codedMoves
            .map { (him, code) -> moves[him]!! to code }
            .sumOf { (him, code) ->
                val me = when (code) {
                    "X" -> him.beatMove
                    "Y" -> him
                    else -> him.looseMove
                }
                me.score(him)
            }
        println(sumSecondStrategy)
    }

    companion object {
        enum class Move {
            R, P, S;

            fun beats(opponent: Move): Boolean = opponent == this.beatMove

            val beatMove get(): Move = Move.values()[(ordinal - 1).takeIf { it >= 0 } ?: 2]

            val looseMove get(): Move = Move.values()[(ordinal + 1).takeIf { it <= 2 } ?: 0]

            fun score(opponent: Move) = (if (beats(opponent)) 6 else if (this == opponent) 3 else 0) + (ordinal + 1)
        }

        val moves = mapOf("A" to R, "X" to R, "B" to P, "Y" to P, "C" to S, "Z" to S)
    }
}
