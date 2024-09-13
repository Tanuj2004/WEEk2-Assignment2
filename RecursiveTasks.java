/**
 * RecursiveTasks
 *
 * This class includes methods to perform recursive tasks such as counting palindromes,
 * finding Fibonacci numbers, converting strings between cases, and more.
 *
 * Owner: Tanuj Yadav
 * Date: 11/09/2024
 */
 import java.math.BigInteger;
 import java.util.Scanner;
 public class RecursiveTasks {
     public static void main(String[] args) {
         Scanner userInput = new Scanner(System.in);
         boolean keepRunning = true;
         while (keepRunning) {
             System.out.println(Constants.INDEX);
             System.out.println(Constants.TASK_NUMBER);
             int taskChoice = userInput.nextInt();
             userInput.nextLine();
             switch (taskChoice) {
                 case 1:
                     System.out.println(Constants.PALINDROME_STRING);
                     String palindromeInput = userInput.nextLine();
                     int palindromeCount = countPalindrome(palindromeInput,0);
                     System.out.println(Constants.PALINDROME_COUNT_PROMPT + palindromeCount);
                     break;
                 case 2:
                     System.out.println(Constants.POSITION_PROMPT);
                     int fibonacciPosition = userInput.nextInt();
                     BigInteger fibonacciNumber = findNthFibonacci(fibonacciPosition);
                     if (fibonacciNumber.equals(BigInteger.valueOf(-1))) {
                         System.out.println(Constants.INVALID_POSITION);
                     } else {
                         System.out.println(Constants.NTH_NUMBER + fibonacciNumber);
                     }
                     break;
                 case 3:
                     System.out.println(Constants.STRING_PROMPT);
                     String snakeCaseInput = userInput.nextLine();
                     String snakeCaseString = convertToSnakeCase(snakeCaseInput, 0, "");
                     String camelCaseOutput = convertSnakeToCamelCase(snakeCaseString);
                     System.out.println(Constants.CAMELCASE + camelCaseOutput);
                     break;
                 case 4:
                     System.out.println(Constants.STRING_PROMPT);
                     String consonantInput = userInput.nextLine();
                     int consonantCount = countConsonants(consonantInput, 0, 0);
                     System.out.println( + consonantCount);
                     break;
                 case 5:
                     System.out.println(Constants.BINARY_STRING_PROMPT);
                     String binaryInput = userInput.nextLine();
                     int decimalValue = convertBinaryToDecimal(binaryInput, 0, 0);
                     if (decimalValue == -1) {
                         System.out.println(Constants.INVALID_NUMBER);
                     } else {
                         System.out.println("Decimal value: " + decimalValue);
                     }
                     break;
                 case 6:
                     System.out.println("Exiting...");
                     keepRunning = false;
                     break; 
                 default:
                     System.out.println(Constants.INVALID_OPTION);
                     break;
             }
         } 
         userInput.close();
     } 
    
    /**
     * Counts the number of palindromes in a string.
     * @param inputString The string to check.
     * @param count The current count of palindromes.
     * @return The total number of palindromes.
     */
    public static int countPalindrome(String inputString, int count) {
        if (inputString.length() == 1) {
            return count + 1;
        }
        if (inputString.isBlank()) {
            return count;
        }
        if (isValidPalindrome(inputString)) {
            count++;
        }
        if (inputString.charAt(0) == inputString.charAt(inputString.length() - 1)) {
            count++;
        } else {
            count = count + 2;
        }
        return countPalindrome(inputString.substring(1, inputString.length() - 1), count);
    }

    /**
     * Checks if a string is a valid palindrome.
     * @param s The string to check.
     * @return True if the string is a palindrome, otherwise false.
     */
    public static boolean isValidPalindrome(String string) {
        if (string.isEmpty() || string.length() == 1) {
            return true;
        }
        if (string.charAt(0) == string.charAt(string.length() - 1)) {
            return isValidPalindrome(string.substring(1, string.length() - 1));
        } else {
            return false;
        }
    }
     /**
      * Finds the Nth Fibonacci number using recursion and BigInteger.
      * @param n The position in the Fibonacci sequence.
      * @return The Nth Fibonacci number.
      */
     private static BigInteger findNthFibonacci(int n) {
         if (n <= 0) {
             return BigInteger.valueOf(-1); 
         }
         return fibonacciHelper(n, BigInteger.ZERO, BigInteger.ONE, 2);
     } 
     /**
      * Helper method to recursively compute Fibonacci numbers.
      * @param n The position in the Fibonacci sequence.
      * @param a The first Fibonacci number.
      * @param b The second Fibonacci number.
      * @param currentPosition The current position in the sequence.
      * @return The Nth Fibonacci number.
      */
     private static BigInteger fibonacciHelper(int n, BigInteger a, BigInteger b, int currentPosition) {
         if (n == 1) {
             return a; 
         }
         if (n == 2) {
             return b; 
         }
         if (currentPosition == n) {
             return b;
         }
         return fibonacciHelper(n, b, a.add(b), currentPosition + 1);
     } 
     /**
      * Converts a string to snake_case format.
      * @param input The input string.
      * @param index The current index.
      * @param result The accumulated result in snake_case.
      * @return The string in snake_case format.
      */
     private static String convertToSnakeCase(String input, int index, String result) {
         if (index == input.length()) {
             return result;
         }
         char ch = input.charAt(index);
         if (ch == ' ') {
             result += '_';
         } else if (ch >= 'A' && ch <= 'Z') {
             if (index != 0) {
                 result += '_';
             }
             result += (char) (ch + 32);
         } else {
             result += ch;
         }
         return convertToSnakeCase(input, index + 1, result);
     } 
     /**
      * Converts a snake_case string to camelCase format.
      * @param snakeCase The snake_case string.
      * @return The string in camelCase format.
      */
     private static String convertSnakeToCamelCase(String snakeCase) {
         return convertSnakeToCamelHelper(snakeCase, 0, "", false);
     }
     /**
      * Helper method to convert snake_case to camelCase recursively.
      * @param snakeCase The snake_case string.
      * @param index The current index.
      * @param camelCaseResult The accumulated result in camelCase.
      * @param capitalizeNext Indicates if the next character should be capitalized.
      * @return The string in camelCase format.
      */
     private static String convertSnakeToCamelHelper(String snakeCase, int index, String camelCaseResult,
             boolean capitalizeNext) {
         if (index == snakeCase.length()) {
             return camelCaseResult;
         }
         char ch = snakeCase.charAt(index);
         if (ch == '_') {
             capitalizeNext = true;
         } else {
             if (capitalizeNext) {
                 camelCaseResult += (char) (ch - 32);
                 capitalizeNext = false;
             } else {
                 camelCaseResult += ch;
             }
         }
         return convertSnakeToCamelHelper(snakeCase, index + 1, camelCaseResult, capitalizeNext);
     } 
     /**
      * Counts the number of consonants in a string.
      * @param input The input string.
      * @param index The current index.
      * @param count The current count of consonants.
      * @return The total count of consonants.
      */
     private static int countConsonants(String input, int index, int count) {
         if (index == input.length()) {
             return count;
         }
         char ch = input.charAt(index);
         if (isConsonant(ch)) {
             count++;
         }
         return countConsonants(input, index + 1, count);
     } 
     /**
      * Checks if a character is a consonant.
      * @param ch The character to check.
      * @return True if the character is a consonant, false otherwise.
      */
     private static boolean isConsonant(char ch) {
         ch = Character.toLowerCase(ch);
         return (ch >= 'a' && ch <= 'z') && !(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u');
     } 
     /**
      * Converts a binary string to a decimal number.
      * @param binary The binary string.
      * @param index The current index.
      * @param decimal The accumulated decimal value.
      * @return The decimal value.
      */
     private static int convertBinaryToDecimal(String binary, int index, int decimal) {
         if (index == binary.length()) {
             return decimal;
         }
         char ch = binary.charAt(index);
         if (ch == '1') {
             decimal = decimal * 2 + 1;
         } else if (ch == '0') {
             decimal = decimal * 2;
         } else {
             return -1;
         }
         return convertBinaryToDecimal(binary, index + 1, decimal);
     }
 }
 