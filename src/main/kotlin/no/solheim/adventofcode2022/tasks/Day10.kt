package no.solheim.adventofcode2022.tasks

import nonBlankLines

class Day10(val input: String) {

    var registry = 1
    var cycle = 0

    val signalStrengthSamples = mutableListOf<Int>()

    fun getSignalStrengthSampleSums(): Int {
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

        return signalStrengthSamples.sum()
    }

    fun cycleStart() {
        onCycleStart(cycle + 1, registry)
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
}
