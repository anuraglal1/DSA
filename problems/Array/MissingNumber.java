package Array;

import java.util.Arrays;

// https://leetcode.com/problems/missing-number/description/
public class MissingNumber {
    public static int missingNumber(int[] nums) {
        int i;
        int n = nums.length;

        int sum = Arrays.stream(nums).sum();
        int expected = (n * (n+1))/2;

        return expected - sum;

    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 3};
        System.out.println("Missing number is: " + missingNumber(nums));
    }
}
