/**
 * Transpose of a Matrix
 * 
 * This program demonstrates how to transpose a matrix in C++.
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

#include <iostream>
#include <vector>

/**
 * transposeSquareMatrix - Transpose a square matrix in-place
 * @matrix: The input square matrix (passed by reference)
 * 
 * This function transposes a square matrix in-place by swapping elements
 * across the main diagonal.
 */
void transposeSquareMatrix(std::vector<std::vector<int>>& matrix) {
    int n = matrix.size();
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            // Swap matrix[i][j] with matrix[j][i]
            std::swap(matrix[i][j], matrix[j][i]);
        }
    }
}

/**
 * transposeMatrix - Transpose a matrix (works for both square and non-square)
 * @matrix: The input matrix
 * 
 * This function creates and returns a new transposed matrix.
 * 
 * Returns: A new matrix that is the transpose of the input matrix
 */
std::vector<std::vector<int>> transposeMatrix(const std::vector<std::vector<int>>& matrix) {
    if (matrix.empty()) return {};
    
    int rows = matrix.size();
    int cols = matrix[0].size();
    
    // Create a new matrix with swapped dimensions
    std::vector<std::vector<int>> result(cols, std::vector<int>(rows));
    
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            result[j][i] = matrix[i][j];
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
    // Example 1: Square matrix
    std::vector<std::vector<int>> squareMatrix = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    
    std::cout << "Example 1: Square Matrix (3x3)" << std::endl;
    std::cout << "Original Matrix:" << std::endl;
    printMatrix(squareMatrix);
    
    // Transpose in-place
    transposeSquareMatrix(squareMatrix);
    
    std::cout << "\nTransposed Matrix (In-place):" << std::endl;
    printMatrix(squareMatrix);
    
    // Example 2: Non-square matrix
    std::vector<std::vector<int>> nonSquareMatrix = {
        {1, 2, 3, 4},
        {5, 6, 7, 8}
    };
    
    std::cout << "\nExample 2: Non-Square Matrix (2x4)" << std::endl;
    std::cout << "Original Matrix:" << std::endl;
    printMatrix(nonSquareMatrix);
    
    // Transpose using a new matrix
    std::vector<std::vector<int>> transposed = transposeMatrix(nonSquareMatrix);
    
    std::cout << "\nTransposed Matrix (4x2):" << std::endl;
    printMatrix(transposed);
    
    return 0;
}