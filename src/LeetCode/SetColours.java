package LeetCode;

import java.util.Arrays;

public class SetColours {
    // LeetCode 75
    // Array contains three colours, represented by values. Can this array be sorted in linear
    // rather than TC: O(n log n)?
    // Ex: {2, 0, 2, 1, 1, 0} contains 0, 1, 2
    // TC: O(2n) = O(n)
    // SC: 0(1)
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        sortColours(nums);
        System.out.println(Arrays.toString(nums));
    }

    // In single path
    // All values on the left to the left-pointer are zeroes.
    // All values on to the left of the mid-pointer are ones or zeroes.
    // All value on to the right of th right-pointer are twos.
    public static void sortColours(int[] nums) {
        int left = 0, mid = 0, right = nums.length - 1;
        while (mid <= right) {
            if (nums[mid] == 0) {
                swap(left, mid, nums);
                left++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {  // nums[mid] == 2, swap with right
                swap(mid, right, nums);
                right--;
            }
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
