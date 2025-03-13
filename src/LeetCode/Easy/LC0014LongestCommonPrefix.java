package LeetCode.Easy;

/**
 * (14)
 * Write a fn to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string.
 * Ex: {"flower", "flow", "flight"} -> "fl"
 * TC: O(m*n) where m is the lengths of the list and n is the longest string in the list
 * SC: 0(1) only use one prefix without any additional data structure
 */
public class LC0014LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        // Assign the first word
        String prefix = strs[0];

        // Iterate from second word on and check whether prefix matches words in array
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                // While current prefix not matches remove last character
                // from prefix and check again
                prefix = prefix.substring(0, prefix.length() - 1);
                // If we removed every character from prefix return empty string
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static String now(String[] words) {
        if (words.length == 0) return "";
        if (words.length == 1) return words[0];

        String prefix = words[0];
        for (int i = 1; i < words.length; i++) {
            while (words[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        String[] words = {"flower", "flow", "flight"};
        System.out.println(now(words));
    }
}
