package p4401_sum_of_decoded_numbers

class Solution {

    private val MOD = 1_000_000_007L
    
    fun sumDecoded(nums: LongArray): Int {
        var ans = 0L

        for (n in nums) {
            val w = (n % 10).toInt()
            val d = (n / 10).toString()

            val x = d.substring(0, w).toLong()
            val y = d.substring(w).toLong()

            ans = (ans + modPow(x, y)) % MOD
        }

        return ans.toInt()
    }

    private fun modPow(base: Long, exp: Long): Long {
        var b = base % MOD
        var e = exp
        var result = 1L
        while (e > 0) {
            if (e % 2 == 1L) result = result * b % MOD
            b = b * b % MOD
            e /= 2
        }
        return result
    }
}
