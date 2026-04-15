package DynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int ans = 1;
        int[] dp = new int[n];

        Arrays.fill(dp, -1);


        for (int i = 1; i < n; i++) {
            ans = Math.max(solve(nums, i, n, dp), ans);
        }

        return ans;
    }

    public static int solve(int[] nums, int i, int n, int[] dp) {
        if (i == 0) {
            return 1;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = 1;

        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                ans = Math.max(ans, solve(nums, j, n, dp) + 1);
            }
        }


        return dp[i] = ans;
    }

    public static void main(String[] args) {

        int res1 = lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18});
        int res2 = lengthOfLIS(new int[]{0,1,0,3,2,3});
        int res3 = lengthOfLIS(new int[]{7,7,7,7,7,7,7});

        if (res1 == 4 && res2 == 4 && res3 == 1) {
            System.out.println("All the test cases are passing 😊");
        } else {
            System.out.println("Some of the test cases are failing 😢");
        }
    }
}
