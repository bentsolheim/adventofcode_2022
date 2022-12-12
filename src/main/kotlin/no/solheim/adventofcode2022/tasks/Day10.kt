package no.solheim.adventofcode2022.tasks

import nonBlankLines

class Day10(val input: String) {

    var registry = 1
    var cycle = 0

    val signalStrengthSamples = mutableListOf<Int>()
    val pixels = mutableListOf<String>()

    fun getSignalStrengthSampleSums() = signalStrengthSamples.sum()

    fun getScreen() = pixels.chunked(Companion.screenWidth).joinToString("\n") { it.joinToString("") }

    fun runInstructions() {
        input.nonBlankLines().map { it.split(" ") }.forEach {
            val cmd = it[0]
            when (cmd) {
                "noop" -> {
                    cycleStart()
                    cycleEnd()
                }

                "addx" -> {
                    cycleStart()
                    cycleEnd()
                    cycleStart()
                    registry += it[1].toInt()
                    cycleEnd()
                }
            }
        }
    }

    fun cycleStart() {
        val startedCycle = cycle + 1
        if (startedCycle in listOf(20, 60, 100, 140, 180, 220)) {
            signalStrengthSamples.add(startedCycle * registry)
        }
        updateScreen(startedCycle, registry)
    }

    fun cycleEnd() {
        cycle++
    }

    fun updateScreen(cycle: Int, registry: Int) {
        val colIndex = (cycle - 1) % screenWidth
        val pixel = if (colIndex in registry - 1..registry + 1) "#" else " "
        pixels.add(pixel)
    }

    companion object {
        const val screenWidth = 40
    }
}
