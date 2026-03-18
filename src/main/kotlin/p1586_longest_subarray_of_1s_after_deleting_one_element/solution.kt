package p1586_longest_subarray_of_1s_after_deleting_one_element

class Solution {
    fun longestSubarray(nums: IntArray): Int {
        val k = 1
        var maxOne = 0
        var zeros = 0
        var leftP = 0
        for (i in nums.indices) {
            if (nums[i] == 0) zeros++
            
            if (zeros <= k) {
                maxOne = max(maxOne, i - leftP)
            } else {
                while (zeros > k) if (nums[leftP++] == 0) zeros--
            }
        }

        return maxOne
    }
}
