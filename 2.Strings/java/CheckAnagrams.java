import java.util.*;

public class CheckAnagrams {
    // Using sorting approach
    public static boolean areAnagrams(String str1, String str2) {
        // Convert to lowercase and remove non-alphanumeric characters
        str1 = str1.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        str2 = str2.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        if (str1.length() != str2.length()) {
            return false;
        }
        
        char[] chars1 = str1.toCharArray();
        char[] chars2 = str2.toCharArray();
        Arrays.sort(chars1);
        Arrays.sort(chars2);
        
        return Arrays.equals(chars1, chars2);
    }
    
    // Using HashMap approach
    public static boolean areAnagramsUsingMap(String str1, String str2) {
        str1 = str1.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        str2 = str2.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        if (str1.length() != str2.length()) {
            return false;
        }
        
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Count characters in first string
        for (char c : str1.toCharArray()) {
            charCount.merge(c, 1, Integer::sum);
        }
        
        // Decrement count for second string
        for (char c : str2.toCharArray()) {
            charCount.merge(c, -1, Integer::sum);
            if (charCount.get(c) < 0) {
                return false;
            }
        }
        
        // Verify all counts are zero
        return charCount.values().stream().allMatch(count -> count == 0);
    }
    
    // Using array frequency count (most efficient for ASCII)
    public static boolean areAnagramsUsingArray(String str1, String str2) {
        str1 = str1.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        str2 = str2.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        if (str1.length() != str2.length()) {
            return false;
        }
        
        int[] charCount = new int[128]; // ASCII
        
        for (int i = 0; i < str1.length(); i++) {
            charCount[str1.charAt(i)]++;
            charCount[str2.charAt(i)]--;
        }
        
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        String[][] testPairs = {
            {"Listen", "Silent"},
            {"Triangle", "Integral"},
            {"Hello", "World"},
            {"A gentleman", "Elegant man"},
            {"Debit card", "Bad credit"}
        };
        
        for (String[] pair : testPairs) {
            System.out.println("\nChecking strings: \"" + pair[0] + "\" and \"" + pair[1] + "\"");
            System.out.println("Using sorting: " + areAnagrams(pair[0], pair[1]));
            System.out.println("Using HashMap: " + areAnagramsUsingMap(pair[0], pair[1]));
            System.out.println("Using array: " + areAnagramsUsingArray(pair[0], pair[1]));
        }
    }
}