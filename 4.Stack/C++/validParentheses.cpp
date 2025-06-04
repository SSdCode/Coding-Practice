/**
 * Valid Parentheses Problem in C++
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

#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
#include <vector>

/**
 * Check if a string containing parentheses, brackets, and braces is valid
 * 
 * @param s The input string
 * @return true if the string is valid, false otherwise
 */
bool isValid(const std::string& s) {
    std::stack<char> stack;
    
    // Map to store matching pairs of brackets
    std::unordered_map<char, char> brackets = {
        {')', '('},
        {'}', '{'},
        {']', '['}
    };
    
    for (char c : s) {
        // If current character is an opening bracket, push it to the stack
        if (c == '(' || c == '{' || c == '[') {
            stack.push(c);
        }
        // If current character is a closing bracket
        else if (c == ')' || c == '}' || c == ']') {
            // If stack is empty, there's no matching opening bracket
            if (stack.empty()) {
                return false;
            }
            
            // Check if the top of the stack matches the corresponding opening bracket
            if (stack.top() != brackets[c]) {
                return false;
            }
            
            // Remove the matching opening bracket from the stack
            stack.pop();
        }
    }
    
    // If stack is empty, all brackets are matched
    return stack.empty();
}

/**
 * Alternative implementation using a switch statement instead of a map
 * 
 * @param s The input string
 * @return true if the string is valid, false otherwise
 */
bool isValidSwitch(const std::string& s) {
    std::stack<char> stack;
    
    for (char c : s) {
        switch (c) {
            case '(': case '{': case '[':
                stack.push(c);
                break;
            case ')':
                if (stack.empty() || stack.top() != '(') return false;
                stack.pop();
                break;
            case '}':
                if (stack.empty() || stack.top() != '{') return false;
                stack.pop();
                break;
            case ']':
                if (stack.empty() || stack.top() != '[') return false;
                stack.pop();
                break;
            default:
                // Ignore other characters
                break;
        }
    }
    
    return stack.empty();
}

/**
 * Print the result of the validation
 * 
 * @param s The input string
 * @param result The validation result
 */
void printResult(const std::string& s, bool result) {
    std::cout << "Input: \"" << s << "\"" << std::endl;
    std::cout << "Output: " << (result ? "true" : "false") << std::endl << std::endl;
}

int main() {
    std::cout << "Valid Parentheses Problem Demonstration in C++" << std::endl;
    std::cout << "--------------------------------------------" << std::endl;
    
    // Test cases
    std::vector<std::string> testCases = {
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
    std::cout << "\nUsing Map-based Implementation:" << std::endl;
    std::cout << "-------------------------------" << std::endl;
    for (const auto& test : testCases) {
        bool result = isValid(test);
        printResult(test, result);
    }
    
    // Test using the switch-based implementation
    std::cout << "\nUsing Switch-based Implementation:" << std::endl;
    std::cout << "---------------------------------" << std::endl;
    for (const auto& test : testCases) {
        bool result = isValidSwitch(test);
        printResult(test, result);
    }
    
    // Performance comparison note
    std::cout << "Performance Note:" << std::endl;
    std::cout << "Both implementations have the same time complexity O(n) and space complexity O(n)." << std::endl;
    std::cout << "The switch-based implementation might be slightly faster as it avoids the overhead of hash map lookups." << std::endl;
    std::cout << "The map-based implementation is more maintainable and easier to extend if needed." << std::endl;
    
    return 0;
}