import kotlin.math.max

/**
 * Problem : https://leetcode.com/problems/house-robber/description/
 * Submission : https://leetcode.com/problems/house-robber/submissions/1944548288
 */

class Solution198 {
    fun rob(nums: IntArray): Int {
        var rob = 0
        var noRob = 0
        for (n in nums) {
            val newRob = noRob + n
            noRob = max(noRob, rob)
            rob = newRob
        }

        return max(rob, noRob)
    }
}

fun main() {
    val solution = Solution198()
    check(solution.rob(intArrayOf(1, 2, 3, 1)) == 4)
    check(solution.rob(intArrayOf(2, 7, 9, 3, 1)) == 12)
}
