package p3608_find_the_number_of_subsequences_with_equal_gcd

class Solution {
    
    fun subsequencePairCount(nums: IntArray): Int {
        val MOD = 1000000007
        val M = 200
        var dp = Array(M+1) { IntArray(M+1) }
        dp[0][0] = 1
        var ndp = Array(M + 1) { IntArray(M + 1) }

        for (x in nums) {
            for (i in 0..M) System.arraycopy(dp[i], 0, ndp[i], 0, M + 1)

            for (g1 in 0..M) {
                for (g2 in 0..M) {
                    val cur = dp[g1][g2]
                    if (cur == 0) continue

                    val ng1 = if (g1 == 0) x else gcd(g1, x)
                    ndp[ng1][g2] += cur
                    if (ndp[ng1][g2] >= MOD) {
                        ndp[ng1][g2] -= MOD
                    }

                    val ng2 = if (g2 == 0) x else gcd(g2, x)
                    ndp[g1][ng2] += cur
                    if (ndp[g1][ng2] >= MOD) {
                        ndp[g1][ng2] -= MOD
                    }
                }
            }

            val temp = dp
            dp = ndp
            ndp = temp
        }

        var ans = 0L
        for (g in 1..M) ans += dp[g][g]
        return (ans % MOD).toInt()
    }

    private tailrec fun gcd(a: Int, b: Int): Int {
        return if (b == 0) Math.abs(a) else gcd(b, a % b)
    }
}

