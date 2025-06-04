/**
 * Matrix Multiplication
 * 
 * This program demonstrates how to multiply two matrices in C.
 * 
 * Time Complexity: O(n³) where n is the dimension of the matrices
 * Space Complexity: O(n²) for storing the result matrix
 */

#include <stdio.h>

/**
 * multiplyMatrices - Multiply two matrices and store the result in a third matrix
 * @matrix1: The first input matrix
 * @matrix2: The second input matrix
 * @result: The matrix to store the result
 * @rows1: Number of rows in the first matrix
 * @cols1: Number of columns in the first matrix
 * @cols2: Number of columns in the second matrix
 * 
 * This function multiplies two matrices and stores the result in a third matrix.
 * For matrix multiplication to be valid, the number of columns in the first matrix
 * must equal the number of rows in the second matrix.
 */
void multiplyMatrices(int matrix1[][100], int matrix2[][100], int result[][100], 
                      int rows1, int cols1, int cols2) {
    // Initialize result matrix with zeros
    for (int i = 0; i < rows1; i++) {
        for (int j = 0; j < cols2; j++) {
            result[i][j] = 0;
        }
    }
    
    // Multiply matrices
    for (int i = 0; i < rows1; i++) {
        for (int j = 0; j < cols2; j++) {
            for (int k = 0; k < cols1; k++) {
                result[i][j] += matrix1[i][k] * matrix2[k][j];
            }
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
        {4, 5, 6}
    };
    
    int matrix2[100][100] = {
        {7, 8},
        {9, 10},
        {11, 12}
    };
    
    int result[100][100];
    int rows1 = 2, cols1 = 3;
    int rows2 = 3, cols2 = 2;
    
    // Check if multiplication is possible
    if (cols1 != rows2) {
        printf("Error: Matrix multiplication not possible. Number of columns in first matrix must equal number of rows in second matrix.\n");
        return 1;
    }
    
    printf("Matrix 1 (%dx%d):\n", rows1, cols1);
    printMatrix(matrix1, rows1, cols1);
    
    printf("\nMatrix 2 (%dx%d):\n", rows2, cols2);
    printMatrix(matrix2, rows2, cols2);
    
    // Multiply the matrices
    multiplyMatrices(matrix1, matrix2, result, rows1, cols1, cols2);
    
    printf("\nResult of Matrix Multiplication (%dx%d):\n", rows1, cols2);
    printMatrix(result, rows1, cols2);
    
    // Example 2: Square matrices
    int matrix3[100][100] = {
        {1, 2},
        {3, 4}
    };
    
    int matrix4[100][100] = {
        {5, 6},
        {7, 8}
    };
    
    int result2[100][100];
    int size = 2;
    
    printf("\nExample 2: Square Matrices\n");
    printf("Matrix 3 (%dx%d):\n", size, size);
    printMatrix(matrix3, size, size);
    
    printf("\nMatrix 4 (%dx%d):\n", size, size);
    printMatrix(matrix4, size, size);
    
    // Multiply the square matrices
    multiplyMatrices(matrix3, matrix4, result2, size, size, size);
    
    printf("\nResult of Square Matrix Multiplication (%dx%d):\n", size, size);
    printMatrix(result2, size, size);
    
    return 0;
}