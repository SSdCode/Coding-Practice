/**
 * Symmetric Matrix Check
 * 
 * This program demonstrates how to check if a matrix is symmetric in C++.
 * A symmetric matrix is a square matrix that is equal to its transpose.
 * 
 * Time Complexity: O(n²) where n is the dimension of the matrix
 * Space Complexity: O(1) as we only need a few variables
 */

#include <iostream>
#include <vector>

/**
 * isSymmetric - Check if a matrix is symmetric
 * @matrix: The input matrix
 * 
 * This function checks if a matrix is symmetric by comparing each element
 * with its corresponding element in the transpose (i.e., matrix[i][j] == matrix[j][i]).
 * 
 * Returns: true if the matrix is symmetric, false otherwise
 */
bool isSymmetric(const std::vector<std::vector<int>>& matrix) {
    // Check if the matrix is empty
    if (matrix.empty()) {
        return true; // Empty matrix is considered symmetric
    }
    
    // Check if the matrix is square
    int size = matrix.size();
    for (const auto& row : matrix) {
        if (row.size() != size) {
            return false; // Not a square matrix
        }
    }
    
    // Check if the matrix is symmetric
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
 * 
 * This function checks if a matrix is symmetric by only comparing elements
 * in the upper triangular part with their corresponding elements in the lower
 * triangular part (i.e., matrix[i][j] == matrix[j][i] for i < j).
 * 
 * Returns: true if the matrix is symmetric, false otherwise
 */
bool isSymmetricOptimized(const std::vector<std::vector<int>>& matrix) {
    // Check if the matrix is empty
    if (matrix.empty()) {
        return true; // Empty matrix is considered symmetric
    }
    
    // Check if the matrix is square
    int size = matrix.size();
    for (const auto& row : matrix) {
        if (row.size() != size) {
            return false; // Not a square matrix
        }
    }
    
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
    // Example 1: Symmetric matrix
    std::vector<std::vector<int>> symmetric = {
        {1, 2, 3},
        {2, 4, 5},
        {3, 5, 6}
    };
    
    std::cout << "Example 1: Symmetric Matrix" << std::endl;
    printMatrix(symmetric);
    
    if (isSymmetric(symmetric)) {
        std::cout << "\nThe matrix is symmetric." << std::endl;
    } else {
        std::cout << "\nThe matrix is not symmetric." << std::endl;
    }
    
    // Example 2: Non-symmetric matrix
    std::vector<std::vector<int>> nonSymmetric = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    
    std::cout << "\nExample 2: Non-symmetric Matrix" << std::endl;
    printMatrix(nonSymmetric);
    
    if (isSymmetricOptimized(nonSymmetric)) {
        std::cout << "\nThe matrix is symmetric." << std::endl;
    } else {
        std::cout << "\nThe matrix is not symmetric." << std::endl;
    }
    
    // Example 3: Another symmetric matrix
    std::vector<std::vector<int>> symmetric2 = {
        {1, 7, 3, 6},
        {7, 4, -5, 9},
        {3, -5, 6, 2},
        {6, 9, 2, 0}
    };
    
    std::cout << "\nExample 3: Another Symmetric Matrix" << std::endl;
    printMatrix(symmetric2);
    
    if (isSymmetric(symmetric2)) {
        std::cout << "\nThe matrix is symmetric." << std::endl;
    } else {
        std::cout << "\nThe matrix is not symmetric." << std::endl;
    }
    
    // Example 4: Non-square matrix
    std::vector<std::vector<int>> nonSquare = {
        {1, 2, 3},
        {4, 5, 6}
    };
    
    std::cout << "\nExample 4: Non-square Matrix" << std::endl;
    printMatrix(nonSquare);
    
    if (isSymmetricOptimized(nonSquare)) {
        std::cout << "\nThe matrix is symmetric." << std::endl;
    } else {
        std::cout << "\nThe matrix is not symmetric." << std::endl;
    }
    
    // Performance comparison
    std::cout << "\nPerformance Comparison:" << std::endl;
    std::cout << "For large matrices, the optimized version is more efficient" << std::endl;
    std::cout << "as it only checks the upper triangular part." << std::endl;
    
    return 0;
}