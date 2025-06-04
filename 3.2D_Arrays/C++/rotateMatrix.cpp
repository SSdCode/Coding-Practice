/**
 * Rotate a Matrix by 90 Degrees
 * 
 * This program demonstrates how to rotate a square matrix by 90 degrees clockwise in C++.
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

#include <iostream>
#include <vector>
#include <algorithm> // for std::reverse

/**
 * rotateMatrix90Clockwise - Rotate a square matrix 90 degrees clockwise in-place
 * @matrix: The input square matrix (passed by reference)
 * 
 * This function rotates a square matrix 90 degrees clockwise in-place
 * by first transposing it and then reversing each row.
 */
void rotateMatrix90Clockwise(std::vector<std::vector<int>>& matrix) {
    int n = matrix.size();
    if (n == 0 || n != matrix[0].size()) {
        std::cout << "Error: Not a square matrix" << std::endl;
        return;
    }
    
    // Step 1: Transpose the matrix
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            std::swap(matrix[i][j], matrix[j][i]);
        }
    }
    
    // Step 2: Reverse each row
    for (int i = 0; i < n; i++) {
        std::reverse(matrix[i].begin(), matrix[i].end());
    }
}

/**
 * rotateMatrix90CounterClockwise - Rotate a square matrix 90 degrees counter-clockwise
 * @matrix: The input square matrix (passed by reference)
 * 
 * This function rotates a square matrix 90 degrees counter-clockwise in-place
 * by first transposing it and then reversing each column.
 */
void rotateMatrix90CounterClockwise(std::vector<std::vector<int>>& matrix) {
    int n = matrix.size();
    if (n == 0 || n != matrix[0].size()) {
        std::cout << "Error: Not a square matrix" << std::endl;
        return;
    }
    
    // Step 1: Transpose the matrix
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            std::swap(matrix[i][j], matrix[j][i]);
        }
    }
    
    // Step 2: Reverse each column
    for (int j = 0; j < n; j++) {
        for (int i = 0; i < n / 2; i++) {
            std::swap(matrix[i][j], matrix[n - 1 - i][j]);
        }
    }
}

/**
 * rotateMatrix90ClockwiseNew - Create a new rotated matrix
 * @matrix: The input matrix
 * 
 * This function creates and returns a new matrix that is the input matrix
 * rotated 90 degrees clockwise. Works for non-square matrices as well.
 * 
 * Returns: A new matrix rotated 90 degrees clockwise
 */
std::vector<std::vector<int>> rotateMatrix90ClockwiseNew(const std::vector<std::vector<int>>& matrix) {
    if (matrix.empty()) return {};
    
    int rows = matrix.size();
    int cols = matrix[0].size();
    
    // Create a new matrix with swapped dimensions
    std::vector<std::vector<int>> result(cols, std::vector<int>(rows));
    
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            // For 90 degrees clockwise: result[j][rows-1-i] = matrix[i][j]
            result[j][rows - 1 - i] = matrix[i][j];
        }
    }
    
    return result;
}

/**
 * printMatrix - Print a matrix
 * @matrix: The matrix to print
 * 
 * This function prints a matrix in a readable format.
 */
void printMatrix(const std::vector<std::vector<int>>& matrix) {
    for (const auto& row : matrix) {
        for (int val : row) {
            std::cout << val << "\t";
        }
        std::cout << std::endl;
    }
}

int main() {
    // Example: Square matrix
    std::vector<std::vector<int>> matrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    
    std::cout << "Original Matrix:" << std::endl;
    printMatrix(matrix);
    
    // Create a copy for clockwise rotation
    std::vector<std::vector<int>> matrixClockwise = matrix;
    
    // Rotate clockwise in-place
    rotateMatrix90Clockwise(matrixClockwise);
    
    std::cout << "\nRotated 90 degrees clockwise (in-place):" << std::endl;
    printMatrix(matrixClockwise);
    
    // Create a copy for counter-clockwise rotation
    std::vector<std::vector<int>> matrixCounterClockwise = matrix;
    
    // Rotate counter-clockwise in-place
    rotateMatrix90CounterClockwise(matrixCounterClockwise);
    
    std::cout << "\nRotated 90 degrees counter-clockwise (in-place):" << std::endl;
    printMatrix(matrixCounterClockwise);
    
    // Example: Non-square matrix
    std::vector<std::vector<int>> nonSquareMatrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8}
    };
    
    std::cout << "\nNon-Square Matrix:" << std::endl;
    printMatrix(nonSquareMatrix);
    
    // Rotate using a new matrix (works for non-square matrices)
    std::vector<std::vector<int>> rotatedNonSquare = rotateMatrix90ClockwiseNew(nonSquareMatrix);
    
    std::cout << "\nRotated 90 degrees clockwise (new matrix):" << std::endl;
    printMatrix(rotatedNonSquare);
    
    return 0;
}