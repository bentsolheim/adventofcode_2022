package no.solheim.adventofcode2022.tasks

class Day3(val input: String) {

    private val priorities = ('a'..'z').map { it } + ('A'..'Z').map { it }

    val sum = input.nonBlankLines()
        .map { it.substring(0, it.length / 2).toList() to it.substring(it.length / 2).toList() }
        .map { (c1, c2) -> c1.firstNotNullOf { c -> c2.firstOrNull { it == c } } }
        .sumOf { priorities.indexOf(it) + 1 }

    val sum2: Int
        get() {
            val groups = input.nonBlankLines().chunked(3).map { it.map { it.toList() } }
            return groups.sumOf { group ->
                val first = group.first()
                val rest = group.subList(1, group.size)
                val common = first.first { c -> rest.map { it.contains(c) }.all { it } }
                priorities.indexOf(common) + 1
            }
        }
}
