/**
 * Problem : https://leetcode.com/problems/max-number-of-k-sum-pairs/description/
 * Submission : https://leetcode.com/problems/max-number-of-k-sum-pairs/submissions/1951882124
 */

class Solution1679 {
    fun maxOperations(nums: IntArray, k: Int): Int {
        val history = hashMapOf<Int, Int>()
        var ops = 0
        for (n in nums) {
            val diff = k - n
            if ((history[diff] ?: 0) > 0) {
                ops++
                history[diff] = (history[diff] ?: 0) - 1
            } else {
                history[n] = (history[n] ?: 0) + 1
            }
        }
        return ops
    }
}

fun main() {
    val solution = Solution1679()
    check(solution.maxOperations(intArrayOf(1, 2, 3, 4), 5) == 2)
    check(solution.maxOperations(intArrayOf(3, 1, 3, 4, 3), 6) == 1)
}
