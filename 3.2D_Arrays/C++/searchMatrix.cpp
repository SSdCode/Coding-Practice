/**
 * Search an Element in a Sorted Matrix
 * 
 * This program demonstrates how to efficiently search for an element in a matrix
 * that is sorted both row-wise and column-wise in C++.
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

#include <iostream>
#include <vector>
#include <utility> // for std::pair

/**
 * searchMatrix - Search for a target value in a sorted matrix
 * @matrix: The input sorted matrix
 * @target: The value to search for
 * 
 * This function searches for a target value in a matrix that is sorted
 * both row-wise and column-wise. It starts from the top-right corner
 * and eliminates rows or columns based on the comparison with the target.
 * 
 * Returns: A pair containing the row and column indices of the target (if found),
 *          or (-1, -1) if not found
 */
std::pair<int, int> searchMatrix(const std::vector<std::vector<int>>& matrix, int target) {
    if (matrix.empty() || matrix[0].empty()) {
        return {-1, -1};
    }
    
    int rows = matrix.size();
    int cols = matrix[0].size();
    
    // Start from the top-right corner
    int i = 0;
    int j = cols - 1;
    
    while (i < rows && j >= 0) {
        if (matrix[i][j] == target) {
            // Target found, return its position
            return {i, j};
        } else if (matrix[i][j] > target) {
            // Current element is greater than target, move left
            j--;
        } else {
            // Current element is less than target, move down
            i++;
        }
    }
    
    // Target not found
    return {-1, -1};
}

/**
 * searchMatrixBinary - Search for a target value in a sorted matrix using binary search
 * @matrix: The input sorted matrix where the first element of each row is greater than
 *          the last element of the previous row (i.e., it can be flattened into a sorted array)
 * @target: The value to search for
 * 
 * This function treats the matrix as a flattened sorted array and performs binary search.
 * This approach works when the matrix has the property that the first element of each row
 * is greater than the last element of the previous row.
 * 
 * Returns: A pair containing the row and column indices of the target (if found),
 *          or (-1, -1) if not found
 */
std::pair<int, int> searchMatrixBinary(const std::vector<std::vector<int>>& matrix, int target) {
    if (matrix.empty() || matrix[0].empty()) {
        return {-1, -1};
    }
    
    int rows = matrix.size();
    int cols = matrix[0].size();
    
    // Treat the matrix as a flattened sorted array
    int left = 0;
    int right = rows * cols - 1;
    
    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        // Convert mid index to row and column indices
        int midRow = mid / cols;
        int midCol = mid % cols;
        
        if (matrix[midRow][midCol] == target) {
            // Target found, return its position
            return {midRow, midCol};
        } else if (matrix[midRow][midCol] < target) {
            // Target is in the right half
            left = mid + 1;
        } else {
            // Target is in the left half
            right = mid - 1;
        }
    }
    
    // Target not found
    return {-1, -1};
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
    // Example 1: Matrix sorted both row-wise and column-wise
    std::vector<std::vector<int>> matrix1 = {
        {10, 20, 30, 40},
        {15, 25, 35, 45},
        {27, 29, 37, 48},
        {32, 33, 39, 50}
    };
    
    std::cout << "Example 1: Matrix sorted both row-wise and column-wise" << std::endl;
    std::cout << "Matrix:" << std::endl;
    printMatrix(matrix1);
    
    // Test cases for Example 1
    std::vector<int> targets1 = {29, 10, 50, 100};
    
    for (int target : targets1) {
        auto [row, col] = searchMatrix(matrix1, target);
        
        if (row != -1 && col != -1) {
            std::cout << "\nTarget " << target << " found at position (" << row << ", " << col << ")" << std::endl;
        } else {
            std::cout << "\nTarget " << target << " not found in the matrix" << std::endl;
        }
    }
    
    // Example 2: Matrix where each row is sorted and the first element of each row
    // is greater than the last element of the previous row
    std::vector<std::vector<int>> matrix2 = {
        {1, 3, 5, 7},
        {10, 11, 16, 20},
        {23, 30, 34, 60}
    };
    
    std::cout << "\nExample 2: Matrix where each row is sorted and the first element of each row" << std::endl;
    std::cout << "is greater than the last element of the previous row" << std::endl;
    std::cout << "Matrix:" << std::endl;
    printMatrix(matrix2);
    
    // Test cases for Example 2
    std::vector<int> targets2 = {3, 13, 60, 100};
    
    for (int target : targets2) {
        auto [row, col] = searchMatrixBinary(matrix2, target);
        
        if (row != -1 && col != -1) {
            std::cout << "\nTarget " << target << " found at position (" << row << ", " << col << ") using binary search" << std::endl;
        } else {
            std::cout << "\nTarget " << target << " not found in the matrix using binary search" << std::endl;
        }
    }
    
    return 0;
}