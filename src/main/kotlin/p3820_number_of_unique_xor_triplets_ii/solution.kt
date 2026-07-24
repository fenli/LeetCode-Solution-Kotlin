package p3820_number_of_unique_xor_triplets_ii

class Solution {
    fun uniqueXorTriplets(nums: IntArray): Int {
        val pair = BooleanArray(2048)
        val triple = BooleanArray(2048)
        val n = nums.size

        for (i in 0 until n) {
            for (j in i until n) {
                pair[nums[i] xor nums[j]] = true
            }
        }

        for (i in 0 until 2048) {
            if (!pair[i]) continue
            for (x in nums) {
                triple[x xor i] = true
            }
        }

        return triple.count { it }
    }
}
