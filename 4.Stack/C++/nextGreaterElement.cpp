/**
 * Next Greater Element using Stack in C++
 * 
 * This program demonstrates how to find the next greater element for each element
 * in an array using a stack. For each element, the next greater element is the first
 * greater element to its right. If there is no greater element, the result is -1.
 * 
 * Time Complexity: O(n) where n is the size of the array
 * Space Complexity: O(n) for the stack and result array
 */

#include <iostream>
#include <vector>
#include <stack>

/**
 * Find the next greater element for each element in the array
 * (Processing from right to left)
 * 
 * @param arr The input array
 * @return A vector containing the next greater element for each element
 */
std::vector<int> nextGreaterElement(const std::vector<int>& arr) {
    int n = arr.size();
    std::vector<int> result(n, -1); // Initialize with -1 (no greater element)
    std::stack<int> s; // Stack to store elements
    
    // Process all elements from right to left
    for (int i = n - 1; i >= 0; i--) {
        // Remove elements from stack that are smaller than or equal to current element
        while (!s.empty() && s.top() <= arr[i]) {
            s.pop();
        }
        
        // If stack is not empty, the top element is the next greater element
        if (!s.empty()) {
            result[i] = s.top();
        }
        
        // Push current element to stack
        s.push(arr[i]);
    }
    
    return result;
}

/**
 * Find the next greater element for each element in the array
 * (Processing from left to right)
 * 
 * @param arr The input array
 * @return A vector containing the next greater element for each element
 */
std::vector<int> nextGreaterElementLeftToRight(const std::vector<int>& arr) {
    int n = arr.size();
    std::vector<int> result(n, -1); // Initialize with -1 (no greater element)
    std::stack<int> s; // Stack to store indices
    
    // Process all elements from left to right
    for (int i = 0; i < n; i++) {
        // Remove indices from stack whose elements are smaller than current element
        while (!s.empty() && arr[s.top()] < arr[i]) {
            // For each popped index, the current element is the next greater element
            result[s.top()] = arr[i];
            s.pop();
        }
        
        // Push current index to stack
        s.push(i);
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
void printNextGreaterElements(const std::vector<int>& arr, const std::vector<int>& nge, const std::string& title) {
    std::cout << title << std::endl;
    std::cout << "Element\tNGE" << std::endl;
    for (size_t i = 0; i < arr.size(); i++) {
        std::cout << arr[i] << "\t" << nge[i] << std::endl;
    }
    std::cout << std::endl;
}

int main() {
    std::cout << "Next Greater Element using Stack in C++" << std::endl;
    std::cout << "---------------------------------------" << std::endl;
    
    // Example 1: Basic array
    std::vector<int> arr1 = {4, 5, 2, 25, 7, 8};
    std::cout << "\nExample 1: Basic array" << std::endl;
    std::cout << "Array: ";
    for (int num : arr1) {
        std::cout << num << " ";
    }
    std::cout << std::endl;
    
    std::vector<int> result1 = nextGreaterElement(arr1);
    printNextGreaterElements(arr1, result1, "\nRight to Left Approach:");
    
    std::vector<int> result1Alt = nextGreaterElementLeftToRight(arr1);
    printNextGreaterElements(arr1, result1Alt, "Left to Right Approach:");
    
    // Example 2: Array with duplicates
    std::vector<int> arr2 = {11, 13, 21, 3, 4, 3, 21, 34};
    std::cout << "\nExample 2: Array with duplicates" << std::endl;
    std::cout << "Array: ";
    for (int num : arr2) {
        std::cout << num << " ";
    }
    std::cout << std::endl;
    
    std::vector<int> result2 = nextGreaterElement(arr2);
    printNextGreaterElements(arr2, result2, "\nRight to Left Approach:");
    
    std::vector<int> result2Alt = nextGreaterElementLeftToRight(arr2);
    printNextGreaterElements(arr2, result2Alt, "Left to Right Approach:");
    
    // Example 3: Array in descending order (worst case)
    std::vector<int> arr3 = {5, 4, 3, 2, 1};
    std::cout << "\nExample 3: Array in descending order (worst case)" << std::endl;
    std::cout << "Array: ";
    for (int num : arr3) {
        std::cout << num << " ";
    }
    std::cout << std::endl;
    
    std::vector<int> result3 = nextGreaterElement(arr3);
    printNextGreaterElements(arr3, result3, "\nRight to Left Approach:");
    
    std::vector<int> result3Alt = nextGreaterElementLeftToRight(arr3);
    printNextGreaterElements(arr3, result3Alt, "Left to Right Approach:");
    
    // Example 4: Array in ascending order
    std::vector<int> arr4 = {1, 2, 3, 4, 5};
    std::cout << "\nExample 4: Array in ascending order" << std::endl;
    std::cout << "Array: ";
    for (int num : arr4) {
        std::cout << num << " ";
    }
    std::cout << std::endl;
    
    std::vector<int> result4 = nextGreaterElement(arr4);
    printNextGreaterElements(arr4, result4, "\nRight to Left Approach:");
    
    std::vector<int> result4Alt = nextGreaterElementLeftToRight(arr4);
    printNextGreaterElements(arr4, result4Alt, "Left to Right Approach:");
    
    // Example 5: Array with a single element
    std::vector<int> arr5 = {10};
    std::cout << "\nExample 5: Array with a single element" << std::endl;
    std::cout << "Array: ";
    for (int num : arr5) {
        std::cout << num << " ";
    }
    std::cout << std::endl;
    
    std::vector<int> result5 = nextGreaterElement(arr5);
    printNextGreaterElements(arr5, result5, "\nRight to Left Approach:");
    
    std::vector<int> result5Alt = nextGreaterElementLeftToRight(arr5);
    printNextGreaterElements(arr5, result5Alt, "Left to Right Approach:");
    
    // Performance comparison note
    std::cout << "\nPerformance Note:" << std::endl;
    std::cout << "Both approaches have the same time complexity O(n) and space complexity O(n)." << std::endl;
    std::cout << "The Left to Right approach might be more intuitive for some problems." << std::endl;
    std::cout << "The Right to Left approach can be more concise for certain implementations." << std::endl;
    
    return 0;
}