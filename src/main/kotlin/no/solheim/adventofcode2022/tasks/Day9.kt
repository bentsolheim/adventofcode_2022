package no.solheim.adventofcode2022.tasks

import kotlin.math.abs
import kotlin.math.max
import nonBlankLines

typealias Point = Pair<Int, Int>

val Point.x: Int get() = this.first
val Point.y: Int get() = this.second

class Day9(val input: String, val partCount: Int = 2) {

    // var head = 0 to 0
    var parts = (0..partCount - 1).map { Point(0, 0) }.toMutableList()

    // var tail = 0 to 0
    val tailTouches = mutableSetOf<Point>()

    fun getTailTouchCount(): Int {
        val moves = input.nonBlankLines().map { it.split(" ") }.map { it[0] to it[1].toInt() }
        var move = 0
        moves.forEach { (dir, count) ->
            repeat(count) {
                val (hdxi, hdyi) = when (dir) {
                    "R" -> 1 to 0
                    "U" -> 0 to 1
                    "D" -> 0 to -1
                    else -> -1 to 0
                }
                parts[0] = parts[0].run { x + hdxi to y + hdyi }

                (1 until parts.size).forEach { tailIndex ->
                    val headIndex = tailIndex - 1
                    val head = parts[headIndex]
                    val tail = parts[tailIndex]
                    val dx = head.x - tail.x
                    val dirX = if (dx != 0) dx / abs(dx) else 0
                    val dy = head.y - tail.y
                    val dirY = if (dy != 0) dy / abs(dy) else 0
                    var newTail = tail
                    if (abs(dx) == 2) {
                        val x = tail.x + dirX
                        val y = tail.y + if (dy != 0) dirY else 0
                        newTail = Point(x, y)
                    }
                    if (abs(dy) == 2) {
                        val x = tail.x + if (dx != 0) dirX else 0
                        val y = tail.y + dirY
                        newTail = Point(x, y)
                    }
                    parts[tailIndex] = newTail
                    if (tailIndex == parts.size - 1) {
                        tailTouches.addAll(listOf(tail, newTail))
                    }
                }
                println("${move++} - $dir ${it+1}/$count")
                printParts()
            }
        }
        println(parts)
        printTailTouches()
        return tailTouches.size
    }

    private fun printTailTouches() {
        val maxX = 25
        val maxY = 20
        val xOffset = 11
        val yOffset = 5
        val coordinates = (0..maxY).map { (0..maxX).map { "." }.toMutableList() }.toMutableList()
        coordinates[yOffset][xOffset] = "s"
        tailTouches.forEach { (x, y) -> coordinates[yOffset + y][xOffset + x] = "#" }
        coordinates.reversed().forEach { println(it.joinToString("")) }
    }

    private fun printParts() {
        val maxX = 25
        val maxY = 20
        val xOffset = 11
        val yOffset = 5
        val coordinates = (0..maxY).map { (0..maxX).map { "." }.toMutableList() }.toMutableList()
        coordinates[yOffset][xOffset] = "s"
        parts.reversed().forEachIndexed() { i, (x, y) ->
            val o = (parts.size - i).let { if (it == 1) "H" else "${it - 1}" }
            coordinates[yOffset + y][xOffset + x] = o
        }
        coordinates.reversed().forEach { println(it.joinToString("")) }
        println("\n")
    }
}
