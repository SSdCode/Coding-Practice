import java.util.*;

/**
 * LongestCommonPrefix
 * 
 * This class provides three different algorithms to find the longest common prefix among an array of strings:
 * 1. Horizontal scanning - Compare prefixes across strings one by one
 * 2. Vertical scanning - Compare characters at the same position across all strings
 * 3. Sorting approach - Sort the array and compare only the first and last strings
 * 
 * Time Complexity:
 * - Horizontal scanning: O(S) where S is the sum of all characters in all strings
 * - Vertical scanning: O(S) but can terminate early in the best case
 * - Sorting approach: O(n log n * m) where n is the number of strings and m is the maximum string length
 * 
 * Space Complexity:
 * - Horizontal scanning: O(1) constant extra space
 * - Vertical scanning: O(1) constant extra space
 * - Sorting approach: O(1) extra space (not counting the space used by the sorting algorithm)
 * 
 * Input: An array of strings
 * Output: The longest common prefix string
 */
public class LongestCommonPrefix {
    /**
     * Find the longest common prefix using the horizontal scanning approach.
     * 
     * Algorithm:
     * 1. Take the first string as the initial prefix
     * 2. Iterate through the remaining strings
     * 3. For each string, check if it starts with the current prefix
     * 4. If not, shorten the prefix by one character at a time until it matches
     * 5. If the prefix becomes empty, return an empty string
     * 
     * @param strs Array of strings to find common prefix
     * @return The longest common prefix string
     */
    public static String longestCommonPrefix(String[] strs) {
        // Handle edge cases
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Start with the first string as the prefix
        String prefix = strs[0];
        
        // Check each string against the current prefix
        for (int i = 1; i < strs.length; i++) {
            // While the current string doesn't start with the prefix
            while (strs[i].indexOf(prefix) != 0) {
                // Shorten the prefix by one character
                prefix = prefix.substring(0, prefix.length() - 1);
                // If we've shortened to nothing, there's no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
    
    /**
     * Find the longest common prefix using the vertical scanning approach.
     * 
     * Algorithm:
     * 1. Scan characters from left to right for each position
     * 2. Compare the character at the current position across all strings
     * 3. If any string is too short or has a different character, return the prefix so far
     * 4. Otherwise, continue to the next position
     * 
     * This approach can be more efficient when the common prefix is short
     * or when the array contains a very short string.
     * 
     * @param strs Array of strings to find common prefix
     * @return The longest common prefix string
     */
    public static String longestCommonPrefixVertical(String[] strs) {
        // Handle edge cases
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Scan each character position
        for (int i = 0; i < strs[0].length(); i++) {
            // Get the character at the current position in the first string
            char c = strs[0].charAt(i);
            
            // Compare with the same position in all other strings
            for (int j = 1; j < strs.length; j++) {
                // If we've reached the end of any string or found a different character
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    // Return the prefix up to but not including the current position
                    return strs[0].substring(0, i);
                }
            }
        }
        
        // If we've checked all positions in the first string without finding differences
        return strs[0];
    }
    
    /**
     * Find the longest common prefix using the sorting approach.
     * 
     * Algorithm:
     * 1. Sort the array of strings lexicographically
     * 2. After sorting, the first and last strings will have the least in common
     * 3. Compare these two strings to find their common prefix
     * 
     * This approach leverages the fact that after sorting, the common prefix
     * of all strings will be the same as the common prefix of the first and last strings.
     * 
     * @param strs Array of strings to find common prefix
     * @return The longest common prefix string
     */
    public static String longestCommonPrefixSorting(String[] strs) {
        // Handle edge cases
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Sort the array lexicographically
        Arrays.sort(strs);
        
        // Get the first and last strings
        String first = strs[0];
        String last = strs[strs.length - 1];
        
        // Find the common prefix between the first and last strings
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        
        // Return the common prefix
        return first.substring(0, i);
    }
    
    /**
     * Main method to test the three prefix finding algorithms with various examples.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test cases with different patterns
        String[][] testCases = {
            {"flower", "flow", "flight"},       // Common prefix: "fl"
            {"dog", "racecar", "car"},         // No common prefix
            {"interspecies", "interstellar", "interstate"}, // Common prefix: "inters"
            {"throne", "throne"},             // Identical strings
            {}                                // Empty array
        };
        
        // Test each case with all three algorithms
        for (String[] testCase : testCases) {
            System.out.println("\nTest case: " + Arrays.toString(testCase));
            System.out.println("Horizontal scanning: " + longestCommonPrefix(testCase));
            System.out.println("Vertical scanning: " + longestCommonPrefixVertical(testCase));
            System.out.println("Using sorting: " + longestCommonPrefixSorting(testCase));
        }
    }
}