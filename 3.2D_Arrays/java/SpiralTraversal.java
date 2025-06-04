/**
 * Spiral Order Matrix Traversal
 * 
 * This program demonstrates how to traverse a matrix in spiral order in Java.
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

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversal {
    
    /**
     * Traverse a matrix in spiral order
     * 
     * @param matrix The input matrix
     * @return A list containing the elements in spiral order
     */
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        int top = 0, right = cols - 1, bottom = rows - 1, left = 0;
        
        while (top <= bottom && left <= right) {
            // Traverse right
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++;
            
            // Traverse down
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;
            
            // Traverse left (if there are still rows to traverse)
            if (top <= bottom) {
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--;
            }
            
            // Traverse up (if there are still columns to traverse)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return result;
    }
    
    /**
     * Print the elements of a matrix in spiral order
     * 
     * @param matrix The input matrix
     */
    public static void printSpiralOrder(int[][] matrix) {
        List<Integer> result = spiralOrder(matrix);
        
        System.out.print("Spiral Order: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
    
    /**
     * Print a matrix in a readable format
     * 
     * @param matrix The matrix to print
     */
    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        // Example 1: Square matrix
        int[][] matrix1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        
        System.out.println("Example 1: Square Matrix (3x3)");
        System.out.println("Matrix:");
        printMatrix(matrix1);
        printSpiralOrder(matrix1);
        
        // Example 2: Rectangular matrix (more rows than columns)
        int[][] matrix2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12}
        };
        
        System.out.println("\nExample 2: Rectangular Matrix (4x3)");
        System.out.println("Matrix:");
        printMatrix(matrix2);
        printSpiralOrder(matrix2);
        
        // Example 3: Rectangular matrix (more columns than rows)
        int[][] matrix3 = {
            {1, 2, 3, 4, 5},
            {6, 7, 8, 9, 10}
        };
        
        System.out.println("\nExample 3: Rectangular Matrix (2x5)");
        System.out.println("Matrix:");
        printMatrix(matrix3);
        printSpiralOrder(matrix3);
        
        // Example 4: Single row matrix
        int[][] matrix4 = {
            {1, 2, 3, 4, 5}
        };
        
        System.out.println("\nExample 4: Single Row Matrix (1x5)");
        System.out.println("Matrix:");
        printMatrix(matrix4);
        printSpiralOrder(matrix4);
        
        // Example 5: Single column matrix
        int[][] matrix5 = {
            {1},
            {2},
            {3},
            {4}
        };
        
        System.out.println("\nExample 5: Single Column Matrix (4x1)");
        System.out.println("Matrix:");
        printMatrix(matrix5);
        printSpiralOrder(matrix5);
    }
}