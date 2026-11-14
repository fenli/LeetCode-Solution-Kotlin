package p3644_minimum_positive_sum_subarray_

class Solution {
    fun minimumSumSubarray(nums: List<Int>, l: Int, r: Int): Int {
        val minSums = mutableListOf<Int>()

        (l..r).forEach { window ->
            nums.windowed(window).forEach {
                val sum = it.sum()
                if (sum > 0) minSums.add(sum)
            }
        }

        return minSums.minOrNull() ?: -1
    }
}
