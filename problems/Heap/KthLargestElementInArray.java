package Heap;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            if (pq.size() < k) {
                pq.add(num);
            } else {
                if (num >= pq.peek()) {
                    pq.poll();
                    pq.add(num);
                }
            }
        }

        return pq.poll();
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;

        int ans = findKthLargest(nums, k);

        System.out.println("Kth largest element is : " + ans + " 😊");
    }
}
