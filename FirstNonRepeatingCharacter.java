import java.util.*;

public class FirstNonRepeatingCharacter {
    
    /**
     * Approach 1: Using HashMap to count character frequencies
     * Time Complexity: O(n)
     * Space Complexity: O(k) where k is the number of unique characters
     */
    public static char findFirstNonRepeatingHashMap(String str) {
        if (str == null || str.length() == 0) {
            return '\0'; // Return null character if string is empty
        }
        
        // Count frequency of each character
        Map<Character, Integer> charCount = new HashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Find the first character with frequency 1
        for (char c : str.toCharArray()) {
            if (charCount.get(c) == 1) {
                return c;
            }
        }
        
        return '\0'; // Return null character if no non-repeating character found
    }
    
    /**
     * Approach 2: Using array for ASCII characters (more efficient for ASCII strings)
     * Time Complexity: O(n)
     * Space Complexity: O(1) - fixed size array of 256
     */
    public static char findFirstNonRepeatingArray(String str) {
        if (str == null || str.length() == 0) {
            return '\0';
        }
        
        // Array to store frequency of ASCII characters (0-255)
        int[] charCount = new int[256];
        
        // Count frequency of each character
        for (char c : str.toCharArray()) {
            charCount[c]++;
        }
        
        // Find the first character with frequency 1
        for (char c : str.toCharArray()) {
            if (charCount[c] == 1) {
                return c;
            }
        }
        
        return '\0'; // Return null character if no non-repeating character found
    }
    
    /**
     * Approach 3: Using LinkedHashMap to maintain insertion order
     * Time Complexity: O(n)
     * Space Complexity: O(k) where k is the number of unique characters
     */
    public static char findFirstNonRepeatingLinkedHashMap(String str) {
        if (str == null || str.length() == 0) {
            return '\0';
        }
        
        // LinkedHashMap maintains insertion order
        Map<Character, Integer> charCount = new LinkedHashMap<>();
        for (char c : str.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }
        
        // Find the first character with frequency 1
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        
        return '\0';
    }
    
    /**
     * Helper method to format output
     */
    public static String formatResult(char result) {
        return result == '\0' ? "No non-repeating character found" : "\"" + result + "\"";
    }
    
    /**
     * Test method to verify all approaches
     */
    public static void testSolution(String input, String methodName) {
        System.out.println("\n" + methodName + ":");
        System.out.println("Input: \"" + input + "\"");
        
        char result1 = findFirstNonRepeatingHashMap(input);
        char result2 = findFirstNonRepeatingArray(input);
        char result3 = findFirstNonRepeatingLinkedHashMap(input);
        
        System.out.println("HashMap approach: " + formatResult(result1));
        System.out.println("Array approach: " + formatResult(result2));
        System.out.println("LinkedHashMap approach: " + formatResult(result3));
        
        // Verify all methods return the same result
        if (result1 == result2 && result2 == result3) {
            System.out.println("✓ All approaches agree");
        } else {
            System.out.println("✗ Results differ - check implementation");
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== First Non-Repeating Character Finder ===");
        
        // Test cases
        String[] testCases = {
            "aabbcde",     // Expected: 'c'
            "abcdef",      // Expected: 'a'
            "aabbcc",      // Expected: no non-repeating character
            "abccba",      // Expected: no non-repeating character
            "abcabc",      // Expected: no non-repeating character
            "racecar",     // Expected: 'e'
            "hello",       // Expected: 'h'
            "programming", // Expected: 'p'
            "a",           // Expected: 'a'
            "",            // Expected: no non-repeating character
            "aab"          // Expected: 'b'
        };
        
        for (int i = 0; i < testCases.length; i++) {
            testSolution(testCases[i], "Test Case " + (i + 1));
        }
        
        // Demonstrate with the specific example from the problem
        System.out.println("\n" + "=".repeat(50));
        System.out.println("PROBLEM EXAMPLE:");
        String example = "aabbcde";
        char result = findFirstNonRepeatingHashMap(example);
        System.out.println("Input: \"" + example + "\" → Output: " + formatResult(result));
    }
}