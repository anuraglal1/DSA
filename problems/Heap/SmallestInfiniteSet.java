package Heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// https://leetcode.com/problems/smallest-number-in-infinite-set/
public class SmallestInfiniteSet {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Set<Integer> set = new HashSet<>();

    public SmallestInfiniteSet() {
        for (int i = 1; i <= 1000; i++) {
            pq.add(i);
            set.add(i);
        }
    }

    public int popSmallest() {
        if (!pq.isEmpty()) {
            int smallest = pq.poll();
            set.remove(smallest);
            return smallest;
        }
        return -1;
    }

    public void addBack(int num) {
        if (!set.contains(num)) {
            set.add(num);
            pq.add(num);
        }
    }
}
