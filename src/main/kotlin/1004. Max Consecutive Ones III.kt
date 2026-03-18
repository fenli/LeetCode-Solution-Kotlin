import kotlin.math.max

/**
 * Problem : https://leetcode.com/problems/max-consecutive-ones-iii/description/
 * Submission : https://leetcode.com/problems/max-consecutive-ones-iii/submissions/1952158437
 */

class Solution1004 {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var maxOne = 0
        var zeros = 0
        var leftP = 0
        for (i in nums.indices) {
            if (nums[i] == 0) zeros++

            if (zeros <= k) {
                maxOne = max(maxOne, i + 1 - leftP)
            } else {
                while (zeros > k) if (nums[leftP++] == 0) zeros--
            }
        }

        return maxOne
    }
}

fun main() {
    val solution = Solution1004()
    check(solution.longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2) == 6)
    check(solution.longestOnes(intArrayOf(0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1), 3) == 10)
}
