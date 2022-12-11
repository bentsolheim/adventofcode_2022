package no.solheim.adventofcode2022.tasks

import nonBlankLines

class Day5(val input: String) {
    val crateCode: String get() {

        val (cratesTxt, movesTxt) = input.split("\n\n")

        val columns = parseColumns(cratesTxt)
        val moves = parseMoves(movesTxt)
        moves.move(columns)

        return columns.values.joinToString("") { it.last() }
    }

    private fun List<Move>.move(columns: MutableMap<Int, MutableList<String>>) {
        forEach {
            for (i in 0..it.count-1) {
                val c = columns[it.from]!!.removeLast()
                columns[it.to]!!.add(c)
            }
        }
    }

    private fun parseColumns(cratesTxt: String): MutableMap<Int, MutableList<String>> {
        val columns = mutableMapOf<Int, MutableList<String>>()
        val lines = cratesTxt.nonBlankLines()
        val crateLines = lines.subList(0, lines.size - 1)
        val indexLine = lines.last()
        indexLine.forEachIndexed { i, c ->
            if (c == ' ') return@forEachIndexed
            val columnIndex = c.toString().toInt()
            val column = columns.computeIfAbsent(columnIndex) { _ -> mutableListOf() }
            crateLines.reversed().forEach { line ->
                if (line.length < i) return@forEach
                val code = line.substring(i, i + 1)
                if (code != " ") {
                    column.add(code)
                }
            }
        }
        return columns
    }

    data class Move(val count: Int, val from: Int, val to: Int)

    private fun parseMoves(movesTxt: String): List<Move> {
        return movesTxt.nonBlankLines()
            .map { it.replace("move ", "").replace(" from ", ",").replace(" to ", ",").split(",") }
            .map { (count, from, to) -> Move(count.toInt(), from.toInt(), to.toInt()) }
    }
}
