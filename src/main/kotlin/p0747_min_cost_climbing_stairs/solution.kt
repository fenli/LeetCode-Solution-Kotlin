package p0747_min_cost_climbing_stairs

class Solution {
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
