package DynamicProgramming;

import java.util.*;

// https://leetcode.com/problems/maximum-profit-in-job-scheduling/description/
public class MaximumProfitInJobScheduling {
    static class Job {
        int st;
        int et;
        int profit;

        public Job(int st, int et, int p) {
            this.st = st;
            this.et = et;
            this.profit = p;
        }
    }

    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int i = 0;
        List<Job> jobs = new ArrayList<>();
        int[] dp = new int[n];

        for (i = 0; i< n; i++) {
            jobs.add(new Job(startTime[i], endTime[i], profit[i]));
        }

        Arrays.fill(dp, -1);

        Collections.sort(jobs, Comparator.comparingInt(
                x -> x.et
        ));

        return solve(jobs, n-1, dp);

    }

    public static int solve(List<Job> jobs, int n, int[] dp) {
        if (n < 0) {
            return 0;
        }
        if (n == 0) {
            return jobs.get(0).profit;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        int next = findNextNonConflictingSlotTime(jobs, n);

        int pick = jobs.get(n).profit + solve(jobs, next, dp);
        int notPick = solve(jobs, n-1, dp);

        return dp[n] = Math.max(pick, notPick);
    }

    public static int findNextNonConflictingSlotTime(List<Job> jobs, int n) {
        // for (int j = n-1; j >= 0; j--) {
        //     if (jobs.get(j).et <= jobs.get(n).st) {
        //         return j;
        //     }
        // }
        int l = 0;
        int r = n-1;

        while(l <= r) {
            int mid = (l+r)/2;

            if (jobs.get(mid).et <= jobs.get(n).st) {
                if (mid + 1 <= r && jobs.get(mid + 1).et <= jobs.get(n).st) {
                    l = mid + 1;
                } else {
                    return mid;
                }
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }

    public static void main (String[] args) {
        int[] startTime = {1,2,3,3};
        int[] endTime = {3,4,5,6};
        int[] profit = {50,10,40,70};

        int res1 = jobScheduling(startTime, endTime, profit);

        int[] startTime1 = {1,2,3,4,6};
        int[] endTime1 = {3,5,10,6,9};
        int[] profit1 = {20,20,100,70,60};

        int res2 = jobScheduling(startTime1, endTime1, profit1);

        int[] startTime2 = {1,1,1};
        int[] endTime2 = {2,3,4};
        int[] profit2 = {5,6,4};

        int res3 = jobScheduling(startTime2, endTime2, profit2);

        if (res1 == 120 && res2 == 150 && res3 == 6) {
            System.out.println("All the test cases are passing 😊");
        } else {
            System.out.println("Some of the test cases are failing 😢");
        }
    }

}
