package day05

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val splitIndex = input.indexOf("")
        val pages = input.subList(0, splitIndex)
        val books = input.subList(splitIndex + 1, input.size)
            .map { it.split(",") }

        val graph: MutableMap<String, List<String>> = mutableMapOf()

        pages.forEach { page ->
            val (ahead, behind) = page.split("|")
            graph[ahead] = graph[ahead]?.plus(listOf(behind)) ?: listOf(behind)
        }

        var sum = 0
        books.forEach { book ->
            val isOrder = book.indices.all { idx ->
                book.subList(idx + 1, book.size).all { graph[book[idx]]?.contains(it) == true }
            }

            if (isOrder) {
                sum += book[book.size / 2].toInt()
            }
        }

        return sum
    }

    fun part2(input: List<String>): Int {

        return input.size
    }

    val input = readInput("day05/Day05")

    part1(input).println()
    part2(input).println()
}
