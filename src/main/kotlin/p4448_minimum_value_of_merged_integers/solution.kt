package p4448_minimum_value_of_merged_integers

class Solution {
    fun minMergedInteger(nums: IntArray): Int {
        var result = Int.MAX_VALUE

        for (i in nums.indices step 2) {
            val first = nums[i]
            val second = nums[i + 1]

            var multiplier = 10
            var temp = second

            while (temp >= 10) {
                multiplier *= 10
                temp /= 10
            }

            val merged = first * multiplier + second
            result = minOf(result, merged)
        }

        return result
    }
}
