package p4311_maximize_sum_after_at_most_k_digit_rearrangements

class Solution {
    fun maximizeSum(nums: IntArray, k: Int): Long {
        val gains = nums.map { num ->
            val rearranged = num.toString()
                .toCharArray()
                .sortedDescending()
                .joinToString("")
                .toLong()

            rearranged - num
        }

        return nums.sumOf { it.toLong() } +
            gains.sortedDescending()
                .take(k)
                .filter { it > 0 }
                .sum()
    }
}
