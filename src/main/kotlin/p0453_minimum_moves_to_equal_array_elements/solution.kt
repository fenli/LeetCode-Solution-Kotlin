package p0453_minimum_moves_to_equal_array_elements

class Solution {
    fun minMoves(nums: IntArray): Int {
        return nums.sum() - nums.size * nums.min()
    }
}
