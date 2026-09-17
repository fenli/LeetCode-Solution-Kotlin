package p1573_find_two_nonoverlapping_subarrays_each_with_target_sum

class Solution {
    fun minSumOfLengths(arr: IntArray, target: Int): Int {
        val pos = mutableMapOf<Int, Int>()
        pos[0] = -1
        val n = arr.size
        var s = 0
        var ans = n + 1
        var minL = n

        for (i in arr.indices) {
            s += arr[i]
            if (pos.containsKey(s - target)) {
                val j = pos[s - target]!!
                val len = i - j
                ans = minOf(ans, len + if (j == -1) n else arr[j])
                minL = minOf(minL, len)
            }
            arr[i] = minL
            pos[s] = i
        }

        return if (ans == n + 1) -1 else ans
    }
}
