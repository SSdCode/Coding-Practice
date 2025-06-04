import java.util.*;

/**
 * CheckAnagrams
 * 
 * This class provides three different methods to check if two strings are anagrams of each other.
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
 * typically using all the original letters exactly once.
 * 
 * The three approaches implemented are:
 * 1. Sorting approach - Sort both strings and compare
 * 2. HashMap approach - Count character frequencies using a HashMap
 * 3. Array approach - Count character frequencies using an array (most efficient for ASCII)
 * 
 * Time Complexity:
 * - Sorting approach: O(n log n) where n is the length of the strings
 * - HashMap approach: O(n) where n is the length of the strings
 * - Array approach: O(n) where n is the length of the strings
 * 
 * Space Complexity:
 * - Sorting approach: O(n) for the character arrays
 * - HashMap approach: O(k) where k is the number of unique characters
 * - Array approach: O(1) as we use a fixed-size array (128 for ASCII)
 * 
 * Input: Two strings to check if they are anagrams
 * Output: Boolean indicating whether the strings are anagrams
 */
public class CheckAnagrams {
    /**
     * Checks if two strings are anagrams using the sorting approach.
     * 
     * Algorithm:
     * 1. Clean both strings (remove non-alphanumeric characters and convert to lowercase)
     * 2. Check if the lengths are equal (if not, they can't be anagrams)
     * 3. Convert strings to char arrays and sort them
     * 4. Compare the sorted arrays
     * 
     * @param str1 The first string to check
     * @param str2 The second string to check
     * @return true if the strings are anagrams, false otherwise
     */
    public static boolean areAnagrams(String str1, String str2) {
        // Convert to lowercase and remove non-alphanumeric characters
        str1 = str1.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        str2 = str2.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        // Quick check: anagrams must have the same length
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Convert to char arrays, sort, and compare
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return Arrays.equals(chars1, chars2);
    }
    
    /**
     * Checks if two strings are anagrams using a HashMap to count character frequencies.
     * 
     * Algorithm:
     * 1. Clean both strings (remove non-alphanumeric characters and convert to lowercase)
     * 2. Check if the lengths are equal (if not, they can't be anagrams)
     * 3. Use a HashMap to count characters in the first string
     * 4. Decrement counts for characters in the second string
     * 5. If any count becomes negative or any count is non-zero at the end, they're not anagrams
     * 
     * @param str1 The first string to check
     * @param str2 The second string to check
     * @return true if the strings are anagrams, false otherwise
     */
    public static boolean areAnagramsUsingMap(String str1, String str2) {
        // Clean the strings
        str1 = str1.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        str2 = str2.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        // Quick check: anagrams must have the same length
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Use HashMap to track character frequencies
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Count characters in first string (increment)
        for (char c : str1.toCharArray()) {
            charCount.merge(c, 1, Integer::sum);
        }
        
        // Decrement count for second string
        for (char c : str2.toCharArray()) {
            charCount.merge(c, -1, Integer::sum);
            // Early termination if we find more of a character in str2 than in str1
            if (charCount.get(c) < 0) {
                return false;
            }
        }
        
        // Verify all counts are zero (all characters matched)
        return charCount.values().stream().allMatch(count -> count == 0);
    }
    
    /**
     * Checks if two strings are anagrams using an array to count character frequencies.
     * This is the most efficient approach for ASCII characters.
     * 
     * Algorithm:
     * 1. Clean both strings (remove non-alphanumeric characters and convert to lowercase)
     * 2. Check if the lengths are equal (if not, they can't be anagrams)
     * 3. Use an array to track character counts (increment for str1, decrement for str2)
     * 4. Check if all counts are zero at the end
     * 
     * @param str1 The first string to check
     * @param str2 The second string to check
     * @return true if the strings are anagrams, false otherwise
     */
    public static boolean areAnagramsUsingArray(String str1, String str2) {
        // Clean the strings
        str1 = str1.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        str2 = str2.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        // Quick check: anagrams must have the same length
        if (str1.length() != str2.length()) {
            return false;
        }
        
        // Use array for character counting (ASCII)
        int[] charCount = new int[128]; // ASCII character set
        
        // Increment count for str1 chars and decrement for str2 chars in one pass
        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.charAt(i)]++;
            charCount[str2.charAt(i)]--;
        }
        
        // Check if all counts are zero (perfect match)
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    /**
     * Main method to test the anagram checking functions with various examples.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test cases - pairs of strings to check
        String[][] testPairs = {
            {"Listen", "Silent"},           // True - classic anagram
            {"Triangle", "Integral"},      // True - anagram
            {"Hello", "World"},           // False - different letters
            {"A gentleman", "Elegant man"}, // True - anagram with spaces
            {"Debit card", "Bad credit"}   // True - anagram with spaces
        };
        
        // Test each pair with all three methods
        for (String[] pair : testPairs) {
            System.out.println("\nChecking strings: \"" + pair[0] + "\" and \"" + pair[1] + "\"");
            System.out.println("Using sorting: " + areAnagrams(pair[0], pair[1]));
            System.out.println("Using HashMap: " + areAnagramsUsingMap(pair[0], pair[1]));
            System.out.println("Using array: " + areAnagramsUsingArray(pair[0], pair[1]));
        }
    }
}