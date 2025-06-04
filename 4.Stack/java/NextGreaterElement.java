/**
 * Next Greater Element using Stack in Java
 * 
 * This program demonstrates how to find the next greater element for each element
 * in an array using a stack. For each element, the next greater element is the first
 * greater element to its right. If there is no greater element, the result is -1.
 * 
 * Time Complexity: O(n) where n is the size of the array
 * Space Complexity: O(n) for the stack and result array
 */

package java;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    
    /**
     * Find the next greater element for each element in the array
     * (Processing from right to left)
     * 
     * @param arr The input array
     * @return An array containing the next greater element for each element
     */
    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize with -1 (no greater element)
        
        Stack<Integer> stack = new Stack<>(); // Stack to store elements
        
        // Process all elements from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Remove elements from stack that are smaller than or equal to current element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            // If stack is not empty, the top element is the next greater element
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            
            // Push current element to stack
            stack.push(arr[i]);
        }
        
        return result;
    }
    
    /**
     * Find the next greater element for each element in the array
     * (Processing from left to right)
     * 
     * @param arr The input array
     * @return An array containing the next greater element for each element
     */
    public static int[] nextGreaterElementLeftToRight(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize with -1 (no greater element)
        
        Stack<Integer> stack = new Stack<>(); // Stack to store indices
        
        // Process all elements from left to right
        for (int i = 0; i < n; i++) {
            // Remove indices from stack whose elements are smaller than current element
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                // For each popped index, the current element is the next greater element
                result[stack.pop()] = arr[i];
            }
            
            // Push current index to stack
            stack.push(i);
        }
        
        return result;
    }
    
    /**
     * Print an array with its next greater elements
     * 
     * @param arr The original array
     * @param nge The array of next greater elements
     * @param title The title for the output
     */
    public static void printNextGreaterElements(int[] arr, int[] nge, String title) {
        System.out.println(title);
        System.out.println("Element\tNGE");
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i] + "\t" + nge[i]);
        }
        System.out.println();
    }
    
    /**
     * Main method to demonstrate the next greater element algorithms
     */
    public static void main(String[] args) {
        System.out.println("Next Greater Element using Stack in Java");
        System.out.println("---------------------------------------");
        
        // Example 1: Basic array
        int[] arr1 = {4, 5, 2, 25, 7, 8};
        System.out.println("\nExample 1: Basic array");
        System.out.print("Array: ");
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int[] result1 = nextGreaterElement(arr1);
        printNextGreaterElements(arr1, result1, "\nRight to Left Approach:");
        
        int[] result1Alt = nextGreaterElementLeftToRight(arr1);
        printNextGreaterElements(arr1, result1Alt, "Left to Right Approach:");
        
        // Example 2: Array with duplicates
        int[] arr2 = {11, 13, 21, 3, 4, 3, 21, 34};
        System.out.println("\nExample 2: Array with duplicates");
        System.out.print("Array: ");
        for (int num : arr2) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int[] result2 = nextGreaterElement(arr2);
        printNextGreaterElements(arr2, result2, "\nRight to Left Approach:");
        
        int[] result2Alt = nextGreaterElementLeftToRight(arr2);
        printNextGreaterElements(arr2, result2Alt, "Left to Right Approach:");
        
        // Example 3: Array in descending order (worst case)
        int[] arr3 = {5, 4, 3, 2, 1};
        System.out.println("\nExample 3: Array in descending order (worst case)");
        System.out.print("Array: ");
        for (int num : arr3) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int[] result3 = nextGreaterElement(arr3);
        printNextGreaterElements(arr3, result3, "\nRight to Left Approach:");
        
        int[] result3Alt = nextGreaterElementLeftToRight(arr3);
        printNextGreaterElements(arr3, result3Alt, "Left to Right Approach:");
        
        // Example 4: Array in ascending order
        int[] arr4 = {1, 2, 3, 4, 5};
        System.out.println("\nExample 4: Array in ascending order");
        System.out.print("Array: ");
        for (int num : arr4) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int[] result4 = nextGreaterElement(arr4);
        printNextGreaterElements(arr4, result4, "\nRight to Left Approach:");
        
        int[] result4Alt = nextGreaterElementLeftToRight(arr4);
        printNextGreaterElements(arr4, result4Alt, "Left to Right Approach:");
        
        // Example 5: Array with a single element
        int[] arr5 = {10};
        System.out.println("\nExample 5: Array with a single element");
        System.out.print("Array: ");
        for (int num : arr5) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int[] result5 = nextGreaterElement(arr5);
        printNextGreaterElements(arr5, result5, "\nRight to Left Approach:");
        
        int[] result5Alt = nextGreaterElementLeftToRight(arr5);
        printNextGreaterElements(arr5, result5Alt, "Left to Right Approach:");
        
        // Performance comparison note
        System.out.println("\nPerformance Note:");
        System.out.println("Both approaches have the same time complexity O(n) and space complexity O(n).");
        System.out.println("The Left to Right approach might be more intuitive for some problems.");
        System.out.println("The Right to Left approach can be more concise for certain implementations.");
    }
}