/**
 * Matrix Addition
 * 
 * This program demonstrates how to add two matrices in C.
 * 
 * Time Complexity: O(m×n) where m and n are the dimensions of the matrices
 * Space Complexity: O(m×n) for storing the result matrix
 */

#include <stdio.h>

/**
 * addMatrices - Add two matrices and store the result in a third matrix
 * @matrix1: The first input matrix
 * @matrix2: The second input matrix
 * @result: The matrix to store the result
 * @rows: Number of rows in the matrices
 * @cols: Number of columns in the matrices
 * 
 * This function adds corresponding elements of two matrices and stores
 * the result in a third matrix.
 */
void addMatrices(int matrix1[][100], int matrix2[][100], int result[][100], int rows, int cols) {
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            result[i][j] = matrix1[i][j] + matrix2[i][j];
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
    // Example matrices
    int matrix1[100][100] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    
    int matrix2[100][100] = {
        {9, 8, 7},
        {6, 5, 4},
        {3, 2, 1}
    };
    
    int result[100][100];
    int rows = 3, cols = 3;
    
    printf("Matrix 1:\n");
    printMatrix(matrix1, rows, cols);
    
    printf("\nMatrix 2:\n");
    printMatrix(matrix2, rows, cols);
    
    // Add the matrices
    addMatrices(matrix1, matrix2, result, rows, cols);
    
    printf("\nResult of Matrix Addition:\n");
    printMatrix(result, rows, cols);
    
    return 0;
}