/**
 * Matrix Addition
 * 
 * This program demonstrates how to add two matrices in Kotlin using both
 * imperative and functional approaches.
 * 
 * Time Complexity: O(m×n) where m and n are the dimensions of the matrices
 * Space Complexity: O(m×n) for storing the result matrix
 */

/**
 * Add two matrices using an imperative approach.
 * 
 * @param matrix1 The first input matrix
 * @param matrix2 The second input matrix
 * @return A new matrix containing the sum of the input matrices
 * @throws IllegalArgumentException if matrices have different dimensions
 */
fun addMatrices(matrix1: Array<IntArray>, matrix2: Array<IntArray>): Array<IntArray> {
    // Check if matrices have the same dimensions
    if (matrix1.isEmpty() || matrix2.isEmpty()) {
        throw IllegalArgumentException("Matrices cannot be empty")
    }
    
    if (matrix1.size != matrix2.size || matrix1[0].size != matrix2[0].size) {
        throw IllegalArgumentException("Matrices must have the same dimensions for addition")
    }
    
    val rows = matrix1.size
    val cols = matrix1[0].size
    
    // Initialize result matrix
    val result = Array(rows) { IntArray(cols) }
    
    // Add corresponding elements
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            result[i][j] = matrix1[i][j] + matrix2[i][j]
        }
    }
    
    return result
}

/**
 * Add two matrices using a functional approach.
 * 
 * @param matrix1 The first input matrix
 * @param matrix2 The second input matrix
 * @return A new matrix containing the sum of the input matrices
 * @throws IllegalArgumentException if matrices have different dimensions
 */
fun addMatricesFunctional(matrix1: Array<IntArray>, matrix2: Array<IntArray>): Array<IntArray> {
    // Check if matrices have the same dimensions
    if (matrix1.isEmpty() || matrix2.isEmpty()) {
        throw IllegalArgumentException("Matrices cannot be empty")
    }
    
    if (matrix1.size != matrix2.size || matrix1[0].size != matrix2[0].size) {
        throw IllegalArgumentException("Matrices must have the same dimensions for addition")
    }
    
    // Use functional approach to create the result matrix
    return Array(matrix1.size) { i ->
        IntArray(matrix1[0].size) { j ->
            matrix1[i][j] + matrix2[i][j]
        }
    }
}

/**
 * Print a matrix in a readable format.
 * 
 * @param matrix The matrix to print
 */
fun printMatrix(matrix: Array<IntArray>) {
    matrix.forEach { row ->
        row.forEach { value ->
            print("$value\t")
        }
        println()
    }
}

fun main() {
    // Example matrices
    val matrix1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    
    val matrix2 = arrayOf(
        intArrayOf(9, 8, 7),
        intArrayOf(6, 5, 4),
        intArrayOf(3, 2, 1)
    )
    
    println("Matrix 1:")
    printMatrix(matrix1)
    
    println("\nMatrix 2:")
    printMatrix(matrix2)
    
    try {
        // Add the matrices using imperative approach
        val result = addMatrices(matrix1, matrix2)
        
        println("\nResult of Matrix Addition (Imperative Approach):")
        printMatrix(result)
        
        // Add the matrices using functional approach
        val resultFunctional = addMatricesFunctional(matrix1, matrix2)
        
        println("\nResult of Matrix Addition (Functional Approach):")
        printMatrix(resultFunctional)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
    
    // Example with matrices of different dimensions
    println("\nExample with matrices of different dimensions:")
    val matrix3 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 4)
    )
    
    println("Matrix 3 (2x2):")
    printMatrix(matrix3)
    
    try {
        // Try to add matrices of different dimensions
        val result = addMatrices(matrix1, matrix3)
        printMatrix(result)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}