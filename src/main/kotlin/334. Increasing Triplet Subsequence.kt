/**
 * Problem : https://leetcode.com/problems/increasing-triplet-subsequence/description/
 * Submission : https://leetcode.com/problems/increasing-triplet-subsequence/submissions/1951240696
 */

class Solution334 {
    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3) return false

        var firstSmall = -1
        var secondSmall = -1
        for (i in 0 until nums.size) {
            val n = nums[i]
            if (firstSmall == -1 || n < nums[firstSmall]) {
                firstSmall = i
            } else if (n > nums[firstSmall] && (secondSmall == -1 || n < nums[secondSmall])) {
                secondSmall = i
            }

            if (secondSmall != -1 && nums[secondSmall] < n) return true
        }
        return false
    }
}

fun main() {
    val solution = Solution334()
    check(solution.increasingTriplet(intArrayOf(1, 2, 3, 4, 5)))
    check(!solution.increasingTriplet(intArrayOf(5, 4, 3, 2, 1)))
    check(solution.increasingTriplet(intArrayOf(2, 1, 5, 0, 4, 6)))
}
