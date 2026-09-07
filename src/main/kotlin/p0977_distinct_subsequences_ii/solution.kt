package p0977_distinct_subsequences_ii

class Solution {
    fun distinctSubseqII(s: String): Int {
        val MOD = 1_000_000_007L

        var dp = 1L
        val last = LongArray(26)

        for (c in s) {
            val index = c - 'a'
            val oldDp = dp
            dp = (2 * dp - last[index] + MOD) % MOD
            last[index] = oldDp
        }

        return ((dp - 1 + MOD) % MOD).toInt()
    }
}
