package Heap;

import java.util.*;

// https://leetcode.com/problems/reorganize-string/
public class ReorganizeString {
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

    public static String reorganizeString(String s) {
        int n = s.length();
        String res = "";
        PriorityQueue<Pair<Character, Integer>> pq = new PriorityQueue<>(
                new Comparator<Pair<Character, Integer>>() {
                    public int compare(Pair<Character, Integer> p1, Pair<Character, Integer> p2) {
                        return p2.getValue() - p1.getValue();
                    }
                }
        );
        Map<Character, Integer> hmap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hmap.put(s.charAt(i), hmap.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : hmap.entrySet()) {
            Pair<Character, Integer> p = new Pair(entry.getKey(), entry.getValue());
            pq.add(p);
        }

        while (pq.size() > 1) {
            Pair<Character, Integer> p1 = pq.poll();
            Pair<Character, Integer> p2 = pq.poll();

            if (p1.getValue() > 0) {
                res += p1.getKey();
                if (p1.getValue() > 1) {
                    pq.add(new Pair(p1.getKey(), p1.getValue() - 1));
                }
            }

            if (p2.getValue() > 0) {
                res += p2.getKey();
                if (p2.getValue() > 1) {
                    pq.add(new Pair(p2.getKey(), p2.getValue() - 1));
                }
            }
        }

        if (pq.isEmpty()) {
            return res;
        }

        if (pq.peek().getValue() == 1) {
            res += pq.peek().getKey();
            return res;
        }

        return "";
    }

    // Main method to test the solution
    public static void main(String[] args) {
       String s = "abbabbaaab";
//       String s = "abaaa";

       String ans = reorganizeString(s);

       if (ans.isEmpty()) {
           System.out.println("String cannot be reorganized 🙁");
       } else {
           System.out.println("String after reorganizing is : " + ans + " 😊");
       }

    }
}
