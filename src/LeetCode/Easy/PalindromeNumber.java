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
public class PalindromeNumber {
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

    public static void main(String[] args) {
        System.out.println(isPalindrome(121));  // true
        System.out.println(isPalindrome(-121)); // false
        System.out.println(isPalindrome(10));   // false
        System.out.println(isPalindrome(1221)); // true
    }
}
