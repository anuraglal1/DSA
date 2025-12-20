package BinarySearch;

// https://leetcode.com/problems/search-in-rotated-sorted-array/
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0;
        int r = n-1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[l] <= nums[mid]) {
                if (target >= nums[l] && target <= nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (target <= nums[r] && target >= nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = { 4,5,6,7,0,1,2 };
        int target = 5;
        int ans = search(nums, target);
        if (ans != -1) {
            System.out.println("Target present at index: " + search(nums, target) + " 😊");
        } else {
            System.out.println("Oops target not found: 😢");
        }
    }
}
