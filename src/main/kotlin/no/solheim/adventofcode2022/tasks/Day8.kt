package no.solheim.adventofcode2022.tasks

class Day8(val input: String) {

    fun getVisibleTreeCount(): Int {
        val a = input.nonBlankLines().map { it.map { it.digitToIntOrNull() ?: 0 } }

        val bottom = a.size - 1
        val right = a.first().size - 1

        val visible = a.mapIndexed { row, treeRow ->
            treeRow.mapIndexed { col, treeHeight ->
                if (treeRow.subList(col + 1, right + 1).all { it < treeHeight }) return@mapIndexed true
                if (treeRow.subList(0, col).all { it < treeHeight }) return@mapIndexed true

                val treeCol = a.map { it[col] }
                if (treeCol.subList(0, row).all { it < treeHeight }) return@mapIndexed true
                if (treeCol.subList(row + 1, bottom + 1).all { it < treeHeight }) return@mapIndexed true

                return@mapIndexed false
            }
        }
        return visible.flatMap { it.map { it } }.count { it }
    }

    fun getHighestScenicScore(): Int {
        val a = input.nonBlankLines().map { it.map { it.digitToIntOrNull() ?: 0 } }

        val bottom = a.size - 1
        val right = a.first().size - 1

        // a.forEach { println(it) }

        val visible = a.mapIndexed { row, treeRow ->
            treeRow.mapIndexed { col, treeHeight ->
                val treeCol = a.map { it[col] }

                val e = treeRow.subList(col + 1, right + 1).indexOfFirstOrLast { it >= treeHeight } + 1
                val w = treeRow.subList(0, col).reversed().indexOfFirstOrLast { it >= treeHeight } + 1
                val n = treeCol.subList(0, row).reversed().indexOfFirstOrLast { it >= treeHeight } + 1
                val s = treeCol.subList(row + 1, bottom + 1).indexOfFirstOrLast { it >= treeHeight } + 1
                return@mapIndexed listOf(n, s, e, w)
            }
        }
        // visible.forEach { println(it.map { (n, s, e, w)->n*s*e*w }) }
        // visible.forEach { println(it) }
        return visible.flatMap { it.map { (n, s, e, w) -> n * s * e * w } }.max()
    }

    inline fun <T> List<T>.indexOfFirstOrLast(predicate: (T) -> Boolean) =
        indexOfFirst(predicate).takeIf { it != -1 } ?: (size - 1)
}
