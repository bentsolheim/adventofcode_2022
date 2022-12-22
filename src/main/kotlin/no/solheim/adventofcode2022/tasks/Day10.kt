package no.solheim.adventofcode2022.tasks

class Day10(val input: String) {

    private var registry = 1
    private var cycle = 0

    private val signalStrengthSamples = mutableListOf<Int>()
    private val pixels = mutableListOf<String>()

    fun getSignalStrengthSampleSums() = signalStrengthSamples.sum()

    fun getScreen() = pixels.chunked(screenWidth).joinToString("\n") { it.joinToString("") }

    fun runInstructions() {
        input.nonBlankLines().map { it.split(" ") }.forEach {
            when (it[0]) {
                "noop" -> cycle()
                "addx" -> {
                    cycle(2)
                    registry += it[1].toInt()
                }
            }
        }
    }

    private fun cycle(count: Int = 1) {
        repeat(count) {
            cycle++
            if (cycle in listOf(20, 60, 100, 140, 180, 220)) {
                signalStrengthSamples.add(cycle * registry)
            }
            updateScreen(cycle, registry)
        }
    }

    private fun updateScreen(cycle: Int, registry: Int) {
        val colIndex = (cycle - 1) % screenWidth
        val pixel = if (colIndex in registry - 1..registry + 1) "#" else " "
        pixels.add(pixel)
    }

    companion object {
        const val screenWidth = 40
    }
}
