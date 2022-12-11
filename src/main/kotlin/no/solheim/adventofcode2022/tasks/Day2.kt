package no.solheim.adventofcode2022.tasks

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import no.solheim.adventofcode2022.tasks.Move.*

enum class Move(val score: Int) { R(1), P(2), S(3) }

val moves = mapOf("A" to R, "X" to R, "B" to P, "Y" to P, "C" to S, "Z" to S)

fun score(player: Move, opponent: Move): Int {
    return 0
}

@Component
class Day2(@Value("classpath:/inputs/day_2.txt") val input: Resource) : DayTask {
    override fun run() {
        val input = this.input.file.readText()
        input.split("\n").map {
            val (him, me) = it.split(" ").map { moves[it]!! }
            println(score(me, him))
        }
    }
}
