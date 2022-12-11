package no.solheim.adventofcode2022.tasks

class Day1(val input: String) {

    val sums = calculateCalorySums()
    val maxCalories = sums.max()

    val top3Sum = sums.sorted().reversed().subList(0, 3).sum()

    fun calculateCalorySums() = this.input.split("\n\n").map {
        it.split("\n")
            .filter(String::isNotBlank)
            .map(String::toInt)
            .sum()
    }
}
