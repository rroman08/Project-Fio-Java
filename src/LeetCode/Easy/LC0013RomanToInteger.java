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
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int previousVal = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            int curVal = map.get(s.charAt(i));

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
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;
        int previous = 0;

        for (int i = str.length() - 1; i >= 0; i--) {
            int current = map.get(str.charAt(i));
            if (previous > current) {
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
