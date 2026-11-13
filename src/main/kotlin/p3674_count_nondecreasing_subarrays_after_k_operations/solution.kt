package p3674_count_nondecreasing_subarrays_after_k_operations

import java.util.ArrayDeque

class Solution {
    fun countNonDecreasingSubarrays(nums: IntArray, k: Int): Long {
        var ans = 0L
        var cost = 0L
        val dq: Deque<IntArray> = ArrayDeque()
        val n = nums.size
        var j = n - 1

        for (i in n - 1 downTo 0) {
            val num = nums[i]
            var count = 1

            while (dq.isNotEmpty() && dq.peekLast()[0] < num) {
                val back = dq.pollLast()
                count += back[1]
                cost += (num - back[0]).toLong() * back[1]
            }

            dq.offerLast(intArrayOf(num, count))

            while (cost > k) {
                val front = dq.pollFirst()
                cost -= (front[0] - nums[j]).toLong()
                --j

                if (front[1] > 1) {
                    dq.offerFirst(intArrayOf(front[0], front[1] - 1))
                }
            }

            ans += (j - i + 1)
        }

        return ans
    }
}
