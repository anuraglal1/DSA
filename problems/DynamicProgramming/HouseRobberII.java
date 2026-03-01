package DynamicProgramming;


import java.util.Arrays;

// https://neetcode.io/problems/house-robber-ii/question
public class HouseRobberII {
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);
        int first = solve(nums, 0, n-1, dp);

        Arrays.fill(dp, -1);
        int second = solve(nums, 1, n, dp);

        return Math.max(first, second);
    }

    public static int solve(int[] nums, int i, int n, int[] dp) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }

        if (i >= n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int pick = nums[i] + solve(nums, i+2, n, dp);
        int skip = solve(nums, i+1, n, dp);

        return dp[i] = Math.max(pick, skip);
    }

    public static void main(String[] args) {
//        int[] arr = {3, 4, 3};
//
//        int res = rob(arr);
//
//        if (res == 4) {
//            System.out.println("Maximum amount of money you can rob  is 😊: " + res);
//        } else {
//            System.out.println("Expected result is 4 but your result is: " + res + " 😢");
//        }

        int[] arr = {2,9,8,3,6};

        int res = rob(arr);

        if (res == 15) {
            System.out.println("Maximum amount of money you can rob is 😊: " + res);
        } else {
            System.out.println("Expected result is 15 but your result is " + res + " 😢");
        }
    }
}
