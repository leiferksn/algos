package me.leiferksn;

public class SortedArrayFinder {



    public int search(int[] nums, int target) {
        return look(nums, nums.length - 1, 0, target);
    }

    private int middle(int numsLength) {
        int halfLength;
        if (numsLength % 2 == 0) {
            halfLength = numsLength / 2;
        } else {
            halfLength = (numsLength + 1) / 2;
        }
        return halfLength;
    }

    private int look(int[] nums, int upper, int lower, int target) {
        if (upper == lower) {
            if (target == nums[upper]) {
                return upper;
            } else {
                return -1;
            }
        }

        int count = (upper - lower) + 1;
        int mid = lower + middle(count) - 1;

        int new_upper = 0;
        int new_lower = 0;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid]) {
            new_lower = lower;
            new_upper = mid;
        } else if (target >= nums[mid + 1]) {
            new_lower = mid + 1;
            new_upper = upper;
        }

        return look(nums, new_upper, new_lower, target);

    }
}
