/**
 * ReverseString
 * 
 * This class provides methods to reverse a string.
 * Two implementations are provided:
 * 1. Using Java's StringBuilder (reverseString)
 * 2. Manual implementation using two-pointer technique (reverseStringManual)
 * 
 * Time Complexity: O(n) for both methods, where n is the length of the string
 * Space Complexity: 
 * - StringBuilder: O(n) for creating a new StringBuilder and the resulting string
 * - Manual: O(n) for creating the character array and the resulting string
 * 
 * Input: A string
 * Output: The reversed string
 */
public class ReverseString {
    /**
     * Reverses a string using Java's StringBuilder class.
     * 
     * Algorithm:
     * 1. Create a new StringBuilder with the input string
     * 2. Use the built-in reverse() method
     * 3. Convert back to a String
     * 
     * @param str The input string to reverse
     * @return The reversed string
     */
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    /**
     * Reverses a string manually using the two-pointer technique.
     * 
     * Algorithm:
     * 1. Convert the string to a character array
     * 2. Initialize two pointers: left at the beginning and right at the end
     * 3. Swap characters at left and right positions
     * 4. Move left pointer forward and right pointer backward
     * 5. Repeat until pointers meet in the middle
     * 6. Create a new string from the modified character array
     * 
     * @param str The input string to reverse
     * @return The reversed string
     */
    public static String reverseStringManual(String str) {
        // Convert string to character array for in-place swapping
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        
        // Swap characters from both ends moving inward
        while (left < right) {
            // Swap characters at left and right positions
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            
            // Move pointers toward the center
            left++;
            right--;
        }
        
        // Create a new string from the modified character array
        return new String(chars);
    }
    
    /**
     * Main method to test both string reversal implementations with examples.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test strings
        String str1 = "Hello, World!";
        String str2 = "Programming";
        
        // Display original strings
        System.out.println("Original strings:");
        System.out.println(str1);
        System.out.println(str2);
        
        // Test StringBuilder implementation
        System.out.println("\nAfter reversal (using StringBuilder):");
        System.out.println(reverseString(str1));
        
        // Test manual implementation
        System.out.println("\nAfter reversal (manual implementation):");
        System.out.println(reverseStringManual(str2));
    }
}