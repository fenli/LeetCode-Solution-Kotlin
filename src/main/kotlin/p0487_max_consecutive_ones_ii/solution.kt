package p0487_max_consecutive_ones_ii

class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var len1 = -1
        var len2 = 0
        var maxLen = 0
        for (num in nums) if (num == 0) {
            maxLen = max(maxLen, len1 + 1 + len2)
            len1 = len2
            len2 = 0
        } else len2++
        return max(maxLen, len1 + 1 + len2)
    }
}
