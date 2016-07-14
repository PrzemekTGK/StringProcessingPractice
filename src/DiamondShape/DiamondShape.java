/*
 * String processing practice class written to practice couple of String
 * class's methods. The objective is to take input from user check if the
 * input is a Palindrome while ignoring punctuaction marks and white spaces
 * to perform such check and then to print the user's input text in a diamond
 * shape.
 */
package DiamondShape;

import java.util.Scanner;

/**
 *
 * @author Przemek Stepien
 */
public class DiamondShape {

    public static void main(String[] args) {
        // Take user's input
        System.out.print("Please type in any single word: ");
        Scanner scanText = new Scanner(System.in);
        // Capitalize user's inpout
        String text = scanText.nextLine().toUpperCase();
//        String text = "A man, a plan, a canal: Panama!";

        // Check if user's input is a Palindrome 
        isPalindrome(text);
        // Print user's input as a diamond
        printDiamond(text);
        System.out.println("================================================");
        // Print user's input as a diamond without punctiation and white spaces
        printDiamond(removeNonWordCharachters(text));

    }

    /**
     * This methods checks if user's input is a Palindrome
     * @param text is used to pass user's input into this method
     * @return true if text is Palindrome and false if text is not a Palindrome
     */
    public static boolean isPalindrome(String text) {
        // Palindrome flag, text is assumed to be a palindrome by default
        boolean check = true;
        // Empty String declared to remove punctuation marks and white 
        // spaces for check if text parameter is a Palindrome
        String newText = "";
        // Saving text parameter in newText String without  
        // punctuation marks and white spaces
        for (int i = 0; i < text.length(); i++) {
            if ((text.charAt(i) > 48 && text.charAt(i) < 57)                    // character is a digit or
                    || (text.charAt(i) > 64 && text.charAt(i) < 91)             // character is a capital letter or
                    || (text.charAt(i) > 96 && text.charAt(i) < 123)) {         // character is a lower case letter
                newText += text.charAt(0);
            }
        }
        // Checking if thr text is a palindrome by comparing first character
        // with last character, second character with second last character etc.
        // If one of character pairs is not equal than the flag is set to false
        // and the loop breaks.
        for (int i = 0; i < newText.length(); i++) {
            if (newText.charAt(i) != newText.charAt(newText.length() - (i + 1))) {
                check = false;
                break;
            }
        }
        // Print the check result to the user
        if (check) {
            System.out.println("Text: " + text + " is a Palindrome");
        } else {
            System.out.println("Text: " + text + " is not a Palindrome");
        }

        System.out.println();
        return check;
    }

    /**
     * Prints user's input in diamond shape
     * @param text user's input to be printed
     */
    public static void printDiamond(String text) {
        String space = " ";
        // Print top half of diamond shape including the middle line horizontal
        for (int i = 0; i < text.length(); i++) {
            int index = 0;
            // Print white spaces
            for (int j = 0; j < text.length() - (i + 1); j++) {
                System.out.print(space);
            }
            // Print letters of top left quarter of diamond shape including
            // the middle line vertical
            for (int j = 0; j < i + 1; j++) {
                System.out.print(text.charAt(j));
                index = j - 1;
            }
            // Print top right quarter of the diamond shape excluding the
            // middle line vertical
            for (int j = index; j >= 0; j--) {
                System.out.print(text.charAt(j));
            }
            // Print a new line
            System.out.println("");
        }
        // Print top half of diamond shape excluding the middle line horizontal
        for (int i = text.length() - 2; i >= 0; i--) {
            int index = 0;
            // Print white spaces
            for (int j = 0; j < text.length() - (i + 1); j++) {
                System.out.print(space);
            }
            // Print letters of bottom left quarter of diamond shape including
            // the middle line vertical
            for (int j = 0; j < i + 1; j++) {
                System.out.print(text.charAt(j));
                index = j - 1;
            }
            // Print bottom right quarter of the diamond shape excluding the
            // middle line vertical
            for (int j = index; j >= 0; j--) {
                System.out.print(text.charAt(j));
            }
            // Print a new line
            System.out.println("");
        }
    }

    /**
     * Goes thru the string passed in as parameter, removes anything that's not 
     * a a-z, A-Z or 0-9, saves it into a new string and returns that new string
     * @param text is the string to be modified
     * @return modified string newText
     */
    public static String removeNonWordCharachters(String text) {
        String newText = "";
        for (int i = 0; i < text.length(); i++) {
            if ((text.charAt(i) > 48 && text.charAt(i) < 57)                    // character is a digit or
                    || (text.charAt(i) > 64 && text.charAt(i) < 91)             // character is a capital letter or
                    || (text.charAt(i) > 96 && text.charAt(i) < 123)) {         // character is a lower case letter
                newText += text.charAt(i);
            }
        }
        return newText;
    }
}
