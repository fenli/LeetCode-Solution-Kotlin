package p4444_maximum_product_pair_with_target_sum


class Solution {
    fun maxProductPair(nums: IntArray, target: Int): IntArray {
        var bestProduct = Long.MIN_VALUE
        var result = intArrayOf(-1, -1)

        for (i in nums.indices) {
            for (j in nums.indices) {
                if (i == j) continue
                if (nums[i] <= nums[j]) continue
                if (nums[i] + nums[j] != target) continue

                val product = nums[i].toLong() * nums[j]

                if (product > bestProduct) {
                    bestProduct = product
                    result = intArrayOf(i, j)
                }
            }
        }

        return result
    }
}
