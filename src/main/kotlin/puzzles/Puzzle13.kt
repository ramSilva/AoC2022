package puzzles

import com.google.gson.Gson
import java.io.File

private val lines = File("input/puzzle13/input.txt").readLines()

fun puzzle13(): Int {
    val ordered = mutableListOf<Int>()
    var index = 0
    lines.filter { it.isNotEmpty() }.map {
        Gson().fromJson(it, List::class.java)
    }.chunked(2).forEach {
        index++
        if (isSmaller(it.first(), it.last()) == Result.ORDERED) {
            ordered.add(index)
        }
    }

    return ordered.sum()
}

fun puzzle13dot1(): Int {
    val ordered = mutableListOf<Any>()
    val og = lines.filter { it.isNotEmpty() }.map {
        Gson().fromJson(it, List::class.java)
    }.toMutableList()

    og.add(arrayListOf(arrayListOf(2.0)))
    og.add(arrayListOf(arrayListOf(6.0)))

    while (true) {
        if(og.size == 1) break
        var currentMin = og[0].toList()
        og.forEach {
            if (isSmaller(it, currentMin) == Result.ORDERED) {
                currentMin = it
            }
        }
        og.remove(currentMin)
        ordered.add(currentMin)
    }

    return (ordered.indexOf(arrayListOf(arrayListOf(2.0))) + 1) * (ordered.indexOf(arrayListOf(arrayListOf(6.0))) + 1)
}

enum class Result {
    ORDERED,
    NON_ORDERED,
    INCONCLUSIVE
}

fun isSmaller(list1: List<*>, list2: List<*>): Result {
    var i = 0
    while (true) {
        if (i >= list1.size && i >= list2.size) return Result.INCONCLUSIVE

        if (i >= list1.size) return Result.ORDERED
        if (i >= list2.size) return Result.NON_ORDERED

        val element1 = list1[i]
        val element2 = list2[i]

        if (element1 is Double && element2 is Double) {
            if (element1 < element2) return Result.ORDERED
            if (element2 < element1) return Result.NON_ORDERED
        }
        if (element1 is List<*> && element2 is List<*>) {
            val result = isSmaller(element1, element2)
            if (result != Result.INCONCLUSIVE) return result
        }
        if (element1 is List<*> && element2 is Double) {
            val result = isSmaller(element1, listOf(element2))
            if (result != Result.INCONCLUSIVE) return result
        }
        if (element1 is Double && element2 is List<*>) {
            val result = isSmaller(listOf(element1), element2)
            if (result != Result.INCONCLUSIVE) return result
        }

        i++
    }
}

