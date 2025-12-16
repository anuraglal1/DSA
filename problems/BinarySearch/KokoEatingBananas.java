package BinarySearch;

import java.util.Arrays;

// https://leetcode.com/problems/koko-eating-bananas/
public class KokoEatingBananas {
    public static int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        Arrays.sort(piles);
        long l = 1;
        long r = piles[n-1];
        long ans = piles[n-1];

        // 4 11 20 23 30

        // l = 4 , r = 30
        // l = 18, r = 30
        // l = 18, r = 23
        // l = 21, r = 23
        // l = 23, r = 23
        // l = 23, r = 22
        while (l <= r && r <= piles[n-1]) {
            long mid = l + (r - l)/2; // 17, 24, 20, 22, 23
            long hoursConsumed = 0;
            for (int num : piles) {
                if (num%mid == 0) {
                    hoursConsumed = hoursConsumed + num/mid;
                } else {
                    hoursConsumed = hoursConsumed + num/mid + 1;
                }
            } // 8, 6, 7, 7, 6

            hoursConsumed = hoursConsumed == 0 ? 1 : hoursConsumed;

            if (hoursConsumed <= h) {
                r = mid - 1; // 23, 22
                ans = Math.min(ans, mid); // 24, 23
            } else {
                l = mid + 1; // 21, 23
            }
        }


        return (int) ans; // This is done to pass this test case:
        // piles = [805306368,805306368,805306368] and h = 1000000000
    }

    public static void main(String[] args) {
        int[] piles = {30,11,23,4,20};
        int hours = 6;

//        int[] piles = { 805306368,805306368,805306368 };
//        int hours = 1000000000;


        int res = minEatingSpeed(piles, hours);

        System.out.println("Minimum eating speed of Koko should be: " + res + " 😀");

    }
}
