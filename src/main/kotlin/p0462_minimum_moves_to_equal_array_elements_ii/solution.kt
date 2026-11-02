package p0462_minimum_moves_to_equal_array_elements_ii

class Solution {
    fun minMoves2(nums: IntArray): Int {
        nums.sort()
        val mid = nums.size /2 
        var res = 0
        nums.forEach {
            res += Math.abs(nums[mid] - it)
        }
        return res
    }
}
