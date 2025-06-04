/**
 * Transpose of a Matrix
 * 
 * This program demonstrates how to transpose a matrix in C.
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

#include <stdio.h>

/**
 * transposeSquareMatrix - Transpose a square matrix in-place
 * @matrix: The input square matrix
 * @n: The dimension of the square matrix
 * 
 * This function transposes a square matrix in-place by swapping elements
 * across the main diagonal.
 */
void transposeSquareMatrix(int matrix[][100], int n) {
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
 * transposeMatrix - Transpose a matrix (works for both square and non-square)
 * @matrix: The input matrix
 * @rows: Number of rows in the input matrix
 * @cols: Number of columns in the input matrix
 * @result: The output transposed matrix
 * 
 * This function transposes any matrix by copying elements to their
 * transposed positions in a new matrix.
 */
void transposeMatrix(int matrix[][100], int rows, int cols, int result[][100]) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            result[j][i] = matrix[i][j];
        }
    }
}

/**
 * printMatrix - Print a matrix
 * @matrix: The matrix to print
 * @rows: Number of rows in the matrix
 * @cols: Number of columns in the matrix
 * 
 * This function prints a matrix in a readable format.
 */
void printMatrix(int matrix[][100], int rows, int cols) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            printf("%d\t", matrix[i][j]);
        }
        printf("\n");
    }
}

int main() {
    // Example 1: Square matrix
    int squareMatrix[100][100] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int n = 3; // Dimension of square matrix
    
    printf("Example 1: Square Matrix (3x3)\n");
    printf("Original Matrix:\n");
    printMatrix(squareMatrix, n, n);
    
    // Transpose in-place
    transposeSquareMatrix(squareMatrix, n);
    
    printf("\nTransposed Matrix (In-place):\n");
    printMatrix(squareMatrix, n, n);
    
    // Example 2: Non-square matrix
    int nonSquareMatrix[100][100] = {
        {1, 2, 3, 4},
        {5, 6, 7, 8}
    };
    int rows = 2, cols = 4;
    int transposed[100][100];
    
    printf("\nExample 2: Non-Square Matrix (2x4)\n");
    printf("Original Matrix:\n");
    printMatrix(nonSquareMatrix, rows, cols);
    
    // Transpose using a new matrix
    transposeMatrix(nonSquareMatrix, rows, cols, transposed);
    
    printf("\nTransposed Matrix (4x2):\n");
    printMatrix(transposed, cols, rows);
    
    return 0;
}