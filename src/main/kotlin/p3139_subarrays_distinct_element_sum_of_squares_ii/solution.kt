package p3139_subarrays_distinct_element_sum_of_squares_ii

class Solution {
    private lateinit var s: LongArray
    private lateinit var q: LongArray
    private lateinit var lz: LongArray

    private fun app(o: Int, len: Int, k: Long) {
        q[o] += 2 * k * s[o] + k * k * len
        s[o] += k * len
        lz[o] += k
    }

    private fun upd(o: Int, l: Int, r: Int, L: Int, R: Int) {
        if (L <= l && r <= R) {
            app(o, r - l + 1, 1L)
            return
        }

        val m = (l + r) shr 1

        if (lz[o] != 0L) {
            app(2 * o, m - l + 1, lz[o])
            app(2 * o + 1, r - m, lz[o])
            lz[o] = 0L
        }

        if (L <= m) {
            upd(2 * o, l, m, L, R)
        }

        if (R > m) {
            upd(2 * o + 1, m + 1, r, L, R)
        }

        s[o] = s[2 * o] + s[2 * o + 1]
        q[o] = q[2 * o] + q[2 * o + 1]
    }

    fun sumCounts(nums: IntArray): Int {
        val MOD = 1_000_000_007L
        val n = nums.size

        s = LongArray(4 * n)
        q = LongArray(4 * n)
        lz = LongArray(4 * n)

        val last = IntArray(100001) { -1 }
        var ans = 0L

        for (i in nums.indices) {
            upd(1, 0, n - 1, last[nums[i]] + 1, i)
            last[nums[i]] = i
            ans = (ans + q[1]) % MOD
        }

        return ans.toInt()
    }
}
