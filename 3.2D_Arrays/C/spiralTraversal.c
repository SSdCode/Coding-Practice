/**
 * Spiral Order Matrix Traversal
 * 
 * This program demonstrates how to traverse a matrix in spiral order in C.
 * Spiral order traversal starts from the top-left corner and moves right, then down,
 * then left, then up, and so on in a spiral pattern until all elements are visited.
 * 
 * Algorithm:
 * 1. Define four boundaries: top, right, bottom, left
 * 2. Traverse the matrix in four directions (right, down, left, up) within these boundaries
 * 3. After each traversal, shrink the corresponding boundary
 * 4. Continue until all elements are visited
 * 
 * Time Complexity: O(m×n) where m and n are the dimensions of the matrix
 * Space Complexity: O(1) for the traversal (O(m×n) if storing the result)
 * 
 * Input: A matrix of integers
 * Output: The elements of the matrix in spiral order
 */

#include <stdio.h>
#include <stdlib.h>

/**
 * spiralOrder - Traverse a matrix in spiral order
 * @matrix: The input matrix
 * @rows: Number of rows in the matrix
 * @cols: Number of columns in the matrix
 * @result: Array to store the spiral order traversal
 * 
 * This function traverses a matrix in spiral order and stores the elements
 * in the result array.
 * 
 * Returns: The number of elements in the result array
 */
int spiralOrder(int matrix[][100], int rows, int cols, int result[]) {
    if (rows == 0 || cols == 0) return 0;
    
    int top = 0, right = cols - 1, bottom = rows - 1, left = 0;
    int index = 0;
    
    while (top <= bottom && left <= right) {
        // Traverse right
        for (int j = left; j <= right; j++) {
            result[index++] = matrix[top][j];
        }
        top++;
        
        // Traverse down
        for (int i = top; i <= bottom; i++) {
            result[index++] = matrix[i][right];
        }
        right--;
        
        // Traverse left (if there are still rows to traverse)
        if (top <= bottom) {
            for (int j = right; j >= left; j--) {
                result[index++] = matrix[bottom][j];
            }
            bottom--;
        }
        
        // Traverse up (if there are still columns to traverse)
        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                result[index++] = matrix[i][left];
            }
            left++;
        }
    }
    
    return index; // Return the number of elements
}

/**
 * printSpiralOrder - Print the elements of a matrix in spiral order
 * @matrix: The input matrix
 * @rows: Number of rows in the matrix
 * @cols: Number of columns in the matrix
 * 
 * This function traverses a matrix in spiral order and prints the elements.
 */
void printSpiralOrder(int matrix[][100], int rows, int cols) {
    if (rows == 0 || cols == 0) return;
    
    // Allocate memory for result array
    int* result = (int*)malloc(rows * cols * sizeof(int));
    if (result == NULL) {
        printf("Memory allocation failed\n");
        return;
    }
    
    // Get spiral order traversal
    int count = spiralOrder(matrix, rows, cols, result);
    
    // Print the result
    printf("Spiral Order: ");
    for (int i = 0; i < count; i++) {
        printf("%d ", result[i]);
    }
    printf("\n");
    
    // Free allocated memory
    free(result);
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
    int matrix1[100][100] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    int rows1 = 3, cols1 = 3;
    
    printf("Example 1: Square Matrix (3x3)\n");
    printf("Matrix:\n");
    printMatrix(matrix1, rows1, cols1);
    printSpiralOrder(matrix1, rows1, cols1);
    
    // Example 2: Rectangular matrix (more rows than columns)
    int matrix2[100][100] = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {10, 11, 12}
    };
    int rows2 = 4, cols2 = 3;
    
    printf("\nExample 2: Rectangular Matrix (4x3)\n");
    printf("Matrix:\n");
    printMatrix(matrix2, rows2, cols2);
    printSpiralOrder(matrix2, rows2, cols2);
    
    // Example 3: Rectangular matrix (more columns than rows)
    int matrix3[100][100] = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10}
    };
    int rows3 = 2, cols3 = 5;
    
    printf("\nExample 3: Rectangular Matrix (2x5)\n");
    printf("Matrix:\n");
    printMatrix(matrix3, rows3, cols3);
    printSpiralOrder(matrix3, rows3, cols3);
    
    return 0;
}