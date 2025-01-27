package LeetCodeQuestions;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class MoveZeroes {
    // LeetCode 283
    // Given an integer array "nums" move all 0s to the end of it while maintaining the relative
    // order of the non-zero elements. (Must be done in place without making a copy of the array)
    // Ex: nums = {0, 1, 0, 3, 12} -> {1, 3, 13, 0, 0}
    // TC: O(m*n) where m is the lengths of the list and n is the longest string in the list
    // SC: 0(1) only use one prefix without any additional data structure
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
    }

    // This algorithm is NOT in place (brute-force solution)
    // TC: O(n)
    // SC: O(n)
    public static void moveZeroes2(int[] nums) {
        if (nums.length == 1) return;

        Queue<Integer> queue = new LinkedList<>();
        // Add all non-zero values to the queue
        for (int num : nums) {
            if (num != 0) {
                queue.add(num);
            }
        }

        int idx = 0;
        // Write back all queue items to the array
        while (!queue.isEmpty()) {
            nums[idx] = queue.poll();
            idx++;
        }

        // Fill the rest of the array with 0s
        for (int i = idx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
