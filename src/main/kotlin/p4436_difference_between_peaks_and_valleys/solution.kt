package p4436_difference_between_peaks_and_valleys

class Solution {
    fun peakValleyDifference(nums: IntArray): Int {
        var result = 0

        for (i in 1 until nums.lastIndex) {
            val prev = nums[i - 1]
            val curr = nums[i]
            val next = nums[i + 1]

            if (curr > prev && curr > next) {
                result += curr
            } else if (curr < prev && curr < next) {
                result -= curr
            }
        }

        return result
    }
}
