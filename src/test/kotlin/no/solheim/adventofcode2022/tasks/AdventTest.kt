package no.solheim.adventofcode2022.tasks

abstract class AdventTest {

    val input = this::class.java.let {
        val baseName = it.simpleName.replace("Test", "")
            .replace("Day", "day_")
        it.getResource("/inputs/$baseName.txt")?.readText()?: ""
    }
}
