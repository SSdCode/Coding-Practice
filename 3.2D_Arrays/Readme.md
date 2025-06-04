# 2D Arrays & Matrix Operations

This section contains implementations of common 2D array and matrix operations in multiple programming languages (C, C++, Java, and Kotlin).

## Problems

### 1. Transpose of a Matrix
- **Description**: Convert rows of a matrix into columns and vice versa
- **Time Complexity**: O(n²) where n is the dimension of the matrix
- **Space Complexity**: O(1) for in-place transpose (square matrix) or O(n²) for non-square matrices
- **Implementations**: [C](./C/transposeMatrix.c) | [C++](./C++/transposeMatrix.cpp) | [Java](./java/TransposeMatrix.java) | [Kotlin](./Kotlin/TransposeMatrix.kt)

### 2. Rotate a Matrix by 90 Degrees
- **Description**: Rotate the matrix clockwise by 90 degrees
- **Time Complexity**: O(n²) where n is the dimension of the matrix
- **Space Complexity**: O(1) for in-place rotation
- **Approach**: Transpose the matrix and then reverse each row (for clockwise rotation)
- **Implementations**: [C](./C/rotateMatrix.c) | [C++](./C++/rotateMatrix.cpp) | [Java](./java/RotateMatrix.java) | [Kotlin](./Kotlin/RotateMatrix.kt)

### 3. Spiral Order Matrix Traversal
- **Description**: Print the matrix elements in spiral order (outside to inside)
- **Time Complexity**: O(m×n) where m and n are the dimensions of the matrix
- **Space Complexity**: O(1) for the traversal (O(m×n) if storing the result)
- **Implementations**: [C](./C/spiralTraversal.c) | [C++](./C++/spiralTraversal.cpp) | [Java](./java/SpiralTraversal.java) | [Kotlin](./Kotlin/SpiralTraversal.kt)

### 4. Search an Element in a Sorted Matrix
- **Description**: Efficiently search for an element in a matrix sorted both row-wise and column-wise
- **Time Complexity**: O(m+n) where m and n are the dimensions of the matrix
- **Space Complexity**: O(1)
- **Approach**: Start from top-right (or bottom-left) corner and eliminate rows/columns
- **Implementations**: [C](./C/searchMatrix.c) | [C++](./C++/searchMatrix.cpp) | [Java](./java/SearchMatrix.java) | [Kotlin](./Kotlin/SearchMatrix.kt)

### 5. Matrix Addition
- **Description**: Add corresponding elements of two matrices
- **Time Complexity**: O(m×n) where m and n are the dimensions of the matrices
- **Space Complexity**: O(m×n) for storing the result matrix
- **Implementations**: [C](./C/matrixAddition.c) | [C++](./C++/matrixAddition.cpp) | [Java](./java/MatrixAddition.java) | [Kotlin](./Kotlin/MatrixAddition.kt)

### 6. Matrix Multiplication
- **Description**: Multiply two matrices following the rules of matrix multiplication
- **Time Complexity**: O(n³) for the standard algorithm
- **Space Complexity**: O(m×n) for storing the result matrix
- **Implementations**: [C](./C/matrixMultiplication.c) | [C++](./C++/matrixMultiplication.cpp) | [Java](./java/MatrixMultiplication.java) | [Kotlin](./Kotlin/MatrixMultiplication.kt)

### 7. Symmetric Matrix Check
- **Description**: Check if a matrix is symmetric (equal to its transpose)
- **Time Complexity**: O(n²) where n is the dimension of the matrix
- **Space Complexity**: O(1) as we only need a few variables
- **Implementations**: [C](./C/symmetricMatrix.c) | [C++](./C++/symmetricMatrix.cpp) | [Java](./java/SymmetricMatrix.java) | [Kotlin](./Kotlin/SymmetricMatrix.kt)

### 8. Set Matrix Zeroes (Leetcode 73)
- **Description**: If an element is 0, set its entire row and column to 0
- **Time Complexity**: O(m×n) where m and n are the dimensions of the matrix
- **Space Complexity**: O(1) using the first row and column as markers

## Implementation Languages
- [C Implementations](./C/)
- [C++ Implementations](./C++/)
- [Java Implementations](./java/)
- [Kotlin Implementations](./Kotlin/)