package no.solheim.adventofcode2022.tasks

var print = false
fun String.nonBlankLines(): List<String> = this.split("\n").filter { it.isNotBlank() }
