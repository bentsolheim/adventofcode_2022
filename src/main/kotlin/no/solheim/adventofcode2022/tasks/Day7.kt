package no.solheim.adventofcode2022.tasks

import nonBlankLines

class Day7(val input: String) {

    val dirsPart1: Int get() = dirSizes.values.filter { it <= 100_000 }.sum()

    val dirsPart2: Int get() {
        val dirs = dirSizes
        val total = 70_000_000
        val needed = 30_000_000
        val used = dirs[listOf("/")] ?: 0
        val free = total - used
        val missing = needed - free
        return dirs.entries.sortedBy { e -> e.value }
            .find { e -> e.value >= missing }
            ?.value ?: 0
    }

    val dirSizes: Map<List<String>, Int> get() {
        val dirSizes = mutableMapOf<List<String>, Int>()
        val currentDir = mutableListOf("/")

        input.nonBlankLines().map { it.split(" ") }.forEach { line ->
            if (line[0] == "$") {
                val cmd = line[1]
                val args = line.subList(2, line.size)

                if (cmd == "cd") {
                    when (val path = args.first()) {
                        "/" -> currentDir.also {
                            it.clear()
                            it.add(path)
                        }
                        ".." -> currentDir.removeLast()
                        else -> currentDir.add(path)
                    }
                }
            } else if (line[0] == "dir") {
            } else {
                val size = line[0].toInt()
                val d = currentDir.toMutableList()
                while (d.isNotEmpty()) {
                    dirSizes.merge(d.toList(), size) { old, new -> old + new }
                    d.removeLast()
                }
            }
        }
        return dirSizes.toMap()
    }
}
