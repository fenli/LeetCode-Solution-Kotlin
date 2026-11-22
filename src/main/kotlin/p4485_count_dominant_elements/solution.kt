package p4485_count_dominant_elements

class Solution {
    fun countDominantElements(nums: IntArray): Int {
        val n = nums.size
        if (n == 1) return 1

        var count = 0

        for (i in nums.indices) {
            val dominant = when (i) {
                0 -> nums[i] >= nums[i + 1]
                n - 1 -> nums[i] >= nums[i - 1]
                else -> 2L * nums[i] >= nums[i - 1].toLong() + nums[i + 1]
            }

            if (dominant) count++
        }

        return count
    }
}

