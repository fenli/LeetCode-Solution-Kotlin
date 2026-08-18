package p3705_find_the_largest_almost_missing_integer

class Solution {
    fun largestInteger(nums: IntArray, k: Int): Int {
        if (nums.size == k) return nums.maxOf { it }

        var max = -1
        val history = hashMapOf<Int, Int>()
        if (k == 1) {
            // Check item that only appears once
            for (n in nums) history[n] = (history[n] ?: 0) + 1
            for ((key, value) in history) if (value == 1) max = maxOf(max, key)
        } else {
            // k >= 2
            // Only check first and last index
            for (i in 1 until nums.size -1) history[nums[i]] = (history[nums[i]] ?: 0) + 1
            if (nums[0] != nums[nums.size - 1]) {
                if (!history.contains(nums[0])) max = maxOf(max, nums[0])
                if (!history.contains(nums[nums.size - 1])) max = maxOf(max, nums[nums.size - 1])
            }
        }
        
        return max
    }
}
