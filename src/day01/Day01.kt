package day01

import println
import readInput
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val firstList = mutableListOf<Int>()
        val lastList = mutableListOf<Int>()

        input.forEach {
            it.split(" ").let {
                firstList.add(it.first().toInt())
                lastList.add(it.last().toInt())
            }
        }

        var sum = 0

        repeat(firstList.size) {
            sum += abs(lastList[it] - firstList[it])
        }

        return sum
    }

    fun part2(input: List<String>): Int {
        val firstList = mutableListOf<Int>()
        val lastList = mutableListOf<Int>()

        input.forEach {
            it.split(" ").let {
                firstList.add(it.first().toInt())
                lastList.add(it.last().toInt())
            }
        }

        val lastMap = lastList.groupingBy { it }.eachCount()
        var sum = 0
        firstList.forEach {
            sum += it * (lastMap[it] ?: 0)
        }

        return sum
    }

    val input = readInput("day01/Day01")
    part1(input).println()
    part2(input).println()
}
