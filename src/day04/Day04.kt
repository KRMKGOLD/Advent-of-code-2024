package day04

import println
import readInput

fun main() {
    fun countLinearXmas(str: String) = str.windowed(4).count { it == "XMAS" }

    fun part1(input: List<String>): Int {
        var sum = 0

        val xSize = input[0].length
        val ySize = input.size

        // 가로
        for (str in input) {
            sum += countLinearXmas(str)
            sum += countLinearXmas(str.reversed())
        }

        // 세로
        for (x in 0..<xSize) {
            var str = ""
            for (y in 0..<ySize) {
                str += input[y][x]
            }
            sum += countLinearXmas(str)
            sum += countLinearXmas(str.reversed())
        }

        // 대각선
        for (x in 0..<xSize) {
            var r = x
            var c = 0
            var str = ""
            while (r < xSize && c < ySize) {
                str += input[r][c]
                r++
                c++
            }
            sum += countLinearXmas(str)
            sum += countLinearXmas(str.reversed())
        }

        for (y in 1 until ySize) {
            var r = 0
            var c = y
            var str = ""
            while (r < xSize && c < ySize) {
                str += input[r][c]
                r++
                c++
            }
            sum += countLinearXmas(str)
            sum += countLinearXmas(str.reversed())
        }

        for (x in xSize - 1 downTo 0) {
            var r = x
            var c = 0
            var str = ""
            while (r >= 0 && c < ySize) {
                str += input[r][c]
                r--
                c++
            }
            sum += countLinearXmas(str)
            sum += countLinearXmas(str.reversed())
        }

        for (y in 1 until ySize) {
            var r = xSize - 1
            var c = y
            var str = ""
            while (r < xSize && c < ySize) {
                str += input[r][c]
                r--
                c++
            }
            sum += countLinearXmas(str)
            sum += countLinearXmas(str.reversed())
        }

        return sum
    }

    fun part2(input: List<String>): Int {
        return input.size
    }

    val input = readInput("day04/Day04")

    part1(input).println()
    part2(input).println()
}