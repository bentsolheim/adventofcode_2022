package no.solheim.adventofcode2022.tasks

class Day7(val input: String) {

    val dirsPart1: Int get() = getDirSizes().values.filter { it <= 100_000 }.sum()

    val dirsPart2: Int
        get() {
            val dirs = getDirSizes()
            val total = 70_000_000
            val needed = 30_000_000
            val used = dirs[listOf("/")] ?: 0
            val free = total - used
            val missing = needed - free
            return dirs.entries.sortedBy { e -> e.value }
                .find { e -> e.value >= missing }
                ?.value ?: 0
        }

    fun getDirSizes(): Map<List<String>, Int> {
        val currentDir = mutableListOf("/")
        return input.nonBlankLines().map { it.split(" ") }
            .fold(mutableMapOf<List<String>, Int>()) { dirSizes, line ->
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
                dirSizes
            }.toMap()
    }
}
