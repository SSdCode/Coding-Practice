/**
 * Search an Element in a Sorted Matrix
 * 
 * This program demonstrates how to efficiently search for an element in a matrix
 * that is sorted both row-wise and column-wise in Java.
 * 
 * Algorithm 1 (for row-wise and column-wise sorted matrix):
 * 1. Start from the top-right corner of the matrix
 * 2. If the current element is equal to the target, return its position
 * 3. If the current element is greater than the target, move left (eliminate the current column)
 * 4. If the current element is less than the target, move down (eliminate the current row)
 * 5. Repeat until the element is found or the search space is exhausted
 * 
 * Algorithm 2 (for matrix where each row is sorted and first element of each row is greater than last element of previous row):
 * 1. Treat the matrix as a flattened sorted array
 * 2. Perform binary search on this virtual array
 * 3. Convert the mid index to row and column indices for comparison
 * 
 * Time Complexity: 
 * - Algorithm 1: O(m+n) where m and n are the dimensions of the matrix
 * - Algorithm 2: O(log(m*n)) where m and n are the dimensions of the matrix
 * 
 * Space Complexity: O(1) for both algorithms
 */

public class SearchMatrix {
    
    /**
     * Search for a target value in a matrix that is sorted both row-wise and column-wise.
     * 
     * @param matrix The input sorted matrix
     * @param target The value to search for
     * @return An array containing the row and column indices of the target (if found),
     *         or {-1, -1} if not found
     */
    public static int[] searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        // Start from the top-right corner
        int i = 0;
        int j = cols - 1;
        
        while (i < rows && j >= 0) {
            if (matrix[i][j] == target) {
                // Target found, return its position
                return new int[] {i, j};
            } else if (matrix[i][j] > target) {
                // Current element is greater than target, move left
                j--;
            } else {
                // Current element is less than target, move down
                i++;
            }
        }
        
        // Target not found
        return new int[] {-1, -1};
    }
    
    /**
     * Search for a target value in a sorted matrix using binary search.
     * This works when the matrix has the property that the first element of each row
     * is greater than the last element of the previous row.
     * 
     * @param matrix The input sorted matrix
     * @param target The value to search for
     * @return An array containing the row and column indices of the target (if found),
     *         or {-1, -1} if not found
     */
    public static int[] searchMatrixBinary(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[] {-1, -1};
        }
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
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
                return new int[] {midRow, midCol};
            } else if (matrix[midRow][midCol] < target) {
                // Target is in the right half
                left = mid + 1;
            } else {
                // Target is in the left half
                right = mid - 1;
            }
        }
        
        // Target not found
        return new int[] {-1, -1};
    }
    
    /**
     * Print a matrix in a readable format.
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
        // Example 1: Matrix sorted both row-wise and column-wise
        int[][] matrix1 = {
            {10, 20, 30, 40},
            {15, 25, 35, 45},
            {27, 29, 37, 48},
            {32, 33, 39, 50}
        };
        
        System.out.println("Example 1: Matrix sorted both row-wise and column-wise");
        System.out.println("Matrix:");
        printMatrix(matrix1);
        
        // Test cases for Example 1
        int[] targets1 = {29, 10, 50, 100};
        
        for (int target : targets1) {
            int[] result = searchMatrix(matrix1, target);
            
            if (result[0] != -1 && result[1] != -1) {
                System.out.println("\nTarget " + target + " found at position (" + 
                                   result[0] + ", " + result[1] + ")");
            } else {
                System.out.println("\nTarget " + target + " not found in the matrix");
            }
        }
        
        // Example 2: Matrix where each row is sorted and the first element of each row
        // is greater than the last element of the previous row
        int[][] matrix2 = {
            {1, 3, 5, 7},
            {10, 11, 16, 20},
            {23, 30, 34, 60}
        };
        
        System.out.println("\nExample 2: Matrix where each row is sorted and the first element of each row");
        System.out.println("is greater than the last element of the previous row");
        System.out.println("Matrix:");
        printMatrix(matrix2);
        
        // Test cases for Example 2
        int[] targets2 = {3, 13, 60, 100};
        
        for (int target : targets2) {
            int[] result = searchMatrixBinary(matrix2, target);
            
            if (result[0] != -1 && result[1] != -1) {
                System.out.println("\nTarget " + target + " found at position (" + 
                                   result[0] + ", " + result[1] + ") using binary search");
            } else {
                System.out.println("\nTarget " + target + " not found in the matrix using binary search");
            }
        }
    }
}