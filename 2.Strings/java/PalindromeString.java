/**
 * PalindromeString
 * 
 * This class provides methods to check if a string is a palindrome.
 * A palindrome is a string that reads the same backward as forward, ignoring case,
 * spaces, and non-alphanumeric characters.
 * 
 * Two implementations are provided:
 * 1. Two-pointer approach (isPalindrome)
 * 2. StringBuilder reverse approach (isPalindromeUsingStringBuilder)
 * 
 * Time Complexity: O(n) for both methods, where n is the length of the string
 * Space Complexity: 
 * - O(n) for both methods due to the cleaned string creation
 * - The StringBuilder method requires additional O(n) space for the reversed string
 * 
 * Input: A string that may contain any characters
 * Output: Boolean indicating whether the string is a palindrome
 */
public class PalindromeString {
    /**
     * Checks if a string is a palindrome using the two-pointer technique.
     * 
     * Algorithm:
     * 1. Clean the string by removing non-alphanumeric characters and converting to lowercase
     * 2. Initialize two pointers: left at the beginning and right at the end of the string
     * 3. Compare characters at left and right positions and move pointers inward
     * 4. If any characters don't match, return false
     * 5. If all characters match, return true
     * 
     * @param str The input string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleanStr = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        // Initialize two pointers
        int left = 0;
        int right = cleanStr.length() - 1;
        
        // Compare characters from both ends moving inward
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false; // Characters don't match, not a palindrome
            }
            left++;
            right--;
        }
        return true; // All characters matched, it's a palindrome
    }
    
    /**
     * Checks if a string is a palindrome using StringBuilder's reverse method.
     * 
     * Algorithm:
     * 1. Clean the string by removing non-alphanumeric characters and converting to lowercase
     * 2. Create a reversed version of the cleaned string using StringBuilder
     * 3. Compare the original cleaned string with its reversed version
     * 
     * @param str The input string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindromeUsingStringBuilder(String str) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleanStr = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        // Create reversed string using StringBuilder
        String reversed = new StringBuilder(cleanStr).reverse().toString();
        
        // Compare original and reversed strings
        return cleanStr.equals(reversed);
    }
    
    /**
     * Main method to test both palindrome checking implementations with various examples.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test cases with different patterns
        String[] testStrings = {
            "A man, a plan, a canal: Panama", // Palindrome with punctuation and spaces
            "race a car",                    // Not a palindrome
            "Was it a car or a cat I saw?", // Palindrome with punctuation and spaces
            "hello"                         // Not a palindrome
        };
        
        // Test each string with both methods
        for (String str : testStrings) {
            System.out.println("String: " + str);
            System.out.println("Is Palindrome (iterative): " + isPalindrome(str));
            System.out.println("Is Palindrome (StringBuilder): " + isPalindromeUsingStringBuilder(str));
            System.out.println();
        }
    }
}