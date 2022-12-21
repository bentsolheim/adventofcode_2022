package no.solheim.adventofcode2022.tasks

import nonBlankLines

class Day9(val input: String) {

    var head = 0 to 0
    var tail = 0 to 0

    init {
        val moves = input.nonBlankLines().map { it.split(" ") }.map { it[0] to it[1].toInt() }
        moves.forEach { (dir, count) ->
            val (dx, dy) = when(dir) {
                "R" -> count to 0
                "U" -> 0 to count
                "D" -> 0 to -count
                else -> -count to 0
            }
            head = Pair(head.first + dx, head.second + dy)

            when {

            }
            println("$dir $count -> $head")
        }
    }
}
