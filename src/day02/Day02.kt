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

    fun List<Int>.omit(index: Int): List<Int> {
        return subList(0, index) + subList(index + 1, size)
    }

    fun List<Int>.isValidList(): Boolean {
        return windowed(2).all {
            it[1] > it[0] && (1..3).contains(it[1] - it[0])
        } || windowed(2).all { it[0] > it[1] && (1..3).contains(it[0] - it[1]) }
    }

    fun part2(input: List<String>): Int {
        return input.map { it.split(" ").map { it.toInt() } }.count { ints ->
            ints.isValidList() || ints.indices.any { ints.omit(it).isValidList() }
        }
    }

    val input = readInput("day02/Day02")
    part1(input).println()
    part2(input).println()
}
