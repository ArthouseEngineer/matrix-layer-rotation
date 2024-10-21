package org.rbi


/*
 * Complete the 'matrixRotation' function below.
 *
 * The function accepts following parameters:
 *  1. 2D_INTEGER_ARRAY matrix
 *  2. INTEGER r
 */

fun matrixRotation(matrix: Array<Array<Int>>, r: Int) {

    println(matrix.joinToString("\n") { it.joinToString(" ") })
}

fun main() {
    val firstMultipleInput = readln()
        .trimEnd()
        .split(" ")

    val m = firstMultipleInput[0].toInt()

    val n = firstMultipleInput[1].toInt()

    val r = firstMultipleInput[2].toInt()

    val matrix = Array(m) { Array(n) { 0 } }

    for (i in 0 until m) {
        matrix[i] = readln()
            .trimEnd()
            .split(" ")
            .map { it.toInt() }
            .toTypedArray()
    }

    matrixRotation(matrix, r)
}
