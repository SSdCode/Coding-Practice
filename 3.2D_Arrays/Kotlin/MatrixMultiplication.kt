/**
 * Matrix Multiplication
 * 
 * This program demonstrates how to multiply two matrices in Kotlin using both
 * imperative and functional approaches.
 * 
 * Time Complexity: O(n³) where n is the dimension of the matrices
 * Space Complexity: O(n²) for storing the result matrix
 */

/**
 * Multiply two matrices using an imperative approach.
 * 
 * @param matrix1 The first input matrix
 * @param matrix2 The second input matrix
 * @return A new matrix containing the product of the input matrices
 * @throws IllegalArgumentException if matrices have invalid dimensions for multiplication
 */
fun multiplyMatrices(matrix1: Array<IntArray>, matrix2: Array<IntArray>): Array<IntArray> {
    // Check if matrices are empty
    if (matrix1.isEmpty() || matrix2.isEmpty()) {
        throw IllegalArgumentException("Matrices cannot be empty")
    }
    
    // Check if multiplication is possible
    if (matrix1[0].size != matrix2.size) {
        throw IllegalArgumentException(
            "Matrix multiplication not possible. Number of columns in first matrix (${matrix1[0].size}) " +
            "must equal number of rows in second matrix (${matrix2.size})."
        )
    }
    
    val rows1 = matrix1.size
    val cols1 = matrix1[0].size
    val cols2 = matrix2[0].size
    
    // Initialize result matrix
    val result = Array(rows1) { IntArray(cols2) }
    
    // Multiply matrices
    for (i in 0 until rows1) {
        for (j in 0 until cols2) {
            for (k in 0 until cols1) {
                result[i][j] += matrix1[i][k] * matrix2[k][j]
            }
        }
    }
    
    return result
}

/**
 * Multiply two matrices using a functional approach.
 * 
 * @param matrix1 The first input matrix
 * @param matrix2 The second input matrix
 * @return A new matrix containing the product of the input matrices
 * @throws IllegalArgumentException if matrices have invalid dimensions for multiplication
 */
fun multiplyMatricesFunctional(matrix1: Array<IntArray>, matrix2: Array<IntArray>): Array<IntArray> {
    // Check if matrices are empty
    if (matrix1.isEmpty() || matrix2.isEmpty()) {
        throw IllegalArgumentException("Matrices cannot be empty")
    }
    
    // Check if multiplication is possible
    if (matrix1[0].size != matrix2.size) {
        throw IllegalArgumentException(
            "Matrix multiplication not possible. Number of columns in first matrix (${matrix1[0].size}) " +
            "must equal number of rows in second matrix (${matrix2.size})."
        )
    }
    
    val rows1 = matrix1.size
    val cols1 = matrix1[0].size
    val cols2 = matrix2[0].size
    
    // Use functional approach to create the result matrix
    return Array(rows1) { i ->
        IntArray(cols2) { j ->
            (0 until cols1).sumOf { k -> matrix1[i][k] * matrix2[k][j] }
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
            print("%4d".format(value))
        }
        println()
    }
}

/**
 * Get the dimensions of a matrix.
 * 
 * @param matrix The matrix
 * @return A Pair containing the number of rows and columns
 */
fun getMatrixDimensions(matrix: Array<IntArray>): Pair<Int, Int> {
    if (matrix.isEmpty()) {
        return Pair(0, 0)
    }
    return Pair(matrix.size, matrix[0].size)
}

fun main() {
    // Example matrices
    val matrix1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6)
    )
    
    val matrix2 = arrayOf(
        intArrayOf(7, 8),
        intArrayOf(9, 10),
        intArrayOf(11, 12)
    )
    
    val (rows1, cols1) = getMatrixDimensions(matrix1)
    val (rows2, cols2) = getMatrixDimensions(matrix2)
    
    println("Matrix 1 (${rows1}x${cols1}):")
    printMatrix(matrix1)
    
    println("\nMatrix 2 (${rows2}x${cols2}):")
    printMatrix(matrix2)
    
    try {
        // Multiply the matrices using imperative approach
        val result = multiplyMatrices(matrix1, matrix2)
        
        val (resultRows, resultCols) = getMatrixDimensions(result)
        println("\nResult of Matrix Multiplication - Imperative (${resultRows}x${resultCols}):")
        printMatrix(result)
        
        // Multiply the matrices using functional approach
        val resultFunctional = multiplyMatricesFunctional(matrix1, matrix2)
        
        println("\nResult of Matrix Multiplication - Functional (${resultRows}x${resultCols}):")
        printMatrix(resultFunctional)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
    
    // Example 2: Square matrices
    val matrix3 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 4)
    )
    
    val matrix4 = arrayOf(
        intArrayOf(5, 6),
        intArrayOf(7, 8)
    )
    
    val (rows3, cols3) = getMatrixDimensions(matrix3)
    val (rows4, cols4) = getMatrixDimensions(matrix4)
    
    println("\nExample 2: Square Matrices")
    println("Matrix 3 (${rows3}x${cols3}):")
    printMatrix(matrix3)
    
    println("\nMatrix 4 (${rows4}x${cols4}):")
    printMatrix(matrix4)
    
    try {
        // Multiply the square matrices
        val result2 = multiplyMatrices(matrix3, matrix4)
        
        val (resultRows2, resultCols2) = getMatrixDimensions(result2)
        println("\nResult of Square Matrix Multiplication (${resultRows2}x${resultCols2}):")
        printMatrix(result2)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
    
    // Example 3: Invalid multiplication
    val matrix5 = arrayOf(
        intArrayOf(1, 2),
        intArrayOf(3, 4)
    )
    
    val matrix6 = arrayOf(
        intArrayOf(5, 6, 7),
        intArrayOf(8, 9, 10),
        intArrayOf(11, 12, 13)
    )
    
    val (rows5, cols5) = getMatrixDimensions(matrix5)
    val (rows6, cols6) = getMatrixDimensions(matrix6)
    
    println("\nExample 3: Invalid Multiplication")
    println("Matrix 5 (${rows5}x${cols5}):")
    printMatrix(matrix5)
    
    println("\nMatrix 6 (${rows6}x${cols6}):")
    printMatrix(matrix6)
    
    try {
        // Try to multiply incompatible matrices
        val result3 = multiplyMatrices(matrix5, matrix6)
        printMatrix(result3)
    } catch (e: IllegalArgumentException) {
        println("\nError: ${e.message}")
    }
}