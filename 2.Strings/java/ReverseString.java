public class ReverseString {
    // Using StringBuilder
    public static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
    
    // Manual implementation
    public static String reverseStringManual(String str) {
        char[] chars = str.toCharArray();
        int left = 0, right = chars.length - 1;
        
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        
        return new String(chars);
    }
    
    public static void main(String[] args) {
        String str1 = "Hello, World!";
        String str2 = "Programming";
        
        System.out.println("Original strings:");
        System.out.println(str1);
        System.out.println(str2);
        
        System.out.println("\nAfter reversal (using StringBuilder):");
        System.out.println(reverseString(str1));
        
        System.out.println("\nAfter reversal (manual implementation):");
        System.out.println(reverseStringManual(str2));
    }
}