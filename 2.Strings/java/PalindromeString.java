public class PalindromeString {
    public static boolean isPalindrome(String str) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleanStr = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        
        int left = 0;
        int right = cleanStr.length() - 1;
        
        while (left < right) {
            if (cleanStr.charAt(left) != cleanStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // Alternative implementation using StringBuilder
    public static boolean isPalindromeUsingStringBuilder(String str) {
        String cleanStr = str.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleanStr).reverse().toString();
        return cleanStr.equals(reversed);
    }
    
    public static void main(String[] args) {
        String[] testStrings = {
            "A man, a plan, a canal: Panama",
            "race a car",
            "Was it a car or a cat I saw?",
            "hello"
        };
        
        for (String str : testStrings) {
            System.out.println("String: " + str);
            System.out.println("Is Palindrome (iterative): " + isPalindrome(str));
            System.out.println("Is Palindrome (StringBuilder): " + isPalindromeUsingStringBuilder(str));
            System.out.println();
        }
    }
}