package p1631_number_of_subarrays_with_odd_sum

class Solution {
    private val MOD = 1_000_000_007L

    fun numOfSubarrays(arr: IntArray): Int {
        var ans = 0L
        var prefixSum = 0L
        for (n in arr) {
            prefixSum += n
            ans += prefixSum % 2
        }
        ans += (arr.size - ans) * ans
        return (ans % MOD).toInt()
    }

    fun numOfSubarrays_TLE(arr: IntArray): Int {
        var ans = 0
        val isOdds = BooleanArray(arr.size)
        for (i in 0 until arr.size) {
            val isPrevOdd = if (i > 0) isOdds[i-1] else false
            val isOdd = arr[i] % 2 != 0
            isOdds[i] = isOdd xor isPrevOdd
            if (isOdd) ans++
        }

        for (i in 0 until arr.size-1) {
            for (j in (i+1) until arr.size) {
                val prevOdd = if (i > 0) isOdds[i-1] else false
                if (isOdds[j] xor prevOdd) ans++
            }
        }

        return (ans % MOD).toInt()
    }
}
