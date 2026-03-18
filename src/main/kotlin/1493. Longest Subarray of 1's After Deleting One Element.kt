import kotlin.math.max

/**
 * Problem : https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/
 * Submission : https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/submissions/1952159470
 */

class Solution1493 {
    fun longestSubarray(nums: IntArray): Int {
        val k = 1
        var maxOne = 0
        var zeros = 0
        var leftP = 0
        for (i in nums.indices) {
            if (nums[i] == 0) zeros++

            if (zeros <= k) {
                maxOne = max(maxOne, i - leftP)
            } else {
                while (zeros > k) if (nums[leftP++] == 0) zeros--
            }
        }

        return maxOne
    }
}

fun main() {
    val solution = Solution1493()
    check(solution.longestSubarray(intArrayOf(1, 1, 0, 1)) == 3)
    check(solution.longestSubarray(intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)) == 5)
    check(solution.longestSubarray(intArrayOf(1, 1, 1)) == 2)
}
