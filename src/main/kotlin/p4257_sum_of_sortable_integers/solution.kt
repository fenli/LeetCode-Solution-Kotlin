package p4257_sum_of_sortable_integers

class Solution {

    private fun getDivisors(n: Int): List<Int> {
        val divs = mutableListOf<Int>()

        var i = 1
        while (i * i <= n) {
            if (n % i == 0) {
                divs.add(i)
                if (i != n / i) {
                    divs.add(n / i)
                }
            }
            i++
        }

        return divs
    }

    private fun check(nums: IntArray, k: Int): Boolean {
        val n = nums.size
        var last = Int.MIN_VALUE

        for (i in 0 until n step k) {
            var cnt = 0
            var mn = Int.MAX_VALUE
            var mx = Int.MIN_VALUE

            for (j in i until i + k) {
                mn = minOf(mn, nums[j])
                mx = maxOf(mx, nums[j])

                val nxt = if (j == i + k - 1) nums[i] else nums[j + 1]

                if (nums[j] > nxt) {
                    cnt++
                }
            }

            if (cnt > 1 || last > mn) {
                return false
            }

            last = mx
        }

        return true
    }

    fun sortableIntegers(nums: IntArray): Int {
        var ans = 0

        for (k in getDivisors(nums.size)) {
            if (check(nums, k)) {
                ans += k
            }
        }

        return ans
    }
}
