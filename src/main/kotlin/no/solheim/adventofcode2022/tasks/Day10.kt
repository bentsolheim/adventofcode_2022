package no.solheim.adventofcode2022.tasks

import java.lang.Integer.max
import java.lang.Integer.min
import nonBlankLines

class Day10(val input: String) {

    var registry = 1
    var cycle = 0

    val signalStrengthSamples = mutableListOf<Int>()

    fun getSignalStrengthSampleSums(): Int = signalStrengthSamples.sum()

    fun getScreen() = pixels.chunked(40).joinToString("\n") { it.joinToString("") }

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
        onCycleStart(cycle + 1, registry)
        updateScreen(cycle + 1, registry)
    }

    fun cycleEnd() {
        cycle++
    }

    fun onCycleStart(cycle: Int, registry: Int) {
        val sample: () -> Unit = { sampleSignalStrength(cycle, registry) }
        when (cycle) {
            20 -> sample()
            60 -> sample()
            100 -> sample()
            140 -> sample()
            180 -> sample()
            220 -> sample()
        }
    }

    fun sampleSignalStrength(cycle: Int, registry: Int) {
        signalStrengthSamples.add(cycle*registry)
    }

    val pixels = mutableListOf<String>()
    fun updateScreen(cycle: Int, registry: Int) {
        val spritePosition = (0..39).map { " " }.toMutableList().also {
            if (registry in 1..39) it[registry-1] = "#"
            if (registry in 0..39) it[registry] = "#"
            if (registry >= -1 && registry <= 38) it[registry + 1] = "#"
        }

        val colIndex = (cycle-1) % 40
        val pixel = spritePosition[colIndex]
        // println("%3s %2s %2s  ".format(cycle, registry, colIndex) + spritePosition.joinToString(""))
        pixels.add(pixel)
    }
}
