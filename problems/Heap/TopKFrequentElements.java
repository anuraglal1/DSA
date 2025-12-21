package Heap;

import java.util.*;

// https://leetcode.com/problems/top-k-frequent-elements/
// Time Complexity :O(nlog(k)+klog(k))
// Space Complexity : O(n+k)
public class TopKFrequentElements {
    // Pair class definition
    public static class Pair<K, V> {
        private final K key;
        private final V value;

        // Constructor to initialize the pair
        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        // Getter for the key
        public K getKey() {
            return key;
        }

        // Getter for the value
        public V getValue() {
            return value;
        }
    }

    public static int[] topKFrequent(int[] nums, int k) {
        // HashMap to store the frequency of each element
        Map<Integer, Integer> hmap = new HashMap<>();

        // Populate the HashMap with frequency of each number
        for (int num : nums) {
            hmap.put(num, hmap.getOrDefault(num, 0) + 1);
        }

        // PriorityQueue to store pairs of frequency and number, sorted by frequency
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
            // Compare by frequency (key)
            public int compare(Pair<Integer, Integer> p1, Pair<Integer, Integer> p2) {
                return p1.getKey() - p2.getKey();
            }
        });

        // Build the priority queue of size k or less
        for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
            if (pq.size() < k) {
                pq.add(new Pair<>(entry.getValue(), entry.getKey()));
            } else {
                if (pq.peek().getKey() < entry.getValue()) {
                    pq.poll(); // Remove the element with the least frequency
                    pq.add(new Pair<>(entry.getValue(), entry.getKey()));
                }
            }
        }

        // Retrieve the top k frequent elements
        int[] ans = new int[k];
        int i = 0;
        while (!pq.isEmpty()) {
            Pair<Integer, Integer> curr = pq.poll();
            ans[i++] = curr.getValue(); // Get the number (value) from the pair
        }

        return ans;
    }

    // Main method to test the solution
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,1,2,3,1,3,2};
        int k = 2;

        // Get the top k frequent elements
        int[] ans = topKFrequent(nums, k);

        // Output the result
        System.out.println("K most frequent elements are: 😊");
        Arrays.stream(ans).forEach(i -> System.out.print(i + " "));
    }
}
