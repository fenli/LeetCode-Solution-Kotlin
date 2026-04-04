package p0136_single_number

class Solution {
    fun singleNumber(nums: IntArray): Int {
        var result = nums[0]
        for (i in 1 until nums.size) {
            result = result xor nums[i]
        }

        return result
    }
}
