package no.solheim.adventofcode2022.tasks

import kotlin.math.abs
import nonBlankLines

class Day9(val input: String) {

    var head = 0 to 0
    var tail = 0 to 0
    val tailTouches = mutableSetOf<Pair<Int, Int>>()

    fun getTailTouchCount(): Int {
        val moves = input.nonBlankLines().map { it.split(" ") }.map { it[0] to it[1].toInt() }
        moves.forEach { (dir, count) ->
            repeat(count) {
                val (hdx, hdy) = when (dir) {
                    "R" -> 1 to 0
                    "U" -> 0 to 1
                    "D" -> 0 to -1
                    else -> -1 to 0
                }
                head = head.run { first + hdx to second + hdy }
                if (abs(head.first - tail.first) > 1 || abs(head.second - tail.second) > 1) {
                    tail = head.copy(first = head.first + (hdx * -1), second = head.second + (hdy * -1))
                }
                tailTouches.add(tail)
            }
        }
        return tailTouches.size
    }

    private fun printTailTouches() {
        val maxX = tailTouches.maxBy { it.first }.first + 1
        val maxY = tailTouches.maxBy { it.second }.second + 1
        val coordinates = (0..maxY).map { (0..maxX).map { "." }.toMutableList() }.toMutableList()
        tailTouches.forEach { (x, y) -> coordinates[y][x] = "#" }
        coordinates.reversed().forEach { println(it.joinToString("")) }
    }
}
