/**
 * Matrix Addition
 * 
 * This program demonstrates how to add two matrices in Java.
 * 
 * Time Complexity: O(m×n) where m and n are the dimensions of the matrices
 * Space Complexity: O(m×n) for storing the result matrix
 */

public class MatrixAddition {
    
    /**
     * Add two matrices and return the result.
     * 
     * @param matrix1 The first input matrix
     * @param matrix2 The second input matrix
     * @return A new matrix containing the sum of the input matrices
     * @throws IllegalArgumentException if matrices have different dimensions
     */
    public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
        // Check if matrices are null
        if (matrix1 == null || matrix2 == null) {
            throw new IllegalArgumentException("Matrices cannot be null");
        }
        
        // Check if matrices are empty
        if (matrix1.length == 0 || matrix2.length == 0) {
            throw new IllegalArgumentException("Matrices cannot be empty");
        }
        
        // Check if matrices have the same dimensions
        if (matrix1.length != matrix2.length || matrix1[0].length != matrix2[0].length) {
            throw new IllegalArgumentException("Matrices must have the same dimensions for addition");
        }
        
        int rows = matrix1.length;
        int cols = matrix1[0].length;
        
        // Initialize result matrix
        int[][] result = new int[rows][cols];
        
        // Add corresponding elements
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }
        
        return result;
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
        // Example matrices
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        int[][] matrix2 = {
            {9, 8, 7},
            {6, 5, 4},
            {3, 2, 1}
        };
        
        System.out.println("Matrix 1:");
        printMatrix(matrix1);
        
        System.out.println("\nMatrix 2:");
        printMatrix(matrix2);
        
        try {
            // Add the matrices
            int[][] result = addMatrices(matrix1, matrix2);
            
            System.out.println("\nResult of Matrix Addition:");
            printMatrix(result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Example with matrices of different dimensions
        System.out.println("\nExample with matrices of different dimensions:");
        int[][] matrix3 = {
            {1, 2},
            {3, 4}
        };
        
        System.out.println("Matrix 3 (2x2):");
        printMatrix(matrix3);
        
        try {
            // Try to add matrices of different dimensions
            int[][] result = addMatrices(matrix1, matrix3);
            printMatrix(result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}