// Cristian Rios
// Chpt2 PA

import java.util.Scanner;

public class ReverseString {
    
    /**
     * Recursively reverses a given string.
     * @param str The string to be reversed.
     * @return The reversed string.
     */
    public static String reverseString(String str) {
        // Base case: If the string is empty or has only one character, return it as is.
        if (str.isEmpty()) {
            return str;
        }
        // Recursive case: Reverse the substring excluding the first character
        // and append the first character to the end.
        return reverseString(str.substring(1)) + str.charAt(0);
    }
    
    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);
        String input, result;
        
        // Prompt user for input
        System.out.print("Enter the string to be reversed: ");
        input = scnr.nextLine();
        
        // Call recursive method to reverse the string
        result = reverseString(input);
        
        // Output the reversed string
        System.out.printf("Reversed: %s\n", result);
    }
}