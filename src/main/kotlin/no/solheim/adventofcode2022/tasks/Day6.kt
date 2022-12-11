package no.solheim.adventofcode2022.tasks

import kotlin.streams.toList

class Day6(val input: String) {

    val startOfPacketMarker: Int get() = indexOfUniqueChars(4)


    val startOfMessageMarker: Int get() = indexOfUniqueChars(14)

    private fun indexOfUniqueChars(numberOfUniqueChars: Int): Int {
        var chars = mutableListOf<Int>()
        input.chars().toList().forEachIndexed { i, c ->
            if (chars.contains(c)) {
                chars = chars.subList(chars.indexOf(c) + 1, chars.size)
            }
            chars.add(c)
            if (chars.size == numberOfUniqueChars) {
                return i + 1
            }
        }
        return -1
    }
}
