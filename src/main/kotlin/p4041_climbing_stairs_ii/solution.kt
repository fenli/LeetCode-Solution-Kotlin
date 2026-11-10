package p4041_climbing_stairs_ii

class Solution {
    fun climbStairs(n: Int, costs: IntArray): Int {
        val dp = IntArray(n + 1) { Int.MAX_VALUE }
        dp[0] = 0
        for (i in 0 until n) {
            if (dp[i] == Int.MAX_VALUE) continue
            for (j in i+1..minOf(n, i + 3)) {
                val stepcost = costs[j - 1] + (j - i) * (j - i)
                dp[j] = minOf(dp[j], dp[i] + stepcost)
            }
        }
        return dp[n]
    }
}
