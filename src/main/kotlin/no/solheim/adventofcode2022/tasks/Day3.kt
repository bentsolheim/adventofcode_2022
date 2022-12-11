package no.solheim.adventofcode2022.tasks

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component
import nonBlankLines

@Component
class Day3(@Value("classpath:/inputs/day_3.txt") val input: Resource) : DayTask {

    val priorities = ('a'..'z').map { it } + ('A'..'Z').map { it }
    override fun run() {

        val sum = input.nonBlankLines()
            .map { it.substring(0, it.length / 2).toList() to it.substring(it.length / 2).toList() }
            .map { (c1, c2) -> c1.firstNotNullOf { c -> c2.firstOrNull { it == c } } }
            .sumOf { priorities.indexOf(it) + 1 }
        println(sum)

        val groups = input.nonBlankLines().chunked(3).map { it.map { it.toList() } }
        val sum2 = groups.sumOf { group ->
            val first = group.first()
            val rest = group.subList(1, group.size)
            val common = first.first { c -> rest.map { it.contains(c) }.all { it } }
            priorities.indexOf(common) + 1
        }
        println(sum2)
    }
}
