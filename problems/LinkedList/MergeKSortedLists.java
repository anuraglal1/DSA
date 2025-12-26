package LinkedList;

import java.util.List;

// https://leetcode.com/problems/merge-k-sorted-lists/description/
public class MergeKSortedLists {
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    
    public static ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        int l = 0;
        int r = n-1;

        if (n == 0) {
            return null;
        }

        return divide(lists, l, r);
    }

    public static ListNode divide(ListNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }

        int mid = l + (r-l)/2;
        ListNode left = divide(lists, l, mid);
        ListNode right = divide(lists, mid+1, r);

        return merge(left, right);
    }

    public static ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        if (left.val < right.val) {
            left.next = merge(left.next, right);
            return left;
        } else {
            right.next = merge(left, right.next);
            return right;
        }
    }

    // create linkedList by inserting at end
    public static ListNode create(int[] arr) {
        ListNode head = new ListNode(arr[0], null);
        ListNode temp = head;

        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i], null);
            temp = temp.next;
        }

        return head;
    }


    public static void print(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }
    
    public static void main(String[] args) {
        int[] input1 = {1, 4, 5};
        int[] input2 = {1, 3, 4};
        int[] input3 = {2, 6};

        System.out.println("Printing lists");

        // create list
        ListNode list1 = create(input1);
        ListNode list2 = create(input2);
        ListNode list3 = create(input3);

        ListNode mergedList = mergeKLists(List.of(list1, list2, list3).toArray(new ListNode[0]));

        System.out.print("😊 Merged list is : ");
        print(mergedList);

    }
}
