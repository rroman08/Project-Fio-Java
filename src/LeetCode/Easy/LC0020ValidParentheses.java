package LeetCode.Easy;

import java.util.Stack;

/**
 * (20)
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid. An input string is valid if:
 * 1) Open brackets must be closed by the same type of brackets.
 * 2) Open brackets must be closed in the correct order.
 * 3) Every close bracket has a corresponding open bracket of the same type.
 *
 * Input: s = "()", Output: true
 * Input: s = "()[]{}", Output: true
 * Input: s = "(]", Output: false
 * Input: s = "([])", Output: true
 *
 * Hint 1: Use a stack of characters
 * Hint 2: When you encounter an opening bracket, push it to the top of the stack.
 * Hint 3: When you encounter a closing bracket, check if the top of the stack was
 * the opening for it. If yes, pop it from the stack. Otherwise, return false.
 */
public class LC0020ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c: s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;  // means no matching opening brackets

                char top = stack.pop();
                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
         }
        return stack.isEmpty();  // Stack should be empty if all brackets are matched
    }

    public static void main(String[] args) {
        String[] tests = {"()", "()[]{}", "(]", "([])"};
        for (String test : tests) {
            System.out.println(isValid(test));
        }
    }
}
