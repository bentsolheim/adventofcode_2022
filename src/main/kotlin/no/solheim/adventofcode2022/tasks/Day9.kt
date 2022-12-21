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
        moves.forEach { (dir, count) ->
            repeat(count) {
                val (hdxi, hdyi) = when (dir) {
                    "R" -> 1 to 0
                    "U" -> 0 to 1
                    "D" -> 0 to -1
                    else -> -1 to 0
                }
                var head = parts[0]
                val newHead = head.run { x + hdxi to y + hdyi }
                val hdx = newHead.x - head.x
                val hdy = newHead.y - head.y
                parts[0] = newHead
                extracted(1, hdx, hdy)
                printParts()
            }
        }
        println(parts)
        printTailTouches()
        return tailTouches.size
    }

    private fun extracted(tailIndex: Int, hdx: Int, hdy: Int) {
        val headIndex = tailIndex - 1
        val head = parts[headIndex]
        val tail = parts[tailIndex]
        val dx = tail.x - head.x
        val dy = tail.y - head.y
        if (abs(dx) > 1 || abs(dy) > 1) {
            val newTail = head.copy(
                first = head.x + (hdx * -1),
                second = head.y + (hdy * -1)
            )
            val tdx = newTail.x - tail.x
            val tdy = newTail.y - tail.y
            parts[tailIndex] = newTail

            if (tailIndex != parts.size - 1) {
                extracted(tailIndex + 1, tdx, tdy)
            }
        }
        if (tailIndex == parts.size - 1) {
            tailTouches.add(tail)
        }
    }

    private fun printTailTouches() {
        val maxX = tailTouches.run { maxBy { (max(it.x, abs(it.x))) }.x * 2 } + 1
        val maxY = tailTouches.run { maxBy { (max(it.y, abs(it.y))) }.y * 2 } + 1
        val xOffset = maxX / 2
        val yOffset = maxY / 2
        val coordinates = (0..maxY).map { (0..maxX).map { "." }.toMutableList() }.toMutableList()
        tailTouches.forEach { (x, y) -> coordinates[yOffset + y][xOffset + x] = "#" }
        coordinates[yOffset][xOffset] = "s"
        coordinates.reversed().forEach { println(it.joinToString("")) }
    }

    private fun printParts() {
        val maxX = 30
        val maxY = 20
        val xOffset = maxX / 2
        val yOffset = maxY / 2
        val coordinates = (0..maxY).map { (0..maxX).map { "." }.toMutableList() }.toMutableList()
        parts.reversed().forEachIndexed() { i, (x, y) ->
            val o = (parts.size - i).let { if (it == 1) "H" else "${it-1}" }
            coordinates[yOffset + y][xOffset + x] = o
        }
        tailTouches.forEach { (x, y) -> coordinates[yOffset + y][xOffset + x] = "#" }
        coordinates[yOffset][xOffset] = "s"
        println("\n")
        coordinates.reversed().forEach { println(it.joinToString("")) }
    }
}
