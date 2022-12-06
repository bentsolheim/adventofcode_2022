package no.solheim.adventofcode2022.tasks

import org.springframework.beans.factory.annotation.Value
import org.springframework.core.io.Resource
import org.springframework.stereotype.Component

@Component
class Day1(@Value("classpath:/inputs/day_1.txt") val input: Resource) : DayTask {
    override fun run() {
        val sums = calculateCalorySums()
        val maxCalories = sums.max()
        println(maxCalories)

        val top3Sum = sums.sorted().reversed().subList(0, 3).sum()
        println(top3Sum)
    }

    fun calculateCalorySums() = this.input.file.readText()
        .split("\n\n").map {
            it.split("\n")
                .filter(String::isNotBlank)
                .map(String::toInt)
                .sum()
        }
}
