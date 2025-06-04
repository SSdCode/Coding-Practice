/**
 * Symmetric Matrix Check
 * 
 * This program demonstrates how to check if a matrix is symmetric in C.
 * A symmetric matrix is a square matrix that is equal to its transpose.
 * 
 * Time Complexity: O(n²) where n is the dimension of the matrix
 * Space Complexity: O(1) as we only need a few variables
 */

#include <stdio.h>
#include <stdbool.h>

/**
 * isSymmetric - Check if a matrix is symmetric
 * @matrix: The input matrix
 * @size: Size of the square matrix
 * 
 * This function checks if a matrix is symmetric by comparing each element
 * with its corresponding element in the transpose (i.e., matrix[i][j] == matrix[j][i]).
 * 
 * Returns: true if the matrix is symmetric, false otherwise
 */
bool isSymmetric(int matrix[][100], int size) {
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
 * isSymmetricOptimized - Check if a matrix is symmetric (optimized version)
 * @matrix: The input matrix
 * @size: The size of the matrix (number of rows/columns)
 * 
 * This function checks if a matrix is symmetric by only comparing elements
 * in the upper triangular part with their corresponding elements in the lower
 * triangular part (i.e., matrix[i][j] == matrix[j][i] for i < j).
 * 
 * Returns: true if the matrix is symmetric, false otherwise
 */
bool isSymmetricOptimized(int matrix[][100], int size) {
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
 * printMatrix - Print a matrix
 * @matrix: The matrix to print
 * @size: Size of the square matrix
 * 
 * This function prints a matrix in a readable format.
 */
void printMatrix(int matrix[][100], int size) {
    for (int i = 0; i < size; i++) {
        for (int j = 0; j < size; j++) {
            printf("%d\t", matrix[i][j]);
        }
        printf("\n");
    }
}

int main() {
    // Example 1: Symmetric matrix
    int symmetric[100][100] = {
        {1, 2, 3},
        {2, 4, 5},
        {3, 5, 6}
    };
    int size1 = 3;
    
    printf("Example 1: Symmetric Matrix\n");
    printMatrix(symmetric, size1);
    
    if (isSymmetric(symmetric, size1)) {
        printf("\nThe matrix is symmetric.\n");
    } else {
        printf("\nThe matrix is not symmetric.\n");
    }
    
    // Example 2: Non-symmetric matrix
    int nonSymmetric[100][100] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int size2 = 3;
    
    printf("\nExample 2: Non-symmetric Matrix\n");
    printMatrix(nonSymmetric, size2);
    
    if (isSymmetricOptimized(nonSymmetric, size2)) {
        printf("\nThe matrix is symmetric.\n");
    } else {
        printf("\nThe matrix is not symmetric.\n");
    }
    
    // Example 3: Another symmetric matrix
    int symmetric2[100][100] = {
        {1, 7, 3, 6},
        {7, 4, -5, 9},
        {3, -5, 6, 2},
        {6, 9, 2, 0}
    };
    int size3 = 4;
    
    printf("\nExample 3: Another Symmetric Matrix\n");
    printMatrix(symmetric2, size3);
    
    if (isSymmetric(symmetric2, size3)) {
        printf("\nThe matrix is symmetric.\n");
    } else {
        printf("\nThe matrix is not symmetric.\n");
    }
    
    // Performance comparison
    printf("\nPerformance Comparison:\n");
    printf("For large matrices, the optimized version is more efficient\n");
    printf("as it only checks the upper triangular part.\n");
    
    return 0;
}