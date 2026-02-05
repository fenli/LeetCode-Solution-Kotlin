package p0560_subarray_sum_equals_k

class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val map = hashMapOf<Int, Int>()
        map[0] = 1
        var subCount = 0
        var prefixSum = 0
        for (n in nums) {
            prefixSum += n
            subCount += map[prefixSum - k] ?: 0
            map[prefixSum] = (map[prefixSum] ?: 0) + 1
        }
        return subCount
    }
}
