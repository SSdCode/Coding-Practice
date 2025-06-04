/**
 * Rotate a Matrix by 90 Degrees
 * 
 * This program demonstrates how to rotate a square matrix by 90 degrees clockwise in Java.
 * 
 * Algorithm:
 * 1. Transpose the matrix (swap rows with columns)
 * 2. Reverse each row of the transposed matrix
 * 
 * Time Complexity: O(n²) where n is the dimension of the matrix
 * Space Complexity: O(1) for in-place rotation
 * 
 * Input: A square matrix of integers
 * Output: The matrix rotated 90 degrees clockwise
 */
public class RotateMatrix {
    
    /**
     * Rotate a square matrix 90 degrees clockwise in-place
     * 
     * @param matrix The input square matrix
     */
    public static void rotateMatrix90Clockwise(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || n != matrix[0].length) {
            System.out.println("Error: Not a square matrix");
            return;
        }
        
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each row
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                // Swap matrix[i][j] with matrix[i][n-1-j]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
    
    /**
     * Rotate a square matrix 90 degrees counter-clockwise in-place
     * 
     * @param matrix The input square matrix
     */
    public static void rotateMatrix90CounterClockwise(int[][] matrix) {
        int n = matrix.length;
        if (n == 0 || n != matrix[0].length) {
            System.out.println("Error: Not a square matrix");
            return;
        }
        
        // Step 1: Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        
        // Step 2: Reverse each column
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n / 2; i++) {
                // Swap matrix[i][j] with matrix[n-1-i][j]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - 1 - i][j];
                matrix[n - 1 - i][j] = temp;
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
    public static int[][] rotateMatrix90ClockwiseNew(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Create a new matrix with swapped dimensions
        int[][] result = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // For 90 degrees clockwise: result[j][rows-1-i] = matrix[i][j]
                result[j][rows - 1 - i] = matrix[i][j];
            }
        }
        
        return result;
    }
    
    /**
     * Print a matrix in a readable format
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
        // Example: Square matrix
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Original Matrix:");
        printMatrix(matrix);
        
        // Create a copy for clockwise rotation
        int[][] matrixClockwise = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, matrixClockwise[i], 0, matrix[i].length);
        }
        
        // Rotate clockwise in-place
        rotateMatrix90Clockwise(matrixClockwise);
        
        System.out.println("\nRotated 90 degrees clockwise (in-place):");
        printMatrix(matrixClockwise);
        
        // Create a copy for counter-clockwise rotation
        int[][] matrixCounterClockwise = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, matrixCounterClockwise[i], 0, matrix[i].length);
        }
        
        // Rotate counter-clockwise in-place
        rotateMatrix90CounterClockwise(matrixCounterClockwise);
        
        System.out.println("\nRotated 90 degrees counter-clockwise (in-place):");
        printMatrix(matrixCounterClockwise);
        
        // Example: Non-square matrix
        int[][] nonSquareMatrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8}
        };
        
        System.out.println("\nNon-Square Matrix:");
        printMatrix(nonSquareMatrix);
        
        // Rotate using a new matrix (works for non-square matrices)
        int[][] rotatedNonSquare = rotateMatrix90ClockwiseNew(nonSquareMatrix);
        
        System.out.println("\nRotated 90 degrees clockwise (new matrix):");
        printMatrix(rotatedNonSquare);
    }
}