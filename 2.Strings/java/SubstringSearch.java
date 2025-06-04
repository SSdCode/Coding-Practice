/**
 * SubstringSearch
 * 
 * This class provides methods to search for a substring (needle) within a string (haystack).
 * Three implementations are provided:
 * 1. Brute force approach (strStr)
 * 2. Knuth-Morris-Pratt (KMP) algorithm (strStrKMP)
 * 3. Java's built-in indexOf method (strStrBuiltin)
 * 
 * Time Complexity:
 * - Brute Force: O(m*n) where m is the length of haystack and n is the length of needle
 * - KMP: O(m+n) where m is the length of haystack and n is the length of needle
 * - Built-in: Implementation dependent, but typically optimized
 * 
 * Space Complexity:
 * - Brute Force: O(1) constant extra space
 * - KMP: O(n) for the pattern table where n is the length of needle
 * - Built-in: Implementation dependent
 * 
 * Input: Two strings - haystack (the string to search in) and needle (the substring to search for)
 * Output: The index of the first occurrence of needle in haystack, or -1 if not found
 */
public class SubstringSearch {
    /**
     * Searches for the needle string in the haystack string using a brute force approach.
     * 
     * Algorithm:
     * 1. Handle edge cases (empty needle or needle longer than haystack)
     * 2. For each possible starting position in haystack:
     *    a. Compare characters of haystack and needle
     *    b. If all characters match, return the starting position
     *    c. If any character doesn't match, move to the next position in haystack
     * 3. If no match is found, return -1
     * 
     * @param haystack The string to search in
     * @param needle The substring to search for
     * @return The index of the first occurrence of needle in haystack, or -1 if not found
     */
    public static int strStr(String haystack, String needle) {
        // Handle edge cases
        if (needle.isEmpty()) return 0;  // Empty needle is always found at position 0
        if (needle.length() > haystack.length()) return -1;  // Needle can't be in haystack if it's longer
        
        // Try each possible starting position in haystack
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            // Compare characters of haystack and needle
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;  // Mismatch found, break inner loop
                }
            }
            // If we went through the entire needle without breaking, we found a match
            if (j == needle.length()) {
                return i;  // Return the starting position
            }
        }
        
        return -1;  // No match found
    }
    
    /**
     * Searches for the needle string in the haystack string using the KMP algorithm.
     * KMP (Knuth-Morris-Pratt) uses a pattern table to skip unnecessary comparisons.
     * 
     * Algorithm:
     * 1. Handle edge cases (empty needle or needle longer than haystack)
     * 2. Build the pattern table (also called the "partial match" table)
     *    - This table helps determine how far to shift the pattern when a mismatch occurs
     * 3. Use the pattern table to efficiently search for the needle in the haystack
     * 
     * @param haystack The string to search in
     * @param needle The substring to search for
     * @return The index of the first occurrence of needle in haystack, or -1 if not found
     */
    public static int strStrKMP(String haystack, String needle) {
        // Handle edge cases
        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;
        
        // Build pattern table (partial match table)
        int[] pattern = new int[needle.length()];
        int i = 1, j = 0;
        
        // Compute the pattern table values
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(j)) {
                // Characters match, record length of matching prefix and move both pointers
                pattern[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                // Characters don't match, fall back in the pattern
                j = pattern[j - 1];
            } else {
                // No prefix to fall back to
                pattern[i] = 0;
                i++;
            }
        }
        
        // Search for the pattern in the haystack using the pattern table
        i = 0;  // Index for haystack
        j = 0;  // Index for needle
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                // Characters match
                if (j == needle.length() - 1) {
                    // Reached the end of needle, pattern found
                    return i - j;  // Return starting position
                }
                // Move both pointers
                i++;
                j++;
            } else if (j > 0) {
                // Mismatch after some matches, use pattern table to skip comparisons
                j = pattern[j - 1];
            } else {
                // Mismatch at first character, move to next position in haystack
                i++;
            }
        }
        
        return -1;  // No match found
    }
    
    /**
     * Searches for the needle string in the haystack string using Java's built-in indexOf method.
     * This method leverages Java's optimized implementation.
     * 
     * @param haystack The string to search in
     * @param needle The substring to search for
     * @return The index of the first occurrence of needle in haystack, or -1 if not found
     */
    public static int strStrBuiltin(String haystack, String needle) {
        return haystack.indexOf(needle);  // Use Java's built-in method
    }
    
    /**
     * Main method to test all three substring search implementations with various examples.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test cases with different patterns
        String[][] testCases = {
            {"hello world", "world"},     // Simple case, needle at the end
            {"aaaaa", "bba"},           // Needle not in haystack
            {"mississippi", "issip"},   // Needle in the middle with repeating characters
            {"", ""},                   // Empty strings
            {"abc", "c"}                // Needle at the end, single character
        };
        
        // Test each case with all three methods
        for (String[] test : testCases) {
            System.out.println("\nHaystack: \"" + test[0] + "\"");
            System.out.println("Needle: \"" + test[1] + "\"");
            System.out.println("Basic implementation: " + strStr(test[0], test[1]));
            System.out.println("KMP implementation: " + strStrKMP(test[0], test[1]));
            System.out.println("Built-in method: " + strStrBuiltin(test[0], test[1]));
        }
    }
}