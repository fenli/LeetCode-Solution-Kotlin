import kotlin.math.min

/**
 * Problem : https://leetcode.com/problems/min-cost-climbing-stairs/description/
 * Submission : https://leetcode.com/problems/min-cost-climbing-stairs/submissions/1968419898
 */

class Solution746 {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var first = cost[0]
        var second = cost[1]
        if (cost.size <= 2) return min(first, second)
        for (i in 2 until cost.size) {
            val current = cost[i] + min(first, second)
            first = second
            second = current
        }

        return min(first, second)
    }
}

fun main() {
    val solution = Solution746()
    check(solution.minCostClimbingStairs(intArrayOf(10, 15, 20)) == 15)
    check(solution.minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)) == 6)
}
