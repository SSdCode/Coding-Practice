/**
 * Search an Element in a Sorted Matrix
 * 
 * This program demonstrates how to efficiently search for an element in a matrix
 * that is sorted both row-wise and column-wise in C.
 * 
 * Algorithm:
 * 1. Start from the top-right corner of the matrix
 * 2. If the current element is equal to the target, return its position
 * 3. If the current element is greater than the target, move left (eliminate the current column)
 * 4. If the current element is less than the target, move down (eliminate the current row)
 * 5. Repeat until the element is found or the search space is exhausted
 * 
 * Time Complexity: O(m+n) where m and n are the dimensions of the matrix
 * Space Complexity: O(1)
 * 
 * Input: A sorted matrix of integers and a target value
 * Output: The position of the target value in the matrix, or (-1, -1) if not found
 */

#include <stdio.h>
#include <stdbool.h>

/**
 * searchMatrix - Search for a target value in a sorted matrix
 * @matrix: The input sorted matrix
 * @rows: Number of rows in the matrix
 * @cols: Number of columns in the matrix
 * @target: The value to search for
 * @row: Pointer to store the row index of the target (if found)
 * @col: Pointer to store the column index of the target (if found)
 * 
 * This function searches for a target value in a matrix that is sorted
 * both row-wise and column-wise. It starts from the top-right corner
 * and eliminates rows or columns based on the comparison with the target.
 * 
 * Returns: true if the target is found, false otherwise
 */
bool searchMatrix(int matrix[][100], int rows, int cols, int target, int *row, int *col) {
    if (rows == 0 || cols == 0) return false;
    
    // Start from the top-right corner
    int i = 0;
    int j = cols - 1;
    
    while (i < rows && j >= 0) {
        if (matrix[i][j] == target) {
            // Target found, store its position
            *row = i;
            *col = j;
            return true;
        } else if (matrix[i][j] > target) {
            // Current element is greater than target, move left
            j--;
        } else {
            // Current element is less than target, move down
            i++;
        }
    }
    
    // Target not found
    *row = -1;
    *col = -1;
    return false;
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
    // Example: Sorted matrix
    int matrix[100][100] = {
        {10, 20, 30, 40},
        {15, 25, 35, 45},
        {27, 29, 37, 48},
        {32, 33, 39, 50}
    };
    int rows = 4, cols = 4;
    
    printf("Sorted Matrix:\n");
    printMatrix(matrix, rows, cols);
    
    // Test cases
    int targets[] = {29, 10, 50, 100};
    int numTargets = sizeof(targets) / sizeof(targets[0]);
    
    for (int i = 0; i < numTargets; i++) {
        int target = targets[i];
        int row, col;
        
        bool found = searchMatrix(matrix, rows, cols, target, &row, &col);
        
        if (found) {
            printf("\nTarget %d found at position (%d, %d)\n", target, row, col);
        } else {
            printf("\nTarget %d not found in the matrix\n", target);
        }
    }
    
    return 0;
}