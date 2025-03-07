package LeetCode.Easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LC0283MoveZeroes {
    // LeetCode 283
    // Given an integer array "nums" move all 0s to the end of it while maintaining the relative
    // order of the non-zero elements. (Must be done in place without making a copy of the array)
    // Ex: nums = {0, 1, 0, 3, 12} -> {1, 3, 13, 0, 0}
    // TC: O(n)
    // SC: 0(1)
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes2(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    // TC: O(n)
    // SC: O(1)
    public static void moveZeroes(int[] nums) {
        if (nums.length == 1) return;
        // Create the left pointer
        int left = 0;
        // Create right pointer in for-loop
        for (int right = 0; right < nums.length; right++) {
            // If the right pointer is non-zero, update the value at the left pointer
            // with the value at the right pointer
            if (nums[right] != 0) {
                nums[left] = nums[right];
                // Every time we update the value at the left pointer we have to move
                // the left pointer one along
                left++;
            }
            // If value at right pointer is 0, we do nothing. I.e., move it along the array
        }

        // After right pointer reaches the end on the array, we have to fill the remaining
        // positions of the left pointer with zeroes until end is reached
        // (from left to nums.length - 1)
        for (int i = left; i < nums.length; i++) {
            nums[i] = 0;
        }
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
