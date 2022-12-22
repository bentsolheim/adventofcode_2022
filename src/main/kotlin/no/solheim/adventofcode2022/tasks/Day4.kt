package no.solheim.adventofcode2022.tasks

class Day4(input: String) {

    val ranges = input.nonBlankLines().map {
        it.split(",")
            .map { it.split("-") }
            .map { (start, end) -> start.toInt() to end.toInt() }
            .map { (start, end) -> start..end }
    }

    val containedIn = ranges
        .map { (a1, a2) -> a1.containedIn(a2) || a2.containedIn(a1) }
        .count { it }

    val overlaps = ranges
        .map { (a1, a2) -> a1.overlapsWith(a2) }
        .count { it }

    fun IntRange.containedIn(r: IntRange) = first >= r.first && last <= r.last
    fun IntRange.overlapsWith(r: IntRange) = r.first in first..last || first in r.first..r.last
}
