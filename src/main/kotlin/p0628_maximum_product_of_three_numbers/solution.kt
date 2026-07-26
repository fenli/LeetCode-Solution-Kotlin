package p0628_maximum_product_of_three_numbers

import kotlin.math.absoluteValue

class Solution {
    fun maximumProduct(nums: IntArray): Int {
        if (nums.size == 3) return nums[0] * nums[1] * nums[2]

        val lastIndex = nums.size - 1
        nums.sort()

        // Top 3
        var max3 = nums[lastIndex] * nums[lastIndex - 1] * nums[lastIndex - 2]

        // Top 1 Positive + Bottom 2 Negative
        if (nums[0] < 0 && nums[1] < 0 && nums[lastIndex] >= 0) {
            max3 = maxOf(max3, nums[0] * nums[1] * nums[lastIndex])
        }

        // Top 3 Negative
        for (i in 0 until nums.size) {
            if (nums[i] >= 0) {
                if (i > 2) max3 = maxOf(max3, nums[i - 3] * nums[i - 2] * nums[i - 1])
                break
            }
        }

        return max3
    }
}
