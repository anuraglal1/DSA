package SlidingWindow;

import java.util.Arrays;

public class LongestSubstringWithoutRepeatingCharacters {

    public static String longestUniqueSubstring(String s) {
        int n = s.length();
        int i = 0, j = 0;
        boolean[] visited = new boolean[26];
        Arrays.fill(visited, false);
        int start = 0;
        int end = 0;
        int ans = Integer.MIN_VALUE;

        while (j < n) {
            while (visited[s.charAt(j)-'a']) {   // geeksforgeeks
                visited[s.charAt(i) - 'a'] = false;
                i += 1;
            }

            visited[s.charAt(j)-'a'] = true;

            if (ans < j-i+1) {
                ans = j-i+1;
                start = i;
                end = j;
            }
            j += 1;
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
//        String s = "geeksforgeeks";   // 7
          String s = "abcdefabcbb";    // 6

          String res = longestUniqueSubstring(s);
          System.out.println("Longest substring without repeating characters: " + res.length());
          System.out.println(res + " 😊 ");

    }
}
