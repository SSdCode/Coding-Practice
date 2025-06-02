#include <iostream>
#include <string>
#include <cctype>

void countVowelsAndConsonants(const std::string& str) {
    int vowels = 0, consonants = 0;
    
    for (char c : str) {
        if (std::isalpha(c)) {
            char ch = std::tolower(c);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else {
                consonants++;
            }
        }
    }
    
    std::cout << "Vowels: " << vowels << "\nConsonants: " << consonants << std::endl;
}

int main() {
    std::string str = "Hello World";
    std::cout << "String: " << str << std::endl;
    countVowelsAndConsonants(str);
    
    str = "OpenAI GPT";
    std::cout << "\nString: " << str << std::endl;
    countVowelsAndConsonants(str);
    
    return 0;
}