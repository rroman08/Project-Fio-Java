package LeetCode.Easy;

/**
 * (9)
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * Example 2:
 *
 * Input: x = -121
 * Output: false
 * Explanation: From left to right, it reads -121. From right to left, it
 * becomes 121-. Therefore, it is not a palindrome.
 *
 * Can you solve it without converting the integer to a string?
 */
public class LC0009PalindromeNumber {
    public static boolean isPalindrome(int x) {
        // Edge cases: Negative numbers and numbers ending in 0 (except 0 itself)
        // are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversedHalf = 0;
        while (x > reversedHalf) {
            // Append the last digit to reversedHalf
            reversedHalf = (reversedHalf * 10) + (x % 10);
            // Remove the last digit from x
            x /= 10;
        }
        // A number is a palindrome if the first half equals the reversed second half
        // or if we ignore the middle digit in odd-length numbers (reversedHalf / 10)
        return x == reversedHalf || x == reversedHalf / 10;
    }

    public static boolean now(int number) {
        if (number < 0 || (number % 10 == 0 && number != 0)) return false;

        int fromEndReversed = 0;
        while (number > fromEndReversed) {
            fromEndReversed = (number % 10) + (fromEndReversed * 10);
            number /= 10;
        }
        return (number == fromEndReversed) || (number == (fromEndReversed / 10));
    }

    public static void main(String[] args) {
        int[] numbers = { 122, 121, -121, 222222, 2020202, 909090 };
        for (int num : numbers) {
            System.out.println(now(num));
        }
    }
}
