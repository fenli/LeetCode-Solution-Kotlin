import kotlin.math.min

/**
 * Problem : https://leetcode.com/problems/minimum-size-subarray-sum/description/
 * Submission : https://leetcode.com/problems/minimum-size-subarray-sum/submissions/1945772372
 */

class Solution209 {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var minLen = Int.MAX_VALUE
        var sums = 0
        var subIndex = 0
        for (i in nums.indices) {
            sums += nums[i]
            if (sums >= target) {
                do {
                    sums = sums - nums[subIndex]
                    minLen = min(minLen, i - subIndex + 1)
                    subIndex++
                } while (sums >= target)
            }
        }

        return if (minLen == Int.MAX_VALUE) 0 else minLen
    }
}

fun main() {
    val solution = Solution209()
    check(solution.minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)) == 2)
    check(solution.minSubArrayLen(4, intArrayOf(1, 4, 4)) == 1)
    check(solution.minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)) == 0)
}
