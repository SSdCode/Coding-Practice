/**
 * Matrix Multiplication
 * 
 * This program demonstrates how to multiply two matrices in C++.
 * 
 * Time Complexity: O(n³) where n is the dimension of the matrices
 * Space Complexity: O(n²) for storing the result matrix
 */

#include <iostream>
#include <vector>
#include <iomanip> // for std::setw

/**
 * multiplyMatrices - Multiply two matrices and return the result
 * @matrix1: The first input matrix
 * @matrix2: The second input matrix
 * 
 * This function multiplies two matrices and returns the result as a new matrix.
 * For matrix multiplication to be valid, the number of columns in the first matrix
 * must equal the number of rows in the second matrix.
 * 
 * Returns: A new matrix containing the product of the input matrices
 */
std::vector<std::vector<int>> multiplyMatrices(const std::vector<std::vector<int>>& matrix1, 
                                              const std::vector<std::vector<int>>& matrix2) {
    // Check if matrices are empty
    if (matrix1.empty() || matrix2.empty()) {
        throw std::invalid_argument("Matrices cannot be empty");
    }
    
    // Check if multiplication is possible
    if (matrix1[0].size() != matrix2.size()) {
        throw std::invalid_argument("Matrix multiplication not possible. Number of columns in first matrix must equal number of rows in second matrix.");
    }
    
    int rows1 = matrix1.size();
    int cols1 = matrix1[0].size();
    int cols2 = matrix2[0].size();
    
    // Initialize result matrix with zeros
    std::vector<std::vector<int>> result(rows1, std::vector<int>(cols2, 0));
    
    // Multiply matrices
    for (int i = 0; i < rows1; i++) {
        for (int j = 0; j < cols2; j++) {
            for (int k = 0; k < cols1; k++) {
                result[i][j] += matrix1[i][k] * matrix2[k][j];
            }
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
            std::cout << std::setw(4) << val;
        }
        std::cout << std::endl;
    }
}

/**
 * getMatrixDimensions - Get the dimensions of a matrix
 * @matrix: The matrix
 * 
 * Returns: A pair containing the number of rows and columns
 */
std::pair<int, int> getMatrixDimensions(const std::vector<std::vector<int>>& matrix) {
    if (matrix.empty()) {
        return {0, 0};
    }
    return {matrix.size(), matrix[0].size()};
}

int main() {
    // Example matrices
    std::vector<std::vector<int>> matrix1 = {
        {1, 2, 3},
        {4, 5, 6}
    };
    
    std::vector<std::vector<int>> matrix2 = {
        {7, 8},
        {9, 10},
        {11, 12}
    };
    
    auto [rows1, cols1] = getMatrixDimensions(matrix1);
    auto [rows2, cols2] = getMatrixDimensions(matrix2);
    
    std::cout << "Matrix 1 (" << rows1 << "x" << cols1 << "):" << std::endl;
    printMatrix(matrix1);
    
    std::cout << "\nMatrix 2 (" << rows2 << "x" << cols2 << "):" << std::endl;
    printMatrix(matrix2);
    
    try {
        // Multiply the matrices
        std::vector<std::vector<int>> result = multiplyMatrices(matrix1, matrix2);
        
        auto [resultRows, resultCols] = getMatrixDimensions(result);
        std::cout << "\nResult of Matrix Multiplication (" << resultRows << "x" << resultCols << "):" << std::endl;
        printMatrix(result);
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }
    
    // Example 2: Square matrices
    std::vector<std::vector<int>> matrix3 = {
        {1, 2},
        {3, 4}
    };
    
    std::vector<std::vector<int>> matrix4 = {
        {5, 6},
        {7, 8}
    };
    
    auto [rows3, cols3] = getMatrixDimensions(matrix3);
    auto [rows4, cols4] = getMatrixDimensions(matrix4);
    
    std::cout << "\nExample 2: Square Matrices" << std::endl;
    std::cout << "Matrix 3 (" << rows3 << "x" << cols3 << "):" << std::endl;
    printMatrix(matrix3);
    
    std::cout << "\nMatrix 4 (" << rows4 << "x" << cols4 << "):" << std::endl;
    printMatrix(matrix4);
    
    try {
        // Multiply the square matrices
        std::vector<std::vector<int>> result2 = multiplyMatrices(matrix3, matrix4);
        
        auto [resultRows2, resultCols2] = getMatrixDimensions(result2);
        std::cout << "\nResult of Square Matrix Multiplication (" << resultRows2 << "x" << resultCols2 << "):" << std::endl;
        printMatrix(result2);
    } catch (const std::exception& e) {
        std::cerr << "Error: " << e.what() << std::endl;
    }
    
    // Example 3: Invalid multiplication
    std::vector<std::vector<int>> matrix5 = {
        {1, 2},
        {3, 4}
    };
    
    std::vector<std::vector<int>> matrix6 = {
        {5, 6, 7},
        {8, 9, 10},
        {11, 12, 13}
    };
    
    auto [rows5, cols5] = getMatrixDimensions(matrix5);
    auto [rows6, cols6] = getMatrixDimensions(matrix6);
    
    std::cout << "\nExample 3: Invalid Multiplication" << std::endl;
    std::cout << "Matrix 5 (" << rows5 << "x" << cols5 << "):" << std::endl;
    printMatrix(matrix5);
    
    std::cout << "\nMatrix 6 (" << rows6 << "x" << cols6 << "):" << std::endl;
    printMatrix(matrix6);
    
    try {
        // Try to multiply incompatible matrices
        std::vector<std::vector<int>> result3 = multiplyMatrices(matrix5, matrix6);
        printMatrix(result3);
    } catch (const std::exception& e) {
        std::cerr << "\nError: " << e.what() << std::endl;
    }
    
    return 0;
}