/**
 * Transpose of a Matrix
 * 
 * This program demonstrates how to transpose a matrix in Kotlin.
 * Transposing a matrix means converting its rows into columns and vice versa.
 * 
 * Algorithm:
 * 1. For a square matrix (in-place transpose):
 *    a. Iterate through the upper triangular portion of the matrix
 *    b. Swap each element with its corresponding element across the main diagonal
 * 2. For a non-square matrix:
 *    a. Create a new matrix with dimensions swapped
 *    b. Copy each element to its transposed position
 * 3. Using Kotlin's functional approach with Array.map and indices
 * 
 * Time Complexity: O(n²) where n is the dimension of the matrix
 * Space Complexity: O(1) for in-place transpose (square matrix) or O(m×n) for non-square matrices
 */

/**
 * Transpose a square matrix in-place
 * 
 * @param matrix The input square matrix (mutable 2D array)
 */
fun transposeSquareMatrix(matrix: Array<IntArray>) {
    val n = matrix.size
    for (i in 0 until n) {
        for (j in i + 1 until n) {
            // Swap matrix[i][j] with matrix[j][i]
            val temp = matrix[i][j]
            matrix[i][j] = matrix[j][i]
            matrix[j][i] = temp
        }
    }
}

/**
 * Transpose any matrix (works for both square and non-square)
 * 
 * @param matrix The input matrix
 * @return A new matrix that is the transpose of the input matrix
 */
fun transposeMatrix(matrix: Array<IntArray>): Array<IntArray> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return emptyArray()
    }
    
    val rows = matrix.size
    val cols = matrix[0].size
    
    // Create a new matrix with swapped dimensions
    return Array(cols) { j ->
        IntArray(rows) { i ->
            matrix[i][j]
        }
    }
}

/**
 * Transpose a matrix using Kotlin's functional approach
 * 
 * @param matrix The input matrix
 * @return A new matrix that is the transpose of the input matrix
 */
fun transposeMatrixFunctional(matrix: Array<IntArray>): Array<IntArray> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return emptyArray()
    }
    
    val cols = matrix[0].size
    
    // Use List.map to create columns from rows
    return Array(cols) { j ->
        matrix.map { row -> row[j] }.toIntArray()
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
    // Example 1: Square matrix
    val squareMatrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    
    println("Example 1: Square Matrix (3x3)")
    println("Original Matrix:")
    printMatrix(squareMatrix)
    
    // Create a copy for the in-place transpose
    val squareMatrixCopy = Array(squareMatrix.size) { i ->
        squareMatrix[i].copyOf()
    }
    
    // Transpose in-place
    transposeSquareMatrix(squareMatrixCopy)
    
    println("\nTransposed Matrix (In-place):")
    printMatrix(squareMatrixCopy)
    
    // Example 2: Non-square matrix
    val nonSquareMatrix = arrayOf(
        intArrayOf(1, 2, 3, 4),
        intArrayOf(5, 6, 7, 8)
    )
    
    println("\nExample 2: Non-Square Matrix (2x4)")
    println("Original Matrix:")
    printMatrix(nonSquareMatrix)
    
    // Transpose using a new matrix
    val transposed = transposeMatrix(nonSquareMatrix)
    
    println("\nTransposed Matrix (4x2):")
    printMatrix(transposed)
    
    // Example 3: Using functional approach
    println("\nTransposed Matrix (Functional Approach):")
    val transposedFunctional = transposeMatrixFunctional(nonSquareMatrix)
    printMatrix(transposedFunctional)
}