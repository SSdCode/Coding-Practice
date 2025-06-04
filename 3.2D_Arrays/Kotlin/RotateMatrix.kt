/**
 * Rotate a Matrix by 90 Degrees
 * 
 * This program demonstrates how to rotate a square matrix by 90 degrees clockwise in Kotlin.
 * 
 * Algorithm:
 * 1. Transpose the matrix (swap rows with columns)
 * 2. Reverse each row of the transposed matrix
 * 3. Alternative functional approach using map and reversed()
 * 
 * Time Complexity: O(n²) where n is the dimension of the matrix
 * Space Complexity: O(1) for in-place rotation or O(n²) for functional approach
 */

/**
 * Rotate a square matrix 90 degrees clockwise in-place
 * 
 * @param matrix The input square matrix (mutable 2D array)
 */
fun rotateMatrix90Clockwise(matrix: Array<IntArray>) {
    val n = matrix.size
    if (n == 0 || n != matrix[0].size) {
        println("Error: Not a square matrix")
        return
    }
    
    // Step 1: Transpose the matrix
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            // Swap matrix[i][j] with matrix[j][i]
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }
    
    // Step 2: Reverse each row
    for (i in 0 until n) {
        matrix[i].reverse()
    }
}

/**
 * Rotate a square matrix 90 degrees counter-clockwise in-place
 * 
 * @param matrix The input square matrix (mutable 2D array)
 */
fun rotateMatrix90CounterClockwise(matrix: Array<IntArray>) {
    val n = matrix.size
    if (n == 0 || n != matrix[0].size) {
        println("Error: Not a square matrix")
        return
    }
    
    // Step 1: Transpose the matrix
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            // Swap matrix[i][j] with matrix[j][i]
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }
    
    // Step 2: Reverse each column
    for (j in 0 until n) {
        for (i in 0 until n / 2) {
            // Swap matrix[i][j] with matrix[n-1-i][j]
            val temp = matrix[i][j]
            matrix[i][j] = matrix[n - 1 - i][j]
            matrix[n - 1 - i][j] = temp
        }
    }
}

/**
 * Create a new matrix that is the input matrix rotated 90 degrees clockwise
 * Works for non-square matrices as well
 * 
 * @param matrix The input matrix
 * @return A new matrix rotated 90 degrees clockwise
 */
fun rotateMatrix90ClockwiseNew(matrix: Array<IntArray>): Array<IntArray> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return emptyArray()
    }
    
    val rows = matrix.size
    val cols = matrix[0].size
    
    // Create a new matrix with swapped dimensions
    return Array(cols) { j ->
        IntArray(rows) { i ->
            // For 90 degrees clockwise: result[j][rows-1-i] = matrix[i][j]
            matrix[rows - 1 - i][j]
        }
    }
}

/**
 * Rotate a matrix 90 degrees clockwise using a functional approach
 * 
 * @param matrix The input matrix
 * @return A new matrix rotated 90 degrees clockwise
 */
fun rotateMatrix90ClockwiseFunctional(matrix: Array<IntArray>): Array<IntArray> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return emptyArray()
    }
    
    val rows = matrix.size
    val cols = matrix[0].size
    
    // Create columns from rows in reverse order
    return Array(cols) { j ->
        IntArray(rows) { i -> matrix[rows - 1 - i][j] }
    }
}

/**
 * Print a matrix in a readable format
 * 
 * @param matrix The matrix to print
 */
fun printMatrix(matrix: Array<IntArray>) {
    for (row in matrix) {
        println(row.joinToString("\t"))
    }
}

fun main() {
    // Example: Square matrix
    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    
    println("Original Matrix:")
    printMatrix(matrix)
    
    // Create a copy for clockwise rotation
    val matrixClockwise = Array(matrix.size) { i ->
        matrix[i].copyOf()
    }
    
    // Rotate clockwise in-place
    rotateMatrix90Clockwise(matrixClockwise)
    
    println("\nRotated 90 degrees clockwise (in-place):")
    printMatrix(matrixClockwise)
    
    // Create a copy for counter-clockwise rotation
    val matrixCounterClockwise = Array(matrix.size) { i ->
        matrix[i].copyOf()
    }
    
    // Rotate counter-clockwise in-place
    rotateMatrix90CounterClockwise(matrixCounterClockwise)
    
    println("\nRotated 90 degrees counter-clockwise (in-place):")
    printMatrix(matrixCounterClockwise)
    
    // Example: Non-square matrix
    val nonSquareMatrix = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8)
    )
    
    println("\nNon-Square Matrix:")
    printMatrix(nonSquareMatrix)
    
    // Rotate using a new matrix (works for non-square matrices)
    val rotatedNonSquare = rotateMatrix90ClockwiseNew(nonSquareMatrix)
    
    println("\nRotated 90 degrees clockwise (new matrix):")
    printMatrix(rotatedNonSquare)
    
    // Rotate using functional approach
    val rotatedFunctional = rotateMatrix90ClockwiseFunctional(nonSquareMatrix)
    
    println("\nRotated 90 degrees clockwise (functional approach):")
    printMatrix(rotatedFunctional)
}