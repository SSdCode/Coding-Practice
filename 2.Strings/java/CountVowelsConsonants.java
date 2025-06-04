/**
 * CountVowelsConsonants
 * 
 * This class provides two different methods to count the number of vowels and consonants in a string:
 * 1. Traditional approach using a loop and conditional checks
 * 2. Modern approach using Java Streams and regular expressions
 * 
 * Time Complexity:
 * - Traditional approach: O(n) where n is the length of the string
 * - Streams approach: O(n) where n is the length of the string, but with additional overhead
 *   from stream operations and regex matching
 * 
 * Space Complexity: O(1) for the traditional approach, O(n) for the streams approach due to
 * intermediate stream operations
 * 
 * Input: A string containing letters, numbers, and special characters
 * Output: The count of vowels and consonants in the string
 */
public class CountVowelsConsonants {
    /**
     * Counts the number of vowels and consonants in a string using a traditional approach.
     * 
     * Algorithm:
     * 1. Convert the string to lowercase to handle both upper and lower case letters uniformly
     * 2. Iterate through each character in the string
     * 3. Check if the character is a letter (ignoring numbers, spaces, and special characters)
     * 4. If it's a letter, check if it's a vowel (a, e, i, o, u) or a consonant
     * 5. Increment the appropriate counter
     * 
     * @param str The input string to analyze
     */
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        // Convert to lowercase for case-insensitive comparison
        str = str.toLowerCase();
        
        // Iterate through each character
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            // Only count alphabetic characters
            if (Character.isLetter(ch)) {
                // Check if the character is a vowel
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    // If it's a letter but not a vowel, it's a consonant
                    consonants++;
                }
            }
            // Non-alphabetic characters are ignored
        }
        
        // Display the results
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
    
    /**
     * Counts the number of vowels and consonants in a string using Java Streams and regular expressions.
     * This is a more modern, functional approach but may be less efficient for simple cases.
     * 
     * Algorithm:
     * 1. Define regex patterns for vowels and consonants
     * 2. Convert the string to lowercase
     * 3. Convert the string to a stream of characters
     * 4. Map each character to a string
     * 5. Filter for characters matching the vowel pattern and count them
     * 6. Repeat for consonants
     * 
     * @param str The input string to analyze
     */
    public static void countVowelsAndConsonantsUsingStreams(String str) {
        // Regular expression patterns for vowels and consonants
        String vowelPattern = "[aeiou]";
        String consonantPattern = "[b-df-hj-np-tv-z]"; // All consonants in the English alphabet
        
        // Count vowels using streams
        long vowels = str.toLowerCase().chars()  // Convert to lowercase and get stream of chars
                        .mapToObj(ch -> String.valueOf((char)ch))  // Convert each char to String
                        .filter(ch -> ch.matches(vowelPattern))  // Keep only vowels
                        .count();  // Count the matches
                        
        // Count consonants using streams
        long consonants = str.toLowerCase().chars()
                            .mapToObj(ch -> String.valueOf((char)ch))
                            .filter(ch -> ch.matches(consonantPattern))
                            .count();
        
        // Display the results
        System.out.println("Using Streams:");
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
    
    /**
     * Main method to test the vowel and consonant counting functions with various examples.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Test cases with different types of strings
        String[] testStrings = {
            "Hello World",           // Mixed case with space
            "OpenAI GPT",           // Mixed case with uppercase acronym
            "Programming is fun",    // Longer sentence with spaces
            "Java Streams"           // Another example
        };
        
        // Test each string with both methods
        for (String str : testStrings) {
            System.out.println("\nString: " + str);
            System.out.println("Traditional approach:");
            countVowelsAndConsonants(str);
            countVowelsAndConsonantsUsingStreams(str);
        }
    }
}