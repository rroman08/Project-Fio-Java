package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * (13)
 * Roman numerals are represented by seven different symbols:
 * I=1, V=5, X=10, L=50, C=100, D=500 and M=1000.
 */

public class RomanToInteger {

    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int prevVal = 0;

        for (int i = s.length() - 1; i >= 0 ; i--) {
            int curVal = romanMap.get(s.charAt(i));

            if (curVal < prevVal) {
                result -= curVal;
            } else {
                result += curVal;
            }

            prevVal = curVal;
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
