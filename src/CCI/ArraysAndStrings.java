package CCI;

import java.util.Arrays;

public class ArraysAndStrings {

    public static void main(String[] args) {

    }

    // ****************************************************************************************************************

    // 1.1 IsUnique: Implement an algorithm to determine if a string has all unique characters.
    // What if you cannot use additional data structures?
    // Is it in ASCII?
    // TC: O(n) where n is the lengths of the string (however, the loop never iterates longer than 128 times in ASCII,
    // therefore it could argued it is O(1).
    // #Hashtable, #BitVector
    public static boolean isUniqueChars(String str) {
        if (str.length() > 128) return false;

        boolean[] charSet = new boolean[128];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (charSet[val]) return false;
            charSet[val] = true;
        }
        return true;
    }

    // Same problem, yet solution with bit-vector
    public static boolean isUniqueCharsBitVector(String str) {
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    // ****************************************************************************************************************

    // 1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
    // Is it case-sensitive?
    // Is white space significant?
    // Assumption here is that it is both.
    // NOTE: springs with different length cannot be permutations of each other.

    // Solution (1) with sorting:
    public static String sorter(String str) {
        char[] content = str.toCharArray();
        Arrays.sort(content);
        return new String(content);
    }

    public static boolean permutationWithSorting(String str1, String str2) {
        if (str1.length() != str2.length()) return false;
        return sorter(str1).equals(sorter(str2));
    }

    // Solution (2) check if same character count:
    public static boolean permutationCharCount(String str1, String str2) {
        if (str1.length() != str2.length()) return false;

        // Use a hash table to increment chars
        int[] letters = new int[128];  // Assumption: ASCII
        for (int i = 0; i < str1.length(); i++) {
            letters[str1.charAt(i)]++;
        }

        // Now, decrement hash table values. Because both strings are the same lengths, if they are using the same
        // letters, there should neither be a negative value nor positive value in 'letters' -> all zeroes.
        for (int i = 0; i < str2.length(); i++) {
            letters[str2.charAt(i)]--;
            if (letters[str2.charAt(i)] < 0) return false;
        }
        return true;
    }
}
