/**
 * Matrix Addition
 * 
 * This program demonstrates how to add two matrices in C++.
 * 
 * Time Complexity: O(m×n) where m and n are the dimensions of the matrices
 * Space Complexity: O(m×n) for storing the result matrix
 */

#include <iostream>
#include <vector>

/**
 * addMatrices - Add two matrices and return the result
 * @matrix1: The first input matrix
 * @matrix2: The second input matrix
 * 
 * This function adds corresponding elements of two matrices and returns
 * the result as a new matrix.
 * 
 * Returns: A new matrix containing the sum of the input matrices
 */
std::vector<std::vector<int>> addMatrices(const std::vector<std::vector<int>>& matrix1, 
                                         const std::vector<std::vector<int>>& matrix2) {
    // Check if matrices have the same dimensions
    if (matrix1.size() != matrix2.size() || matrix1[0].size() != matrix2[0].size()) {
        throw std::invalid_argument("Matrices must have the same dimensions for addition");
    }
    
    int rows = matrix1.size();
    int cols = matrix1[0].size();
    
    // Initialize result matrix with zeros
    std::vector<std::vector<int>> result(rows, std::vector<int>(cols, 0));
    
    // Add corresponding elements
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            result[i][j] = matrix1[i][j] + matrix2[i][j];
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
    // Example matrices
    std::vector<std::vector<int>> matrix1 = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    
    std::vector<std::vector<int>> matrix2 = {
        {9, 8, 7},
        {6, 5, 4},
        {3, 2, 1}
    };
    
    std::cout << "Matrix 1:" << std::endl;
    printMatrix(matrix1);
    
    std::cout << "\nMatrix 2:" << std::endl;
    printMatrix(matrix2);
    
    try {
        // Add the matrices
        std::vector<std::vector<int>> result = addMatrices(matrix1, matrix2);
        
        std::cout << "\nResult of Matrix Addition:" << std::endl;
        printMatrix(result);
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }
    
    // Example with matrices of different dimensions
    std::cout << "\nExample with matrices of different dimensions:" << std::endl;
    std::vector<std::vector<int>> matrix3 = {
        {1, 2},
        {3, 4}
    };
    
    std::cout << "Matrix 3 (2x2):" << std::endl;
    printMatrix(matrix3);
    
    try {
        // Try to add matrices of different dimensions
        std::vector<std::vector<int>> result = addMatrices(matrix1, matrix3);
        printMatrix(result);
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }
    
    return 0;
}