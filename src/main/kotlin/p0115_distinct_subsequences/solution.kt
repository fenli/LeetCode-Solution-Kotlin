package p0115_distinct_subsequences

class Solution {
    fun numDistinct(s: String, t: String): Int {
        val m = s.length
        val n = t.length

        val dp = IntArray(n + 1)

        for (i in 1..m) {
            var last = 1

            for (j in 1..n) {
                val cur = dp[j]

                val take = if (s[i - 1] == t[j - 1]) last else 0
                val notTake = cur

                dp[j] = take + notTake
                last = cur
            }
        }

        return dp[n]
    }
}
