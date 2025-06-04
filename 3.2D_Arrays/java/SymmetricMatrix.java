/**
 * Symmetric Matrix Check
 * 
 * This program demonstrates how to check if a matrix is symmetric in Java.
 * A symmetric matrix is a square matrix that is equal to its transpose.
 * 
 * Time Complexity: O(n²) where n is the dimension of the matrix
 * Space Complexity: O(1) as we only need a few variables
 */

public class SymmetricMatrix {
    
    /**
     * Check if a matrix is symmetric.
     * 
     * @param matrix The input matrix
     * @return true if the matrix is symmetric, false otherwise
     * @throws IllegalArgumentException if the matrix is not square
     */
    public static boolean isSymmetric(int[][] matrix) {
        // Check if the matrix is null
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        
        // Check if the matrix is empty
        if (matrix.length == 0) {
            return true; // Empty matrix is considered symmetric
        }
        
        // Check if the matrix is square
        int size = matrix.length;
        for (int[] row : matrix) {
            if (row.length != size) {
                throw new IllegalArgumentException("Matrix must be square");
            }
        }
        
        // Check if the matrix is symmetric
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Check if a matrix is symmetric (optimized version).
     * 
     * @param matrix The input matrix
     * @return true if the matrix is symmetric, false otherwise
     * @throws IllegalArgumentException if the matrix is not square
     */
    public static boolean isSymmetricOptimized(int[][] matrix) {
        // Check if the matrix is null
        if (matrix == null) {
            throw new IllegalArgumentException("Matrix cannot be null");
        }
        
        // Check if the matrix is empty
        if (matrix.length == 0) {
            return true; // Empty matrix is considered symmetric
        }
        
        // Check if the matrix is square
        int size = matrix.length;
        for (int[] row : matrix) {
            if (row.length != size) {
                throw new IllegalArgumentException("Matrix must be square");
            }
        }
        
        // Check if the matrix is symmetric (only upper triangular part)
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    /**
     * Print a matrix in a readable format.
     * 
     * @param matrix The matrix to print
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // Example 1: Symmetric matrix
        int[][] symmetric = {
            {1, 2, 3},
            {2, 4, 5},
            {3, 5, 6}
        };
        
        System.out.println("Example 1: Symmetric Matrix");
        printMatrix(symmetric);
        
        try {
            if (isSymmetric(symmetric)) {
                System.out.println("\nThe matrix is symmetric.");
            } else {
                System.out.println("\nThe matrix is not symmetric.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Example 2: Non-symmetric matrix
        int[][] nonSymmetric = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("\nExample 2: Non-symmetric Matrix");
        printMatrix(nonSymmetric);
        
        try {
            if (isSymmetricOptimized(nonSymmetric)) {
                System.out.println("\nThe matrix is symmetric.");
            } else {
                System.out.println("\nThe matrix is not symmetric.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Example 3: Another symmetric matrix
        int[][] symmetric2 = {
            {1, 7, 3, 6},
            {7, 4, -5, 9},
            {3, -5, 6, 2},
            {6, 9, 2, 0}
        };
        
        System.out.println("\nExample 3: Another Symmetric Matrix");
        printMatrix(symmetric2);
        
        try {
            if (isSymmetric(symmetric2)) {
                System.out.println("\nThe matrix is symmetric.");
            } else {
                System.out.println("\nThe matrix is not symmetric.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Example 4: Non-square matrix
        int[][] nonSquare = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        System.out.println("\nExample 4: Non-square Matrix");
        printMatrix(nonSquare);
        
        try {
            if (isSymmetricOptimized(nonSquare)) {
                System.out.println("\nThe matrix is symmetric.");
            } else {
                System.out.println("\nThe matrix is not symmetric.");
            }
        } catch (IllegalArgumentException e) {
            System.err.println("\nError: " + e.getMessage());
        }
        
        // Performance comparison
        System.out.println("\nPerformance Comparison:");
        System.out.println("For large matrices, the optimized version is more efficient");
        System.out.println("as it only checks the upper triangular part.");
    }
}