package p4284_smallest_stable_index_i

class Solution {
    fun firstStableIndex(nums: IntArray, k: Int): Int {
        var max = -1
        for (i in 0 until nums.size) {
            max = maxOf(max, nums[i])
            var min = Int.MAX_VALUE
            for (j in i until nums.size) min = minOf(min, nums[j])
            if (max - min <= k) return i
        }

        return -1
    }
}
