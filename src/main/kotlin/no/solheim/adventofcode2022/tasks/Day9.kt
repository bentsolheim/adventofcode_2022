package no.solheim.adventofcode2022.tasks

import kotlin.math.abs

typealias Point = Pair<Int, Int>

val Point.x: Int get() = this.first
val Point.y: Int get() = this.second

private fun Point.move(dir: String): Point {
    val (dx, dy) = when (dir) {
        "R" -> 1 to 0
        "U" -> 0 to 1
        "D" -> 0 to -1
        else -> -1 to 0
    }
    return this.run { x + dx to y + dy }
}

private fun Point.moveTowards(head: Point): Point {
    val dx = head.x - x
    val dirX = if (dx != 0) dx / abs(dx) else 0
    val dy = head.y - y
    val dirY = if (dy != 0) dy / abs(dy) else 0
    return if (abs(dx) == 2) Point(x + dirX, y + if (dy != 0) dirY else 0)
    else if (abs(dy) == 2) Point(x + if (dx != 0) dirX else 0, y + dirY)
    else this
}

class Day9(val input: String, partCount: Int = 2) {

    private var parts = (0 until partCount).map { Point(0, 0) }.toMutableList()

    private val tailTouches = mutableSetOf<Point>()

    fun getTailTouchCount(): Int {
        val moves = input.nonBlankLines().map { it.split(" ") }.map { it[0] to it[1].toInt() }
        moves.forEachIndexed { move, (dir, count) ->
            repeat(count) { rep ->
                // Move head
                parts[0] = parts[0].move(dir)

                // Then move the other parts
                (1 until parts.size).forEach { tailIndex ->
                    parts[tailIndex] = parts[tailIndex].moveTowards(parts[tailIndex - 1])
                }

                tailTouches.add(parts.last())

                parts.print("$move - $dir ${rep + 1}/$count")
            }
        }
        tailTouches.print()
        return tailTouches.size
    }
}

private fun Set<Point>.print() {
    if (!print) return
    CoordinateSystem().also {
        this.draw(it)
        println(it)
    }
}

private fun List<Point>.print(title: String = "") {
    if (!print) return
    CoordinateSystem().also {
        this.draw(it)
        println("\n$title")
        println(it)
    }
}

class CoordinateSystem(
    private val maxX: Int = 25,
    private val maxY: Int = 20,
    private val xOffset: Int = 11,
    private val yOffset: Int = 5,
    private val coordinates: MutableList<MutableList<String>> = (0..maxY)
        .map { (0..maxX).map { "." }.toMutableList() }
        .toMutableList()
) {

    init {
        coordinates[yOffset][xOffset] = "s"
    }

    fun set(x: Int, y: Int, value: String) {
        coordinates[yOffset + y][xOffset + x] = value
    }

    override fun toString(): String = coordinates.reversed().joinToString("\n") { it.joinToString("") }
}

private fun Set<Point>.draw(coordinates: CoordinateSystem) {
    forEach { (x, y) -> coordinates.set(x, y, "#") }
}

private fun List<Point>.draw(coordinates: CoordinateSystem) {
    this.reversed().forEachIndexed() { i, (x, y) ->
        val o = (this.size - i).let { if (it == 1) "H" else "${it - 1}" }
        coordinates.set(x, y, o)
    }
}
