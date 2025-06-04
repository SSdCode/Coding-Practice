/**
 * Search an Element in a Sorted Matrix
 * 
 * This program demonstrates how to efficiently search for an element in a matrix
 * that is sorted both row-wise and column-wise in Kotlin.
 * 
 * Algorithm 1 (for row-wise and column-wise sorted matrix):
 * 1. Start from the top-right corner of the matrix
 * 2. If the current element is equal to the target, return its position
 * 3. If the current element is greater than the target, move left (eliminate the current column)
 * 4. If the current element is less than the target, move down (eliminate the current row)
 * 5. Repeat until the element is found or the search space is exhausted
 * 
 * Algorithm 2 (for matrix where each row is sorted and first element of each row is greater than last element of previous row):
 * 1. Treat the matrix as a flattened sorted array
 * 2. Perform binary search on this virtual array
 * 3. Convert the mid index to row and column indices for comparison
 * 
 * Time Complexity: 
 * - Algorithm 1: O(m+n) where m and n are the dimensions of the matrix
 * - Algorithm 2: O(log(m*n)) where m and n are the dimensions of the matrix
 * 
 * Space Complexity: O(1) for both algorithms
 */

/**
 * Search for a target value in a matrix that is sorted both row-wise and column-wise.
 * 
 * @param matrix The input sorted matrix
 * @param target The value to search for
 * @return A Pair containing the row and column indices of the target (if found),
 *         or Pair(-1, -1) if not found
 */
fun searchMatrix(matrix: Array<IntArray>, target: Int): Pair<Int, Int> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return Pair(-1, -1)
    }
    
    val rows = matrix.size
    val cols = matrix[0].size
    
    // Start from the top-right corner
    var i = 0
    var j = cols - 1
    
    while (i < rows && j >= 0) {
        when {
            matrix[i][j] == target -> {
                // Target found, return its position
                return Pair(i, j)
            }
            matrix[i][j] > target -> {
                // Current element is greater than target, move left
                j--
            }
            else -> {
                // Current element is less than target, move down
                i++
            }
        }
    }
    
    // Target not found
    return Pair(-1, -1)
}

/**
 * Search for a target value in a sorted matrix using binary search.
 * This works when the matrix has the property that the first element of each row
 * is greater than the last element of the previous row.
 * 
 * @param matrix The input sorted matrix
 * @param target The value to search for
 * @return A Pair containing the row and column indices of the target (if found),
 *         or Pair(-1, -1) if not found
 */
fun searchMatrixBinary(matrix: Array<IntArray>, target: Int): Pair<Int, Int> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return Pair(-1, -1)
    }
    
    val rows = matrix.size
    val cols = matrix[0].size
    
    // Treat the matrix as a flattened sorted array
    var left = 0
    var right = rows * cols - 1
    
    while (left <= right) {
        val mid = left + (right - left) / 2
        
        // Convert mid index to row and column indices
        val midRow = mid / cols
        val midCol = mid % cols
        
        when {
            matrix[midRow][midCol] == target -> {
                // Target found, return its position
                return Pair(midRow, midCol)
            }
            matrix[midRow][midCol] < target -> {
                // Target is in the right half
                left = mid + 1
            }
            else -> {
                // Target is in the left half
                right = mid - 1
            }
        }
    }
    
    // Target not found
    return Pair(-1, -1)
}

/**
 * Search for a target value in a matrix that is sorted both row-wise and column-wise
 * using Kotlin's functional approach.
 * 
 * @param matrix The input sorted matrix
 * @param target The value to search for
 * @return A Pair containing the row and column indices of the target (if found),
 *         or Pair(-1, -1) if not found
 */
fun searchMatrixFunctional(matrix: Array<IntArray>, target: Int): Pair<Int, Int> {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return Pair(-1, -1)
    }
    
    // Find the target using sequence and indexing
    for (i in matrix.indices) {
        for (j in matrix[i].indices) {
            if (matrix[i][j] == target) {
                return Pair(i, j)
            }
            // Early termination if we've gone past the target in this row
            if (matrix[i][j] > target) {
                break
            }
        }
    }
    
    return Pair(-1, -1)
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
    // Example 1: Matrix sorted both row-wise and column-wise
    val matrix1 = arrayOf(
        intArrayOf(10, 20, 30, 40),
        intArrayOf(15, 25, 35, 45),
        intArrayOf(27, 29, 37, 48),
        intArrayOf(32, 33, 39, 50)
    )
    
    println("Example 1: Matrix sorted both row-wise and column-wise")
    println("Matrix:")
    printMatrix(matrix1)
    
    // Test cases for Example 1
    val targets1 = intArrayOf(29, 10, 50, 100)
    
    targets1.forEach { target ->
        val (row, col) = searchMatrix(matrix1, target)
        
        if (row != -1 && col != -1) {
            println("\nTarget $target found at position ($row, $col)")
        } else {
            println("\nTarget $target not found in the matrix")
        }
    }
    
    // Example 2: Matrix where each row is sorted and the first element of each row
    // is greater than the last element of the previous row
    val matrix2 = arrayOf(
        intArrayOf(1, 3, 5, 7),
        intArrayOf(10, 11, 16, 20),
        intArrayOf(23, 30, 34, 60)
    )
    
    println("\nExample 2: Matrix where each row is sorted and the first element of each row")
    println("is greater than the last element of the previous row")
    println("Matrix:")
    printMatrix(matrix2)
    
    // Test cases for Example 2
    val targets2 = intArrayOf(3, 13, 60, 100)
    
    targets2.forEach { target ->
        val (row, col) = searchMatrixBinary(matrix2, target)
        
        if (row != -1 && col != -1) {
            println("\nTarget $target found at position ($row, $col) using binary search")
        } else {
            println("\nTarget $target not found in the matrix using binary search")
        }
    }
    
    // Example 3: Using functional approach
    println("\nExample 3: Using functional approach on matrix 1")
    targets1.forEach { target ->
        val (row, col) = searchMatrixFunctional(matrix1, target)
        
        if (row != -1 && col != -1) {
            println("\nTarget $target found at position ($row, $col) using functional approach")
        } else {
            println("\nTarget $target not found in the matrix using functional approach")
        }
    }
}