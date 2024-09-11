
import java.util.Scanner;

public class RecursiveTasks {

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Choose a task:");
        System.out.println("1: Count Palindromes");
        System.out.println("2: Find Nth Fibonacci Number");
        System.out.println("3: Convert Snake Case to Camel Case");
        System.out.println("4: Count Unique Consonants");
        System.out.println("5: Convert Binary to Decimal");

        int choice = inputScanner.nextInt();
        inputScanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Enter a string for palindrome count:");
                String palindromeInput = inputScanner.nextLine();
                int palindromeCount = countPalindromicSubstrings(palindromeInput, 0, 0, 0);
                System.out.println("Total unique palindromic substrings: " + palindromeCount);
                break;

            case 2:
                System.out.println("Enter the position for Fibonacci:");
                long fibonacciPosition = inputScanner.nextInt();
                long nthFibonacci = findNthFibonacci(fibonacciPosition);
                System.out.println("Nth Fibonacci number is: " + nthFibonacci);
                break;

            case 3:
              
                break;

            case 4:
                System.out.println("Enter a string to count consonants:");
                String consonantInput = inputScanner.nextLine();
                boolean[] countedConsonants = new boolean[26]; 
                int consonantCount = countUniqueConsonants(consonantInput, 0, countedConsonants);
                System.out.println("Number of unique consonants: " + consonantCount);
                break;
            case 5:
               
                break;

            default:
                System.out.println("Invalid choice.");
                break;
        }

        inputScanner.close();
    }

    // Task 1: Count Palindromic Substrings
    private static int countPalindromicSubstrings(String inputString, int start, int end, int count) {
        if (start == inputString.length()) {
            return count;
        }
        if (end == inputString.length()) {
            return countPalindromicSubstrings(inputString, start + 1, start + 1, count);
        }
        if (isPalindrome(inputString, start, end)) {
            count++;
        }
        return countPalindromicSubstrings(inputString, start, end + 1, count);
    }

    private static boolean isPalindrome(String inputString, int left, int right) {
        if (left >= right) {
            return true;
        }
        if (inputString.charAt(left) != inputString.charAt(right)) {
            return false;
        }
        return isPalindrome(inputString, left + 1, right - 1);
    }

    // Task 2: Find Nth Fibonacci Number
    private static long findNthFibonacci(long n) {
        if (n <= 1) {
            return n;
        }
        return findNthFibonacci(n - 1) + findNthFibonacci(n - 2);
    }

    
    /**
     * Counts the number of unique consonants in a given string.
     *
     * @param inputString       the input string to analyze
     * @param index             the current index being processed
     * @param countedConsonants an array to track consonants
     * @return the total count of unique consonants
     */
    private static int countUniqueConsonants(String inputString, int index, boolean[] countedConsonants) {
        if (index == inputString.length()) {
           
            int count = 0;
            for (boolean isCounted : countedConsonants) {
                if (isCounted) {
                    count++;
                }
            }
            return count;
        }

        char currentChar = inputString.charAt(index);
        if (isConsonant(currentChar)) {
            int charIndex = Character.toLowerCase(currentChar) - 'a';
            countedConsonants[charIndex] = true; 
        }

        return countUniqueConsonants(inputString, index + 1, countedConsonants);
    }

    private static boolean isConsonant(char character) {
        character = Character.toLowerCase(character);
        return (character >= 'a' && character <= 'z')
                && !(character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u');
    }

   
}
