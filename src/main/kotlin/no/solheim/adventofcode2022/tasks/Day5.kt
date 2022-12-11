package no.solheim.adventofcode2022.tasks

import nonBlankLines

class Day5(val input: String) {

    val cratesTxt: String
    val moves: List<Move>

    init {
        val (cratesTxt, movesTxt) = input.split("\n\n")
        this.cratesTxt = cratesTxt
        moves = parseMoves(movesTxt)
    }
    val crateCode: String get() {
        val columns = parseColumns(cratesTxt)
        moves.move(columns)
        return columns.generateCode()
    }

    val crateCode2: String get() {
        val columns = parseColumns(cratesTxt)
        moves.move2(columns)
        return columns.generateCode()
    }

    private fun MutableMap<Int, MutableList<String>>.generateCode(): String {
        return this.values.joinToString("") { it.last() }
    }

    private fun List<Move>.move(columns: MutableMap<Int, MutableList<String>>) {
        forEach {
            for (i in 0 until it.count) {
                val c = columns[it.from]!!.removeLast()
                columns[it.to]!!.add(c)
            }
        }
    }

    private fun List<Move>.move2(columns: MutableMap<Int, MutableList<String>>) {
        forEach {
            for (i in 0 until it.count) {
                val c = columns[it.from]!!.removeLast()
                columns[it.to]!!.add(columns[it.to]!!.size - i, c)
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
