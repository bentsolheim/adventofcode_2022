package no.solheim.adventofcode2022.tasks

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class Day1(@Value("classpath:/inputs/day_1.txt") val input: Resource) : DayTask {
    override fun run() {
        println(input.file.readText())
    }
}
