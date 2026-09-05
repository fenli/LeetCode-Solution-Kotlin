package p4285_smallest_stable_index_ii

class Solution {
    fun firstStableIndex(nums: IntArray, k: Int): Int {
        val minSuffix = IntArray(nums.size)
        minSuffix[nums.lastIndex] = nums.last()
        for(i in nums.size-2 downTo 0) minSuffix[i] = minOf(minSuffix[i+1], nums[i])

        var max = -1
        for (i in 0 until nums.size) {
            max = maxOf(max, nums[i])
            if (max - minSuffix[i] <= k) return i
        }

        return -1
    }
}
