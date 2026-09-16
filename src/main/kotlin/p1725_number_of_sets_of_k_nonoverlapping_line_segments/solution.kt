package p1725_number_of_sets_of_k_nonoverlapping_line_segments

class Solution {
    companion object {
        private const val MOD = 1_000_000_007L
    }

    fun numberOfSets(n: Int, k: Int): Int {
        val total = n + k - 1
        val choose = 2 * k

        val fact = LongArray(total + 1)
        val invFact = LongArray(total + 1)

        fact[0] = 1

        for (i in 1..total) {
            fact[i] = fact[i - 1] * i % MOD
        }

        invFact[total] = power(fact[total], MOD - 2)

        for (i in total downTo 1) {
            invFact[i - 1] = invFact[i] * i % MOD
        }

        return (fact[total]
            * invFact[choose] % MOD
            * invFact[total - choose] % MOD).toInt()
    }

    private fun power(a: Long, b: Long): Long {
        var a = a
        var b = b
        var result = 1L

        while (b > 0) {
            if ((b and 1L) == 1L) {
                result = result * a % MOD
            }

            a = a * a % MOD
            b = b shr 1
        }

        return result
    }
}

