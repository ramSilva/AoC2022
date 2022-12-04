package puzzles

import java.io.File

private val lines = File("input/puzzle1/input.txt").readLines()
fun group() = lines.fold(mutableListOf(0)) { acc, s -> acc.also { if (s.isEmpty()) it.add(0, 0) else it[0] += s.toInt() } }
fun puzzle1() = group().maxOrNull()
fun puzzle1dot1() =group().sorted().takeLast(3).sum()
