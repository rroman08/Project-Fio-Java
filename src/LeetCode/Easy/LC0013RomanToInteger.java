package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * (13)
 * Roman numerals are represented by seven different symbols:
 * I=1, V=5, X=10, L=50, C=100, D=500 and M=1000.
 */
public class LC0013RomanToInteger {
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
        int previousVal = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            int curVal = romanMap.get(s.charAt(i));

            if (curVal < previousVal) {
                result -= curVal;
            } else {
                result += curVal;
            }

            previousVal = curVal;
        }
        return result;
    }

    public static int now(String str) {
        Map<Character, Integer> romanMap = new HashMap<>();
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);

        int result = 0;
        int previous = 0;
        for (int i = str.length() - 1; i >= 0; i--) {
            int current = romanMap.get(str.charAt(i));
            if (previous > current) {  // VI, IX
                result -= current;
            } else {
                result += current;
            }
            previous = current;
        }
        return result;
    }

    public static void main(String[] args) {
        String[] numerals = {"VII", "XI", "MI", "II", "CMXCIII", "VM"};
        for (String numeral : numerals) {
            System.out.println(now(numeral));
        }
    }
}
