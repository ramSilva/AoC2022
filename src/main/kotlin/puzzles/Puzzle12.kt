package puzzles

import java.io.File

private val lines = File("input/puzzle12/input.txt").readLines()

fun puzzle12(): Int {
    val grid = mutableListOf<MutableList<Char>>()
    var startingPosition = Pair(0, 0)
    val successPath: List<Pair<Int, Int>>

    // This is a list of Pairs of positions: path to said position. i.e.: [((2, 2), [(0, 0), (0, 1), (1, 1), (2, 1), (2, 2))]
    val visitQueue = mutableListOf<Pair<Pair<Int, Int>, List<Pair<Int, Int>>>>()

    val visitedPositions = mutableSetOf<Pair<Int, Int>>()

    lines.forEachIndexed { y, s ->
        grid.add(y, mutableListOf())
        s.forEachIndexed { x, c ->
            if (c == 'S') startingPosition = Pair(x, y)

            grid[y].add(x, c)
        }
    }

    visitQueue.add(Pair(startingPosition, listOf()))

    while (true) {
        val currentNode = visitQueue.first()
        visitQueue.removeFirst()

        if (grid[currentNode.first.second][currentNode.first.first] == 'E') {
            successPath = currentNode.second
            break
        }

        val currentHeight = when {
            grid[currentNode.first.second][currentNode.first.first] == 'E' -> 'z'
            grid[currentNode.first.second][currentNode.first.first] == 'S' -> 'a'
            else -> grid[currentNode.first.second][currentNode.first.first]
        }

        val adjacentNodes = listOf(
            Pair(currentNode.first.first - 1, currentNode.first.second),
            Pair(currentNode.first.first + 1, currentNode.first.second),
            Pair(currentNode.first.first, currentNode.first.second - 1),
            Pair(currentNode.first.first, currentNode.first.second + 1)
        )

        adjacentNodes.forEach { adjacent ->
            if (adjacent.first >= 0
                && adjacent.first < grid[0].size
                && adjacent.second >= 0
                && adjacent.second < grid.size
                && !visitedPositions.contains(adjacent)
            ) {
                val adjacentHeight = when {
                    grid[adjacent.second][adjacent.first] == 'E' -> 'z'
                    grid[adjacent.second][adjacent.first] == 'S' -> 'a'
                    else -> grid[adjacent.second][adjacent.first]
                }

                if (currentHeight - adjacentHeight >= -1) {
                    val newPath = currentNode.second.toMutableList()
                    newPath.add(adjacent)

                    visitQueue.add(Pair(adjacent, newPath))
                    visitedPositions.add(adjacent)
                }
            }
        }
    }

    return successPath.size
}


fun puzzle12dot1(): Int? {
    val grid = mutableListOf<MutableList<Char>>()
    val startingPositions = mutableListOf<Pair<Int, Int>>()
    val successPaths = mutableListOf<List<Pair<Int, Int>>>()

    // This is a list of Pairs of positions: path to said position. i.e.: [((2, 2), [(0, 0), (0, 1), (1, 1), (2, 1), (2, 2))]
    val visitQueue = mutableListOf<Pair<Pair<Int, Int>, List<Pair<Int, Int>>>>()

    val visitedPositions = mutableSetOf<Pair<Int, Int>>()

    lines.forEachIndexed { y, s ->
        grid.add(y, mutableListOf())
        s.forEachIndexed { x, c ->
            if (c == 'S' || c == 'a') startingPositions.add(Pair(x, y))

            grid[y].add(x, c)
        }
    }

    startingPositions.forEach {
        visitQueue.clear()
        visitedPositions.clear()

        visitQueue.add(Pair(it, listOf()))

        while (true) {
            if (visitQueue.isEmpty()) break

            val currentNode = visitQueue.first()
            visitQueue.removeFirst()

            if (grid[currentNode.first.second][currentNode.first.first] == 'E') {
                successPaths.add(currentNode.second)
                break
            }

            val currentHeight = when {
                grid[currentNode.first.second][currentNode.first.first] == 'E' -> 'z'
                grid[currentNode.first.second][currentNode.first.first] == 'S' -> 'a'
                else -> grid[currentNode.first.second][currentNode.first.first]
            }

            val adjacentNodes = listOf(
                Pair(currentNode.first.first - 1, currentNode.first.second),
                Pair(currentNode.first.first + 1, currentNode.first.second),
                Pair(currentNode.first.first, currentNode.first.second - 1),
                Pair(currentNode.first.first, currentNode.first.second + 1)
            )

            adjacentNodes.forEach { adjacent ->
                if (adjacent.first >= 0
                    && adjacent.first < grid[0].size
                    && adjacent.second >= 0
                    && adjacent.second < grid.size
                    && !visitedPositions.contains(adjacent)
                ) {
                    val adjacentHeight = when {
                        grid[adjacent.second][adjacent.first] == 'E' -> 'z'
                        grid[adjacent.second][adjacent.first] == 'S' -> 'a'
                        else -> grid[adjacent.second][adjacent.first]
                    }

                    if (currentHeight - adjacentHeight >= -1) {
                        val newPath = currentNode.second.toMutableList()
                        newPath.add(adjacent)

                        visitQueue.add(Pair(adjacent, newPath))
                        visitedPositions.add(adjacent)
                    }
                }
            }
        }
    }

    return successPaths.minByOrNull { it.size }?.size
}

