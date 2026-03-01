package DynamicProgramming;


import java.util.Arrays;

// https://neetcode.io/problems/house-robber/question?list=neetcode150
public class HouseRobber {
    public static int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);

        return solve(nums, n, 0, dp);
    }

    public static int solve(int[] nums, int n, int i, int[] dp) {
        if (i >= n) {
            return 0;
        }

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[i];
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int skip = solve(nums, n, i+1, dp);
        int rob = nums[i] + solve(nums, n, i+2, dp);

        return dp[i] = Math.max(skip, rob);
    }

    public static void main(String[] args) {
//        int[] arr = {1,1,3,3};
//
//        int res = rob(arr);
//
//        if (res == 5) {
//            System.out.println("Maximum amount of money you can rob  is 😊: " + res);
//        } else {
//            System.out.println("Something is wrong !! 😢");
//        }

        int[] arr = {2,9,8,3,6};

        int res = rob(arr);

        if (res == 16) {
            System.out.println("Maximum amount of money you can rob  is 😊: " + res);
        } else {
            System.out.println("Something is wrong !! 😢");
        }
    }
}
