package p0300_longest_increasing_subsequence

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        dp[0] = 1
        var longest = 1
        for (i in 1 until nums.size) {
            var maxPrev = 0
            for (j in 0 until i) {
                if (nums[j] < nums[i]) maxPrev = maxOf(maxPrev, dp[j])
            }
            dp[i] = maxPrev + 1
            longest = maxOf(longest, dp[i])
        }
        return longest
    }
}
