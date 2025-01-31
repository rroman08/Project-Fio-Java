package LeetCode.Easy;

import java.util.HashMap;
import java.util.Map;

/**
 * (1)
 * Given an array of integers nums and an integer target, return indices of the two numbers
 * such that they add up to target. You may assume that each input would have exactly one
 * solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * Can you come up with an algorithm that is less than O(n^2) time complexity?
 * TC: O(n), SC: O(n)
 * */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int curVal = nums[i];
            int x = target - curVal;
            if (map.containsKey(x)) {
                return new int[] {map.get(x), i};
            }
            map.put(curVal, i);
        }
        return new int[] {};
    }

    // Similar solution but with two loops:
    public int[] twoSumTwoLoops(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {map.get(complement), i};
            }
        }

        return new int[] {};
    }

    // Brute-force solution
    public int[] twoSumBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {};
    }

    public static void main(String[] args) {

    }
}
