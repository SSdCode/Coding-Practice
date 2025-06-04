/**
 * Rotate a Matrix by 90 Degrees
 * 
 * This program demonstrates how to rotate a square matrix by 90 degrees clockwise in C.
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

#include <stdio.h>

/**
 * transposeMatrix - Transpose a square matrix in-place
 * @matrix: The input square matrix
 * @n: The dimension of the square matrix
 * 
 * This function transposes a square matrix in-place by swapping elements
 * across the main diagonal.
 */
void transposeMatrix(int matrix[][100], int n) {
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
 * reverseRows - Reverse each row of a matrix
 * @matrix: The input matrix
 * @n: The dimension of the square matrix
 * 
 * This function reverses each row of the matrix in-place.
 */
void reverseRows(int matrix[][100], int n) {
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
 * rotateMatrix90Clockwise - Rotate a square matrix 90 degrees clockwise
 * @matrix: The input square matrix
 * @n: The dimension of the square matrix
 * 
 * This function rotates a square matrix 90 degrees clockwise in-place
 * by first transposing it and then reversing each row.
 */
void rotateMatrix90Clockwise(int matrix[][100], int n) {
    // Step 1: Transpose the matrix
    transposeMatrix(matrix, n);
    
    // Step 2: Reverse each row
    reverseRows(matrix, n);
}

/**
 * rotateMatrix90CounterClockwise - Rotate a square matrix 90 degrees counter-clockwise
 * @matrix: The input square matrix
 * @n: The dimension of the square matrix
 * 
 * This function rotates a square matrix 90 degrees counter-clockwise in-place
 * by first transposing it and then reversing each column.
 */
void rotateMatrix90CounterClockwise(int matrix[][100], int n) {
    // Step 1: Transpose the matrix
    transposeMatrix(matrix, n);
    
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
 * printMatrix - Print a matrix
 * @matrix: The matrix to print
 * @n: The dimension of the square matrix
 * 
 * This function prints a matrix in a readable format.
 */
void printMatrix(int matrix[][100], int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d\t", matrix[i][j]);
        }
        printf("\n");
    }
}

int main() {
    // Example: Square matrix
    int matrix[100][100] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int n = 3; // Dimension of square matrix
    
    printf("Original Matrix:\n");
    printMatrix(matrix, n);
    
    // Create a copy for clockwise rotation
    int matrixClockwise[100][100];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            matrixClockwise[i][j] = matrix[i][j];
        }
    }
    
    // Rotate clockwise
    rotateMatrix90Clockwise(matrixClockwise, n);
    
    printf("\nRotated 90 degrees clockwise:\n");
    printMatrix(matrixClockwise, n);
    
    // Create a copy for counter-clockwise rotation
    int matrixCounterClockwise[100][100];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            matrixCounterClockwise[i][j] = matrix[i][j];
        }
    }
    
    // Rotate counter-clockwise
    rotateMatrix90CounterClockwise(matrixCounterClockwise, n);
    
    printf("\nRotated 90 degrees counter-clockwise:\n");
    printMatrix(matrixCounterClockwise, n);
    
    return 0;
}