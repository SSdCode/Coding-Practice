/**
 * Valid Parentheses Problem in Java
 * 
 * This program checks if a string containing parentheses, brackets, and braces
 * is valid. A string is valid if:
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * 
 * Time Complexity: O(n) where n is the length of the string
 * Space Complexity: O(n) in the worst case
 */

package java;

import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class ValidParentheses {
    
    /**
     * Check if a string containing parentheses, brackets, and braces is valid
     * using a HashMap to store matching pairs
     * 
     * @param s The input string
     * @return true if the string is valid, false otherwise
     */
    public static boolean isValid(String s) {
        // If the string is empty, it's valid
        if (s.isEmpty()) {
            return true;
        }
        
        // If the string has odd length, it can't be valid
        if (s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        
        // Map to store matching pairs of brackets
        Map<Character, Character> brackets = new HashMap<>();
        brackets.put(')', '(');
        brackets.put('}', '{');
        brackets.put(']', '[');
        
        for (char c : s.toCharArray()) {
            // If current character is an opening bracket, push it to the stack
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }
            // If current character is a closing bracket
            else if (c == ')' || c == '}' || c == ']') {
                // If stack is empty, there's no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                
                // Check if the top of the stack matches the corresponding opening bracket
                if (stack.pop() != brackets.get(c)) {
                    return false;
                }
            }
        }
        
        // If stack is empty, all brackets are matched
        return stack.isEmpty();
    }
    
    /**
     * Alternative implementation using a switch statement instead of a map
     * 
     * @param s The input string
     * @return true if the string is valid, false otherwise
     */
    public static boolean isValidSwitch(String s) {
        // If the string is empty, it's valid
        if (s.isEmpty()) {
            return true;
        }
        
        // If the string has odd length, it can't be valid
        if (s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(': case '{': case '[':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') return false;
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') return false;
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') return false;
                    break;
                default:
                    // Ignore other characters
                    break;
            }
        }
        
        return stack.isEmpty();
    }
    
    /**
     * Print the result of the validation
     * 
     * @param s The input string
     * @param result The validation result
     */
    public static void printResult(String s, boolean result) {
        System.out.println("Input: \"" + s + "\"");
        System.out.println("Output: " + result);
        System.out.println();
    }
    
    /**
     * Main method to demonstrate the valid parentheses algorithms
     */
    public static void main(String[] args) {
        System.out.println("Valid Parentheses Problem Demonstration in Java");
        System.out.println("--------------------------------------------");
        
        // Test cases
        String[] testCases = {
            "()",           // Valid: simple parentheses
            "()[]{}",       // Valid: different types of brackets
            "(]",           // Invalid: mismatched brackets
            "([)]",         // Invalid: incorrect order
            "{[]}",         // Valid: nested brackets
            "",             // Valid: empty string
            "{",            // Invalid: unclosed bracket
            "{[()]}",       // Valid: complex nesting
            "{[()]()}",     // Valid: multiple valid sequences
            "((()))",       // Valid: multiple same brackets
            "((()",         // Invalid: too many opening brackets
            "()))",         // Invalid: too many closing brackets
            "(hello)",      // Valid: with other characters (ignored)
            "[{()}]"        // Valid: complex nesting
        };
        
        // Test using the map-based implementation
        System.out.println("\nUsing Map-based Implementation:");
        System.out.println("-------------------------------");
        for (String test : testCases) {
            boolean result = isValid(test);
            printResult(test, result);
        }
        
        // Test using the switch-based implementation
        System.out.println("\nUsing Switch-based Implementation:");
        System.out.println("---------------------------------");
        for (String test : testCases) {
            boolean result = isValidSwitch(test);
            printResult(test, result);
        }
        
        // Performance comparison note
        System.out.println("Performance Note:");
        System.out.println("Both implementations have the same time complexity O(n) and space complexity O(n).");
        System.out.println("The switch-based implementation might be slightly faster as it avoids the overhead of HashMap lookups.");
        System.out.println("The map-based implementation is more maintainable and easier to extend if needed.");
        
        // Benchmark the two implementations
        System.out.println("\nBenchmarking the two implementations:");
        String longValidString = generateLongValidString(100000); // Generate a long valid string
        
        // Benchmark map-based implementation
        long startTime = System.nanoTime();
        boolean resultMap = isValid(longValidString);
        long endTime = System.nanoTime();
        long durationMap = (endTime - startTime) / 1000000; // Convert to milliseconds
        
        // Benchmark switch-based implementation
        startTime = System.nanoTime();
        boolean resultSwitch = isValidSwitch(longValidString);
        endTime = System.nanoTime();
        long durationSwitch = (endTime - startTime) / 1000000; // Convert to milliseconds
        
        System.out.println("Map-based implementation: " + durationMap + " ms");
        System.out.println("Switch-based implementation: " + durationSwitch + " ms");
    }
    
    /**
     * Generate a long valid string of parentheses for benchmarking
     * 
     * @param length The approximate length of the string
     * @return A valid string of parentheses
     */
    private static String generateLongValidString(int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length / 2; i++) {
            sb.append("(");
        }
        for (int i = 0; i < length / 2; i++) {
            sb.append(")");
        }
        return sb.toString();
    }
}