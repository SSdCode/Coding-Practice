/**
 * Spiral Order Matrix Traversal
 * 
 * This program demonstrates how to traverse a matrix in spiral order in Kotlin.
 * Spiral order traversal starts from the top-left corner and moves right, then down,
 * then left, then up, and so on in a spiral pattern until all elements are visited.
 * 
 * Algorithm:
 * 1. Define four boundaries: top, right, bottom, left
 * 2. Traverse the matrix in four directions (right, down, left, up) within these boundaries
 * 3. After each traversal, shrink the corresponding boundary
 * 4. Continue until all elements are visited
 * 
 * Time Complexity: O(m×n) where m and n are the dimensions of the matrix
 * Space Complexity: O(1) for the traversal (O(m×n) if storing the result)
 */

/**
 * Traverse a matrix in spiral order
 * 
 * @param matrix The input matrix
 * @return A list containing the elements in spiral order
 */
fun spiralOrder(matrix: Array<IntArray>): List<Int> {
    val result = mutableListOf<Int>()
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return result
    }
    
    val rows = matrix.size
    val cols = matrix[0].size
    
    var top = 0
    var right = cols - 1
    var bottom = rows - 1
    var left = 0
    
    while (top <= bottom && left <= right) {
        // Traverse right
        for (j in left..right) {
            result.add(matrix[top][j])
        }
        top++
        
        // Traverse down
        for (i in top..bottom) {
            result.add(matrix[i][right])
        }
        right--
        
        // Traverse left (if there are still rows to traverse)
        if (top <= bottom) {
            for (j in right downTo left) {
                result.add(matrix[bottom][j])
            }
            bottom--
        }
        
        // Traverse up (if there are still columns to traverse)
        if (left <= right) {
            for (i in bottom downTo top) {
                result.add(matrix[i][left])
            }
            left++
        }
    }
    
    return result
}

/**
 * Alternative implementation using a sequence for lazy evaluation
 * 
 * @param matrix The input matrix
 * @return A sequence containing the elements in spiral order
 */
fun spiralOrderSequence(matrix: Array<IntArray>): Sequence<Int> = sequence {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return@sequence
    }
    
    val rows = matrix.size
    val cols = matrix[0].size
    
    var top = 0
    var right = cols - 1
    var bottom = rows - 1
    var left = 0
    
    while (top <= bottom && left <= right) {
        // Traverse right
        for (j in left..right) {
            yield(matrix[top][j])
        }
        top++
        
        // Traverse down
        for (i in top..bottom) {
            yield(matrix[i][right])
        }
        right--
        
        // Traverse left (if there are still rows to traverse)
        if (top <= bottom) {
            for (j in right downTo left) {
                yield(matrix[bottom][j])
            }
            bottom--
        }
        
        // Traverse up (if there are still columns to traverse)
        if (left <= right) {
            for (i in bottom downTo top) {
                yield(matrix[i][left])
            }
            left++
        }
    }
}

/**
 * Print the elements of a matrix in spiral order
 * 
 * @param matrix The input matrix
 */
fun printSpiralOrder(matrix: Array<IntArray>) {
    val result = spiralOrder(matrix)
    
    print("Spiral Order: ")
    println(result.joinToString(" "))
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
    val matrix1 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9)
    )
    
    println("Example 1: Square Matrix (3x3)")
    println("Matrix:")
    printMatrix(matrix1)
    printSpiralOrder(matrix1)
    
    // Example 2: Rectangular matrix (more rows than columns)
    val matrix2 = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
        intArrayOf(10, 11, 12)
    )
    
    println("\nExample 2: Rectangular Matrix (4x3)")
    println("Matrix:")
    printMatrix(matrix2)
    printSpiralOrder(matrix2)
    
    // Example 3: Rectangular matrix (more columns than rows)
    val matrix3 = arrayOf(
        intArrayOf(1, 2, 3, 4, 5),
        intArrayOf(6, 7, 8, 9, 10)
    )
    
    println("\nExample 3: Rectangular Matrix (2x5)")
    println("Matrix:")
    printMatrix(matrix3)
    printSpiralOrder(matrix3)
    
    // Example 4: Single row matrix
    val matrix4 = arrayOf(
        intArrayOf(1, 2, 3, 4, 5)
    )
    
    println("\nExample 4: Single Row Matrix (1x5)")
    println("Matrix:")
    printMatrix(matrix4)
    printSpiralOrder(matrix4)
    
    // Example 5: Single column matrix
    val matrix5 = arrayOf(
        intArrayOf(1),
        intArrayOf(2),
        intArrayOf(3),
        intArrayOf(4)
    )
    
    println("\nExample 5: Single Column Matrix (4x1)")
    println("Matrix:")
    printMatrix(matrix5)
    printSpiralOrder(matrix5)
    
    // Example 6: Using sequence (lazy evaluation)
    println("\nExample 6: Using sequence for Square Matrix (3x3)")
    print("Spiral Order (Sequence): ")
    println(spiralOrderSequence(matrix1).toList().joinToString(" "))
}