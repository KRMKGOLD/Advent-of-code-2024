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
        val patternRegex = Regex("mul\\(\\d+,\\d+\\)")
        val enableRegex = Regex("do\\(\\)")
        val disableRegex = Regex("don't\\(\\)")
        val numberRegex = Regex("\\d+")

        var sum = 0
        var enable = true

        input.forEach {
            var str = it

            while (true) {
                val patternStr = patternRegex.find(str)
                val enableStr = enableRegex.find(str)
                val disableStr = disableRegex.find(str)

                if (patternStr == null) break

                when (
                    listOf(
                        patternStr?.range?.first ?: Int.MAX_VALUE,
                        enableStr?.range?.first ?: Int.MAX_VALUE,
                        disableStr?.range?.first ?: Int.MAX_VALUE
                    ).min()
                ) {
                    patternStr?.range?.first -> {
                        if (enable) {
                            sum += numberRegex.findAll(patternStr.value).map { it.value.toInt() }
                                .reduce { acc, i -> acc * i }
                        }
                        str = str.substring(patternStr.range.last, str.length)
                    }

                    enableStr?.range?.first -> {
                        enable = true
                        str = str.substring(enableStr.range.last, str.length)
                    }

                    disableStr?.range?.first -> {
                        enable = false
                        str = str.substring(disableStr.range.last, str.length)
                    }
                }
            }
        }

        return sum
    }

    val input = readInput("day03/Day03")
    part1(input).println()
    part2(input).println()
}
