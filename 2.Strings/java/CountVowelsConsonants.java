public class CountVowelsConsonants {
    public static void countVowelsAndConsonants(String str) {
        int vowels = 0, consonants = 0;
        str = str.toLowerCase();
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLetter(ch)) {
                if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }
        
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
    
    // Alternative implementation using streams
    public static void countVowelsAndConsonantsUsingStreams(String str) {
        String vowelPattern = "[aeiou]";
        String consonantPattern = "[b-df-hj-np-tv-z]";
        
        long vowels = str.toLowerCase().chars()
                        .mapToObj(ch -> String.valueOf((char)ch))
                        .filter(ch -> ch.matches(vowelPattern))
                        .count();
                        
        long consonants = str.toLowerCase().chars()
                            .mapToObj(ch -> String.valueOf((char)ch))
                            .filter(ch -> ch.matches(consonantPattern))
                            .count();
        
        System.out.println("Using Streams:");
        System.out.println("Vowels: " + vowels);
        System.out.println("Consonants: " + consonants);
    }
    
    public static void main(String[] args) {
        String[] testStrings = {
            "Hello World",
            "OpenAI GPT",
            "Programming is fun",
            "Java Streams"
        };
        
        for (String str : testStrings) {
            System.out.println("\nString: " + str);
            System.out.println("Traditional approach:");
            countVowelsAndConsonants(str);
            countVowelsAndConsonantsUsingStreams(str);
        }
    }
}