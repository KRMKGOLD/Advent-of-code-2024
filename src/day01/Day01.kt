package day01

import println
import readInput
import kotlin.math.abs

fun main() {
    fun part1(input: List<String>): Int {
        val firstList = input.map { it.substringBefore(' ').toInt() }.sorted()
        val lastList = input.map { it.substringAfterLast(' ').toInt() }.sorted()

        return firstList.zip(lastList).sumOf { abs(it.first - it.second) }
    }

    fun part2(input: List<String>): Int {
        val firstList = input.map { it.substringBefore(' ').toInt() }
        val lastList = input.map { it.substringAfterLast(' ').toInt() }

        return firstList.sumOf { num -> lastList.count { it == num } * num }
    }

    val input = readInput("day01/Day01")
    part1(input).println()
    part2(input).println()
}
