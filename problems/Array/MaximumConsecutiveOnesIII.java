package Array;

// https://leetcode.com/problems/max-consecutive-ones-iii/
public class MaximumConsecutiveOnesIII {
    public static int longestOnes(int[] nums, int k) {
        int i = 0, ans = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] == 0)
                k--;
            while (k < 0) {
                if (nums[i] == 0)
                    k++;
                i++;
            }
            ans = Math.max(ans, j - i + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
        int k = 2;

        int res1 = longestOnes(nums, k);

        int[] nums1 = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k1 = 3;

        int res2 = longestOnes(nums1, k1);

        if (res1 == 6 && res2 == 10) {
            System.out.println("All the test cases are passing 😊");
        } else {
            System.out.println("Some of the test cases are failing 😢");
        }
    }
}
