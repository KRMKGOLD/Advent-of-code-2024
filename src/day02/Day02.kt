package day02

import println
import readInput

fun main() {
    fun List<String>.toInts(): List<List<Int>> =
        map { it.split(" ").map { it.toInt() } }

    fun List<Int>.omit(index: Int): List<Int> {
        return subList(0, index) + subList(index + 1, size)
    }

    fun List<Int>.isValidList(): Boolean {
        return windowed(2).all {
            it[1] > it[0] && (1..3).contains(it[1] - it[0])
        } || windowed(2).all { it[0] > it[1] && (1..3).contains(it[0] - it[1]) }
    }

    fun part1(input: List<String>): Int {
        return input.toInts().count { ints -> ints.isValidList() }
    }

    fun part2(input: List<String>): Int {
        return input.toInts().count { ints ->
            ints.isValidList() || ints.indices.any { ints.omit(it).isValidList() }
        }
    }

    val input = readInput("day02/Day02")
    part1(input).println()
    part2(input).println()
}
