package day03

import println
import readInput

fun main() {
    fun part1(input: List<String>): Int {
        val patternRegex = Regex("mul\\(\\d+,\\d+\\)")
        val numberRegex = Regex("\\d+")

        return input.sumOf {
            val str = patternRegex.findAll(it)

            str.sumOf {
                numberRegex.findAll(it.value)
                    .map(MatchResult::value)
                    .map(String::toInt)
                    .reduce { acc, i -> acc * i }
            }
        }
    }

    fun part2(input: List<String>): Int {

        return input.size
    }

    val input = readInput("day03/Day03")
    part1(input).println()
    part2(input).println()
}
