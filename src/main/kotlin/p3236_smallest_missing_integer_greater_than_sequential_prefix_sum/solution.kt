package p3236_smallest_missing_integer_greater_than_sequential_prefix_sum

class Solution {
    fun missingInteger(nums: IntArray): Int {
        var prefixSum = nums[0]
        val sets = mutableSetOf<Int>()
        sets.add(nums[0])
        var seq = true
        for (j in 1 until nums.size) {
            if (seq && nums[j] == nums[j-1] + 1) prefixSum += nums[j]
            else {
                seq = false
                sets.add(nums[j])
            }
        }

        while (sets.contains(prefixSum)) prefixSum++
        return prefixSum
    }
}
