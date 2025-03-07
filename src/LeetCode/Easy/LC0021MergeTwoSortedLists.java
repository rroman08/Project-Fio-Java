package LeetCode.Easy;

/**
 * (21)
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists into one sorted list. The list should be made
 * by splicing together the nodes of the first two lists.Return the
 * head of the merged linked list.
 *
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 *
 * TC: O(m + n) -> m=list1, n=list2
 * SC: O(1)
 * Does not use any extra memory other than a few pointer variables.
 * Merging is done in-place, reusing existing nodes
 */
public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Use a dummy node as temporary head
        ListNode dummy = new ListNode(-1);
        // Assign actual head
        ListNode current = dummy;
        // Traverse both lists and merge
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;  // point as head to next node
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        // Attach the remaining elements of the original lists
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }
        // Return the merged list starting from the real head
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}