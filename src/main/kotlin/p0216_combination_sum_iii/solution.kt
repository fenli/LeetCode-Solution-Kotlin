package p0216_combination_sum_iii

class Solution {
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        fun fn(l: MutableList<Int>, sum: Int) {
            if (sum > n) return
            if (l.size > k) return

            if (l.size == k && sum == n) {
                result.add(l.toList())
            } else {
                val start = (l.lastOrNull() ?: 0) + 1
                for (i in start..9) {
                    l.add(i)
                    fn(l, sum + i)
                    l.removeLast()
                }
            }
        }

        fn(mutableListOf(), 0)
        return result
    }
}
