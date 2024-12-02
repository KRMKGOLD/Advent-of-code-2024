package day02

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return input.map { it.split(" ").map { it.toInt() } }
            .count { ints ->
                val diffs = ints.windowed(2).map { it[1] - it[0] }
                diffs.all { (1..3).contains(it) } || diffs.all { (-3..-1).contains(it) }
            }
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("day02/Day02")
    part1(input).println()
    part2(input).println()
}
