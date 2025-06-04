/**
 * Transpose of a Matrix
 * 
 * This program demonstrates how to transpose a matrix in Java.
 * Transposing a matrix means converting its rows into columns and vice versa.
 * 
 * Algorithm:
 * 1. For a square matrix (in-place transpose):
 *    a. Iterate through the upper triangular portion of the matrix
 *    b. Swap each element with its corresponding element across the main diagonal
 * 2. For a non-square matrix:
 *    a. Create a new matrix with dimensions swapped
 *    b. Copy each element to its transposed position
 * 
 * Time Complexity: O(n²) where n is the dimension of the matrix
 * Space Complexity: O(1) for in-place transpose (square matrix) or O(m×n) for non-square matrices
 * 
 * Input: A matrix of integers
 * Output: The transposed matrix
 */
public class TransposeMatrix {
    
    /**
     * Transpose a square matrix in-place
     * 
     * @param matrix The input square matrix
     */
    public static void transposeSquareMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // Swap matrix[i][j] with matrix[j][i]
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    
    /**
     * Transpose any matrix (works for both square and non-square)
     * 
     * @param matrix The input matrix
     * @return A new matrix that is the transpose of the input matrix
     */
    public static int[][] transposeMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new int[0][0];
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Create a new matrix with swapped dimensions
        int[][] result = new int[cols][rows];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[j][i] = matrix[i][j];
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
        // Example 1: Square matrix
        int[][] squareMatrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Example 1: Square Matrix (3x3)");
        System.out.println("Original Matrix:");
        printMatrix(squareMatrix);
        
        // Create a copy for the in-place transpose
        int[][] squareMatrixCopy = new int[squareMatrix.length][squareMatrix.length];
        for (int i = 0; i < squareMatrix.length; i++) {
            System.arraycopy(squareMatrix[i], 0, squareMatrixCopy[i], 0, squareMatrix[i].length);
        }
        
        // Transpose in-place
        transposeSquareMatrix(squareMatrixCopy);
        
        System.out.println("\nTransposed Matrix (In-place):");
        printMatrix(squareMatrixCopy);
        
        // Example 2: Non-square matrix
        int[][] nonSquareMatrix = {
            {1, 2, 3, 4},
            {5, 6, 7, 8}
        };
        
        System.out.println("\nExample 2: Non-Square Matrix (2x4)");
        System.out.println("Original Matrix:");
        printMatrix(nonSquareMatrix);
        
        // Transpose using a new matrix
        int[][] transposed = transposeMatrix(nonSquareMatrix);
        
        System.out.println("\nTransposed Matrix (4x2):");
        printMatrix(transposed);
    }
}