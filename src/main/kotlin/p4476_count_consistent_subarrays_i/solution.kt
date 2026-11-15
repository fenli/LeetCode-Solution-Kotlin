package p4476_count_consistent_subarrays_i

class Solution {
    fun countConsistent(nums: IntArray): Int {
        val n = nums.size
        val log = IntArray(n + 1)

        for (i in 2..n) {
            log[i] = log[i / 2] + 1
        }

        // Build Sparse Table for range AND.
        val levels = log[n] + 1
        val st = Array(levels) { IntArray(n) }

        for (i in 0 until n) {
            st[0][i] = nums[i]
        }

        for (k in 1 until levels) {
            val len = 1 shl k
            val half = len shr 1

            for (i in 0..n - len) {
                st[k][i] = st[k - 1][i] and
                    st[k - 1][i + half]
            }
        }

        fun rangeAnd(l: Int, r: Int): Int {
            val k = log[r - l + 1]
            return st[k][l] and st[k][r - (1 shl k) + 1]
        }

        // Previous element <= nums[i].
        val prev = IntArray(n) { -1 }
        val stack = IntArray(n)
        var top = 0

        for (i in 0 until n) {
            while (top > 0 && nums[stack[top - 1]] > nums[i]) {
                top--
            }

            if (top > 0) {
                prev[i] = stack[top - 1]
            }

            stack[top++] = i
        }

        // Next element < nums[i].
        val next = IntArray(n) { n }
        top = 0

        for (i in n - 1 downTo 0) {
            while (top > 0 && nums[stack[top - 1]] >= nums[i]) {
                top--
            }

            if (top > 0) {
                next[i] = stack[top - 1]
            }

            stack[top++] = i
        }

        var answer = 0

        for (i in 0 until n) {
            val value = nums[i]

            // Find the leftmost valid starting position.
            var low = prev[i] + 1
            var high = i

            while (low < high) {
                val mid = (low + high) ushr 1

                if (rangeAnd(mid, i) == value) {
                    high = mid
                } else {
                    low = mid + 1
                }
            }

            val leftCount = i - low + 1

            // Find the rightmost valid ending position.
            low = i
            high = next[i] - 1

            while (low < high) {
                val mid = (low + high + 1) ushr 1

                if (rangeAnd(i, mid) == value) {
                    low = mid
                } else {
                    high = mid - 1
                }
            }

            val rightCount = low - i + 1

            answer += leftCount * rightCount
        }

        return answer
    }
}
