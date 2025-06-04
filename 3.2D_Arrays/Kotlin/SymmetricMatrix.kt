/**
 * Symmetric Matrix Check
 * 
 * This program demonstrates how to check if a matrix is symmetric in Kotlin.
 * A symmetric matrix is a square matrix that is equal to its transpose.
 * 
 * Time Complexity: O(n²) where n is the dimension of the matrix
 * Space Complexity: O(1) as we only need a few variables
 */

/**
 * Check if a matrix is symmetric using an imperative approach.
 * 
 * @param matrix The input matrix
 * @return true if the matrix is symmetric, false otherwise
 * @throws IllegalArgumentException if the matrix is not square
 */
fun isSymmetric(matrix: Array<IntArray>?): Boolean {
    // Check if the matrix is null
    if (matrix == null) {
        throw IllegalArgumentException("Matrix cannot be null")
    }
    
    // Check if the matrix is empty
    if (matrix.isEmpty()) {
        return true // Empty matrix is considered symmetric
    }
    
    // Check if the matrix is square
    val size = matrix.size
    for (row in matrix) {
        if (row.size != size) {
            throw IllegalArgumentException("Matrix must be square")
        }
    }
    
    // Check if the matrix is symmetric
    for (i in 0 until size) {
        for (j in 0 until size) {
            if (matrix[i][j] != matrix[j][i]) {
                return false
            }
        }
    }
    
    return true
}

/**
 * Check if a matrix is symmetric using an optimized approach.
 * 
 * @param matrix The input matrix
 * @return true if the matrix is symmetric, false otherwise
 * @throws IllegalArgumentException if the matrix is not square
 */
fun isSymmetricOptimized(matrix: Array<IntArray>?): Boolean {
    // Check if the matrix is null
    if (matrix == null) {
        throw IllegalArgumentException("Matrix cannot be null")
    }
    
    // Check if the matrix is empty
    if (matrix.isEmpty()) {
        return true // Empty matrix is considered symmetric
    }
    
    // Check if the matrix is square
    val size = matrix.size
    for (row in matrix) {
        if (row.size != size) {
            throw IllegalArgumentException("Matrix must be square")
        }
    }
    
    // Check if the matrix is symmetric (only upper triangular part)
    for (i in 0 until size) {
        for (j in i + 1 until size) {
            if (matrix[i][j] != matrix[j][i]) {
                return false
            }
        }
    }
    
    return true
}

/**
 * Check if a matrix is symmetric using a functional approach.
 * 
 * @param matrix The input matrix
 * @return true if the matrix is symmetric, false otherwise
 * @throws IllegalArgumentException if the matrix is not square
 */
fun isSymmetricFunctional(matrix: Array<IntArray>?): Boolean {
    // Check if the matrix is null
    matrix ?: throw IllegalArgumentException("Matrix cannot be null")
    
    // Check if the matrix is empty
    if (matrix.isEmpty()) {
        return true // Empty matrix is considered symmetric
    }
    
    // Check if the matrix is square
    val size = matrix.size
    if (matrix.any { it.size != size }) {
        throw IllegalArgumentException("Matrix must be square")
    }
    
    // Check if the matrix is symmetric using functional approach
    return (0 until size).all { i ->
        (0 until size).all { j ->
            matrix[i][j] == matrix[j][i]
        }
    }
}

/**
 * Check if a matrix is symmetric using an optimized functional approach.
 * 
 * @param matrix The input matrix
 * @return true if the matrix is symmetric, false otherwise
 * @throws IllegalArgumentException if the matrix is not square
 */
fun isSymmetricOptimizedFunctional(matrix: Array<IntArray>?): Boolean {
    // Check if the matrix is null
    matrix ?: throw IllegalArgumentException("Matrix cannot be null")
    
    // Check if the matrix is empty
    if (matrix.isEmpty()) {
        return true // Empty matrix is considered symmetric
    }
    
    // Check if the matrix is square
    val size = matrix.size
    if (matrix.any { it.size != size }) {
        throw IllegalArgumentException("Matrix must be square")
    }
    
    // Check if the matrix is symmetric using functional approach (only upper triangular part)
    return (0 until size).all { i ->
        (i + 1 until size).all { j ->
            matrix[i][j] == matrix[j][i]
        }
    }
}

/**
 * Print a matrix in a readable format.
 * 
 * @param matrix The matrix to print
 */
fun printMatrix(matrix: Array<IntArray>) {
    for (row in matrix) {
        for (value in row) {
            print("$value\t")
        }
        println()
    }
}

fun main() {
    // Example 1: Symmetric matrix
    val symmetric = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(2, 4, 5),
        intArrayOf(3, 5, 6)
    )
    
    println("Example 1: Symmetric Matrix")
    printMatrix(symmetric)
    
    try {
        val result = isSymmetric(symmetric)
        println("\nThe matrix is ${if (result) "symmetric" else "not symmetric"}.")
        
        // Also test the functional approach
        val resultFunctional = isSymmetricFunctional(symmetric)
        println("Functional approach: The matrix is ${if (resultFunctional) "symmetric" else "not symmetric"}.")
    } catch (e: IllegalArgumentException) {
        println("\nError: ${e.message}")
    }
    
    // Example 2: Non-symmetric matrix
    val nonSymmetric = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    
    println("\nExample 2: Non-symmetric Matrix")
    printMatrix(nonSymmetric)
    
    try {
        val result = isSymmetricOptimized(nonSymmetric)
        println("\nThe matrix is ${if (result) "symmetric" else "not symmetric"}.")
        
        // Also test the functional approach
        val resultFunctional = isSymmetricOptimizedFunctional(nonSymmetric)
        println("Functional approach: The matrix is ${if (resultFunctional) "symmetric" else "not symmetric"}.")
    } catch (e: IllegalArgumentException) {
        println("\nError: ${e.message}")
    }
    
    // Example 3: Another symmetric matrix
    val symmetric2 = arrayOf(
        intArrayOf(1, 7, 3, 6),
        intArrayOf(7, 4, -5, 9),
        intArrayOf(3, -5, 6, 2),
        intArrayOf(6, 9, 2, 0)
    )
    
    println("\nExample 3: Another Symmetric Matrix")
    printMatrix(symmetric2)
    
    try {
        val result = isSymmetric(symmetric2)
        println("\nThe matrix is ${if (result) "symmetric" else "not symmetric"}.")
        
        // Also test the functional approach
        val resultFunctional = isSymmetricFunctional(symmetric2)
        println("Functional approach: The matrix is ${if (resultFunctional) "symmetric" else "not symmetric"}.")
    } catch (e: IllegalArgumentException) {
        println("\nError: ${e.message}")
    }
    
    // Example 4: Non-square matrix
    val nonSquare = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6)
    )
    
    println("\nExample 4: Non-square Matrix")
    printMatrix(nonSquare)
    
    try {
        val result = isSymmetricOptimized(nonSquare)
        println("\nThe matrix is ${if (result) "symmetric" else "not symmetric"}.")
    } catch (e: IllegalArgumentException) {
        println("\nError: ${e.message}")
    }
    
    // Performance comparison
    println("\nPerformance Comparison:")
    println("For large matrices, the optimized version is more efficient")
    println("as it only checks the upper triangular part.")
    println("The functional approach provides a more concise and readable code.")
}