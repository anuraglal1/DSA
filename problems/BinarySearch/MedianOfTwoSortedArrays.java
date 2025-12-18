package BinarySearch;

// https://leetcode.com/problems/median-of-two-sorted-arrays/description/
// TC: O(log(min(m, n)))
public class MedianOfTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int low = 0;
        int high = m; // 1

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = (m + n + 1) / 2 - mid1;

            int l1 = mid1 == 0 ? Integer.MIN_VALUE : nums1[mid1-1];
            int r1 = mid1 == m ? Integer.MAX_VALUE : nums1[mid1];

            int l2 = mid2 == 0 ? Integer.MIN_VALUE : nums2[mid2-1];
            int r2 = mid2 == n ? Integer.MAX_VALUE : nums2[mid2];

            if (l1 <= r2 && l2 <= r1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(l1, l2) + Math.min(r1, r2))/2.0;
                } else {
                    return Math.max(l1, l2);
                }
            }

            if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        double res = findMedianSortedArrays(nums1, nums2);

        System.out.println("Median of 2 sorted array is: " + res + " 😀");

    }
}
