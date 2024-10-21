package org.rbi

import kotlin.math.min


data class Coordinate(val row: Int, val col: Int)

/*
 * Complete the 'matrixRotation' function below.
 *
 * The function accepts following parameters:
 *  1. 2D_INTEGER_ARRAY matrix
 *  2. INTEGER r
 */

fun matrixRotation(matrix: Array<Array<Int>>, r: Int) {

    val layersCount = min(matrix.size, matrix[0].size) / 2

    for (layer in 0 until layersCount) {
        /*
         The number of elements in the current layer (perimeter of the rectangle).
        * Each layer consists of two horizontal sides (top and bottom rows)
        * and two vertical sides (left and right columns), so we multiply by 2.
        * We subtract 2 to avoid double-counting the two corner elements when
        * adding the rows and columns together.
        */
        val numberOfElements = 2 * ((matrix.size - 2 * layer) + (matrix[0].size - 2 * layer) - 2)

        val rotationsCount = r % numberOfElements
        rotateLayer(matrix, layer, rotationsCount)
    }

    matrix.forEach { row -> println(row.joinToString(" ")) }
}

fun rotateLayer(matrix: Array<Array<Int>>, layer: Int, rotationsCount: Int) {

    if (rotationsCount == 0) return

    // Corner for current layer to be rotated
    val topLeft = Coordinate(layer, layer)
    val topRight = Coordinate(layer, matrix[0].size - 1 - layer)
    val bottomLeft = Coordinate(matrix.size - 1 - layer, layer)
    val bottomRight = Coordinate(matrix.size - 1 - layer, matrix[0].size - 1 - layer)

    repeat(rotationsCount) {
        // Save the top-left element temporarily before shifting
        val temp = matrix[topLeft.row][topLeft.col]

        // Shift the top row left -> right
        for (i in topLeft.col until topRight.col) {
            matrix[topLeft.row][i] = matrix[topLeft.row][i + 1]
        }

        // Shift the right column top -> bottom
        for (i in topRight.row until bottomRight.row) {
            matrix[i][topRight.col] = matrix[i + 1][topRight.col]
        }

        // Shift the bottom row right -> left
        for (i in topRight.col downTo bottomLeft.col + 1) {
            matrix[bottomRight.row][i] = matrix[bottomRight.row][i - 1]
        }

        // Shift the left column bottom -> top
        for (i in bottomLeft.row downTo topLeft.row + 1) {
            matrix[i][bottomLeft.col] = matrix[i - 1][bottomLeft.col]
        }

        // Restore the saved top-left element to its new position
        matrix[topLeft.row + 1][topLeft.col] = temp
    }
}


fun main() {
    val firstMultipleInput = readln()
        .trimEnd()
        .split(" ")

    val m = firstMultipleInput[0].toInt()
    val n = firstMultipleInput[1].toInt()
    val r = firstMultipleInput[2].toInt()

    val matrix: Array<Array<Int>> = Array(m) { Array(n) { 0 } }

    for (i in 0 until m) {
        matrix[i] = readln()
            .trimEnd()
            .split(" ")
            .map { it.toInt() }
            .toTypedArray()
    }

    matrixRotation(matrix, r)
}
