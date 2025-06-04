/**
 * Matrix Multiplication
 * 
 * This program demonstrates how to multiply two matrices in Java.
 * 
 * Time Complexity: O(n³) where n is the dimension of the matrices
 * Space Complexity: O(n²) for storing the result matrix
 */

public class MatrixMultiplication {
    
    /**
     * Multiply two matrices and return the result.
     * 
     * @param matrix1 The first input matrix
     * @param matrix2 The second input matrix
     * @return A new matrix containing the product of the input matrices
     * @throws IllegalArgumentException if matrices have invalid dimensions for multiplication
     */
    public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        // Check if matrices are null
        if (matrix1 == null || matrix2 == null) {
            throw new IllegalArgumentException("Matrices cannot be null");
        }
        
        // Check if matrices are empty
        if (matrix1.length == 0 || matrix2.length == 0) {
            throw new IllegalArgumentException("Matrices cannot be empty");
        }
        
        // Check if multiplication is possible
        if (matrix1[0].length != matrix2.length) {
            throw new IllegalArgumentException(
                "Matrix multiplication not possible. Number of columns in first matrix (" + 
                matrix1[0].length + ") must equal number of rows in second matrix (" + 
                matrix2.length + ")."
            );
        }
        
        int rows1 = matrix1.length;
        int cols1 = matrix1[0].length;
        int cols2 = matrix2[0].length;
        
        // Initialize result matrix
        int[][] result = new int[rows1][cols2];
        
        // Multiply matrices
        for (int i = 0; i < rows1; i++) {
            for (int j = 0; j < cols2; j++) {
                for (int k = 0; k < cols1; k++) {
                    result[i][j] += matrix1[i][k] * matrix2[k][j];
                }
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
                System.out.printf("%4d", val);
            }
            System.out.println();
        }
    }
    
    /**
     * Get the dimensions of a matrix.
     * 
     * @param matrix The matrix
     * @return An array containing the number of rows and columns
     */
    public static int[] getMatrixDimensions(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new int[] {0, 0};
        }
        return new int[] {matrix.length, matrix[0].length};
    }
    
    public static void main(String[] args) {
        // Example matrices
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6}
        };
        
        int[][] matrix2 = {
            {7, 8},
            {9, 10},
            {11, 12}
        };
        
        int[] dims1 = getMatrixDimensions(matrix1);
        int[] dims2 = getMatrixDimensions(matrix2);
        
        System.out.println("Matrix 1 (" + dims1[0] + "x" + dims1[1] + "):");
        printMatrix(matrix1);
        
        System.out.println("\nMatrix 2 (" + dims2[0] + "x" + dims2[1] + "):");
        printMatrix(matrix2);
        
        try {
            // Multiply the matrices
            int[][] result = multiplyMatrices(matrix1, matrix2);
            
            int[] resultDims = getMatrixDimensions(result);
            System.out.println("\nResult of Matrix Multiplication (" + resultDims[0] + "x" + resultDims[1] + "):");
            printMatrix(result);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Example 2: Square matrices
        int[][] matrix3 = {
            {1, 2},
            {3, 4}
        };
        
        int[][] matrix4 = {
            {5, 6},
            {7, 8}
        };
        
        int[] dims3 = getMatrixDimensions(matrix3);
        int[] dims4 = getMatrixDimensions(matrix4);
        
        System.out.println("\nExample 2: Square Matrices");
        System.out.println("Matrix 3 (" + dims3[0] + "x" + dims3[1] + "):");
        printMatrix(matrix3);
        
        System.out.println("\nMatrix 4 (" + dims4[0] + "x" + dims4[1] + "):");
        printMatrix(matrix4);
        
        try {
            // Multiply the square matrices
            int[][] result2 = multiplyMatrices(matrix3, matrix4);
            
            int[] resultDims2 = getMatrixDimensions(result2);
            System.out.println("\nResult of Square Matrix Multiplication (" + resultDims2[0] + "x" + resultDims2[1] + "):");
            printMatrix(result2);
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
        
        // Example 3: Invalid multiplication
        int[][] matrix5 = {
            {1, 2},
            {3, 4}
        };
        
        int[][] matrix6 = {
            {5, 6, 7},
            {8, 9, 10},
            {11, 12, 13}
        };
        
        int[] dims5 = getMatrixDimensions(matrix5);
        int[] dims6 = getMatrixDimensions(matrix6);
        
        System.out.println("\nExample 3: Invalid Multiplication");
        System.out.println("Matrix 5 (" + dims5[0] + "x" + dims5[1] + "):");
        printMatrix(matrix5);
        
        System.out.println("\nMatrix 6 (" + dims6[0] + "x" + dims6[1] + "):");
        printMatrix(matrix6);
        
        try {
            // Try to multiply incompatible matrices
            int[][] result3 = multiplyMatrices(matrix5, matrix6);
            printMatrix(result3);
        } catch (IllegalArgumentException e) {
            System.err.println("\nError: " + e.getMessage());
        }
    }
}