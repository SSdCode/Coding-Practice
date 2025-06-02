import java.util.*;

public class RemoveDuplicates {
    // Using LinkedHashSet to maintain order and remove duplicates
    public static String removeDuplicates(String str) {
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        for (char c : str.toCharArray()) {
            set.add(c);
        }
        
        StringBuilder sb = new StringBuilder();
        for (Character c : set) {
            sb.append(c);
        }
        return sb.toString();
    }
    
    // Manual implementation
    public static String removeDuplicatesManual(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if (result.indexOf(String.valueOf(current)) == -1) {
                result.append(current);
            }
        }
        
        return result.toString();
    }
    
    // Using Java 8 Streams
    public static String removeDuplicatesStream(String str) {
        return str.chars()
                 .distinct()
                 .mapToObj(ch -> String.valueOf((char)ch))
                 .reduce("", String::concat);
    }
    
    public static void main(String[] args) {
        String[] testStrings = {
            "programming",
            "hello world",
            "java streams",
            "aabbccdd"
        };
        
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