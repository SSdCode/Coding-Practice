public class SubstringSearch {
    // Manual implementation of strstr
    public static int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;
        
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            int j;
            for (j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    break;
                }
            }
            if (j == needle.length()) {
                return i;
            }
        }
        
        return -1;
    }
    
    // Using KMP (Knuth-Morris-Pratt) Algorithm
    public static int strStrKMP(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;
        
        // Build pattern table
        int[] pattern = new int[needle.length()];
        int i = 1, j = 0;
        
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(j)) {
                pattern[i] = j + 1;
                i++;
                j++;
            } else if (j > 0) {
                j = pattern[j - 1];
            } else {
                pattern[i] = 0;
                i++;
            }
        }
        
        // Search
        i = 0;
        j = 0;
        while (i < haystack.length()) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                if (j == needle.length() - 1) {
                    return i - j;
                }
                i++;
                j++;
            } else if (j > 0) {
                j = pattern[j - 1];
            } else {
                i++;
            }
        }
        
        return -1;
    }
    
    // Using Java's built-in method
    public static int strStrBuiltin(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    
    public static void main(String[] args) {
        String[][] testCases = {
            {"hello world", "world"},
            {"aaaaa", "bba"},
            {"mississippi", "issip"},
            {"", ""},
            {"abc", "c"}
        };
        
        for (String[] test : testCases) {
            System.out.println("\nHaystack: \"" + test[0] + "\"");
            System.out.println("Needle: \"" + test[1] + "\"");
            System.out.println("Basic implementation: " + strStr(test[0], test[1]));
            System.out.println("KMP implementation: " + strStrKMP(test[0], test[1]));
            System.out.println("Built-in method: " + strStrBuiltin(test[0], test[1]));
        }
    }
}