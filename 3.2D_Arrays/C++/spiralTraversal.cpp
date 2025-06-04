/**
 * Spiral Order Matrix Traversal
 * 
 * This program demonstrates how to traverse a matrix in spiral order in C++.
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

#include <iostream>
#include <vector>

/**
 * spiralOrder - Traverse a matrix in spiral order
 * @matrix: The input matrix
 * 
 * This function traverses a matrix in spiral order and returns the elements
 * in a vector.
 * 
 * Returns: A vector containing the elements in spiral order
 */
std::vector<int> spiralOrder(const std::vector<std::vector<int>>& matrix) {
    std::vector<int> result;
    if (matrix.empty()) return result;
    
    int rows = matrix.size();
    int cols = matrix[0].size();
    
    int top = 0, right = cols - 1, bottom = rows - 1, left = 0;
    
    while (top <= bottom && left <= right) {
        // Traverse right
        for (int j = left; j <= right; j++) {
            result.push_back(matrix[top][j]);
        }
        top++;
        
        // Traverse down
        for (int i = top; i <= bottom; i++) {
            result.push_back(matrix[i][right]);
        }
        right--;
        
        // Traverse left (if there are still rows to traverse)
        if (top <= bottom) {
            for (int j = right; j >= left; j--) {
                result.push_back(matrix[bottom][j]);
            }
            bottom--;
        }
        
        // Traverse up (if there are still columns to traverse)
        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                result.push_back(matrix[i][left]);
            }
            left++;
        }
    }
    
    return result;
}

/**
 * printSpiralOrder - Print the elements of a matrix in spiral order
 * @matrix: The input matrix
 * 
 * This function traverses a matrix in spiral order and prints the elements.
 */
void printSpiralOrder(const std::vector<std::vector<int>>& matrix) {
    std::vector<int> result = spiralOrder(matrix);
    
    std::cout << "Spiral Order: ";
    for (int val : result) {
        std::cout << val << " ";
    }
    std::cout << std::endl;
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
    std::vector<std::vector<int>> matrix1 = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9}
    };
    
    std::cout << "Example 1: Square Matrix (3x3)" << std::endl;
    std::cout << "Matrix:" << std::endl;
    printMatrix(matrix1);
    printSpiralOrder(matrix1);
    
    // Example 2: Rectangular matrix (more rows than columns)
    std::vector<std::vector<int>> matrix2 = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {10, 11, 12}
    };
    
    std::cout << "\nExample 2: Rectangular Matrix (4x3)" << std::endl;
    std::cout << "Matrix:" << std::endl;
    printMatrix(matrix2);
    printSpiralOrder(matrix2);
    
    // Example 3: Rectangular matrix (more columns than rows)
    std::vector<std::vector<int>> matrix3 = {
        {1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10}
    };
    
    std::cout << "\nExample 3: Rectangular Matrix (2x5)" << std::endl;
    std::cout << "Matrix:" << std::endl;
    printMatrix(matrix3);
    printSpiralOrder(matrix3);
    
    // Example 4: Single row matrix
    std::vector<std::vector<int>> matrix4 = {
        {1, 2, 3, 4, 5}
    };
    
    std::cout << "\nExample 4: Single Row Matrix (1x5)" << std::endl;
    std::cout << "Matrix:" << std::endl;
    printMatrix(matrix4);
    printSpiralOrder(matrix4);
    
    // Example 5: Single column matrix
    std::vector<std::vector<int>> matrix5 = {
        {1},
        {2},
        {3},
        {4}
    };
    
    std::cout << "\nExample 5: Single Column Matrix (4x1)" << std::endl;
    std::cout << "Matrix:" << std::endl;
    printMatrix(matrix5);
    printSpiralOrder(matrix5);
    
    return 0;
}