package p0932_monotonic_array

class Solution {
    fun isMonotonic(nums: IntArray): Boolean {
        var isIncreasing = true
        var isDecresing = true
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) isDecresing = false
            if (nums[i] < nums[i - 1]) isIncreasing = false
        }

        return isIncreasing || isDecresing
    }
}
