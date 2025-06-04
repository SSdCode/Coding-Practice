import java.util.*;

/**
 * RemoveDuplicates
 * 
 * This class provides methods to remove duplicate characters from a string while
 * preserving the order of the first occurrence of each character.
 * 
 * Three implementations are provided:
 * 1. Using LinkedHashSet (removeDuplicates)
 * 2. Manual implementation using StringBuilder and indexOf (removeDuplicatesManual)
 * 3. Using Java 8 Streams (removeDuplicatesStream)
 * 
 * Time Complexity:
 * - LinkedHashSet: O(n) where n is the length of the string
 * - Manual: O(n²) due to indexOf operation for each character
 * - Streams: O(n) for the distinct operation
 * 
 * Space Complexity: O(n) for all methods as they create new strings
 * 
 * Input: A string with potential duplicate characters
 * Output: A string with duplicates removed, preserving the order of first occurrence
 */
public class RemoveDuplicates {
    /**
     * Removes duplicate characters using LinkedHashSet.
     * 
     * Algorithm:
     * 1. Create a LinkedHashSet to maintain insertion order and uniqueness
     * 2. Add each character from the string to the set
     * 3. Build a new string from the set's elements
     * 
     * @param str The input string
     * @return A string with duplicates removed
     */
    public static String removeDuplicates(String str) {
        // LinkedHashSet maintains insertion order while ensuring uniqueness
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        
        // Add each character to the set (duplicates are automatically ignored)
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        
        // Build the result string from the set
        StringBuilder sb = new StringBuilder();
        for (Character c : set) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    /**
     * Removes duplicate characters manually using StringBuilder and indexOf.
     * 
     * Algorithm:
     * 1. Handle edge cases (null or single character strings)
     * 2. Create a StringBuilder to store the result
     * 3. For each character, check if it already exists in the result
     * 4. If not found, append it to the result
     * 
     * @param str The input string
     * @return A string with duplicates removed
     */
    public static String removeDuplicatesManual(String str) {
        // Handle edge cases
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            // indexOf returns -1 if the character is not found
            if (result.indexOf(String.valueOf(current)) == -1) {
                result.append(current);
            }
        }
        
        return result.toString();
    }
    
    /**
     * Removes duplicate characters using Java 8 Streams.
     * 
     * Algorithm:
     * 1. Convert the string to an IntStream of character codes
     * 2. Use distinct() to remove duplicates
     * 3. Map each integer back to its character representation
     * 4. Concatenate the characters to form the result string
     * 
     * @param str The input string
     * @return A string with duplicates removed
     */
    public static String removeDuplicatesStream(String str) {
        return str.chars()                      // Convert to IntStream
                 .distinct()                    // Remove duplicates
                 .mapToObj(ch -> String.valueOf((char)ch))  // Convert back to String
                 .reduce("", String::concat);  // Concatenate all characters
    }
    
    /**
     * Main method to test all three implementations with various examples.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test cases with different patterns
        String[] testStrings = {
            "programming",    // Multiple duplicates
            "hello world",   // Duplicates with spaces
            "java streams",  // Multiple words
            "aabbccdd"       // Consecutive duplicates
        };
        
        // Test each string with all three methods
        for (String str : testStrings) {
            System.out.println("\nOriginal string: " + str);
            System.out.println("After removing duplicates (Set): " + 
                             removeDuplicates(str));
            System.out.println("After removing duplicates (Manual): " + 
                             removeDuplicatesManual(str));
            System.out.println("After removing duplicates (Stream): " + 
                             removeDuplicatesStream(str));
        }
    }
}