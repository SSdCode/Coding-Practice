import java.util.*;

public class LongestCommonPrefix {
    // Horizontal scanning approach
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
    
    // Vertical scanning approach
    public static String longestCommonPrefixVertical(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }
    
    // Using sorting approach
    public static String longestCommonPrefixSorting(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];
        
        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }
        
        return first.substring(0, i);
    }
    
    public static void main(String[] args) {
        String[][] testCases = {
            {"flower", "flow", "flight"},
            {"dog", "racecar", "car"},
            {"interspecies", "interstellar", "interstate"},
            {"throne", "throne"},
            {}
        };
        
        for (String[] testCase : testCases) {
            System.out.println("\nTest case: " + Arrays.toString(testCase));
            System.out.println("Horizontal scanning: " + longestCommonPrefix(testCase));
            System.out.println("Vertical scanning: " + longestCommonPrefixVertical(testCase));
            System.out.println("Using sorting: " + longestCommonPrefixSorting(testCase));
        }
    }
}