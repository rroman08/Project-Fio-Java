package LeetCode.Easy;

/**
 * (26)
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element
 * appears only once. The relative order of the elements should
 * be kept the same. Then return the number of unique elements
 * in nums.
 *
 * Consider the number of unique elements of nums to be k, to
 * get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums
 * contain the unique elements in the order they were present in
 * nums initially. The remaining elements of nums are not important
 * as well as the size of nums.
 *
 * Return k.
 * Custom Judge:
 * The judge will test your solution with the following code:
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * int k = removeDuplicates(nums); // Calls your implementation
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * If all assertions pass, then your solution will be accepted.
 */
public class LC0026RemoveDuplicatesSortedArray {
    public static int removeDuplicates(int[] nums) {
        // We need to modify the array in-place and the size of the final
        // array would potentially be smaller than the size of the input
        // array. So, we ought to use a two-pointer approach here. One,
        // that would keep track of the current element in the original
        // array and another one for just the unique elements.

        // Essentially, once an element is encountered, you simply need
        // to bypass its duplicates and move on to the next unique element.

        //Edge case:
        if (nums.length == 0) return 0;
        // Pointer for the next unique element position
        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            // Check if the current element is unique
            if (nums[i] != nums[i - 1]) {
                // Move it to the next available unique position
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}
