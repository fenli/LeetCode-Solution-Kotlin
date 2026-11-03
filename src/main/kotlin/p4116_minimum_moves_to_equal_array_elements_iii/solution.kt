package p4116_minimum_moves_to_equal_array_elements_iii

class Solution {
    fun minMoves(nums: IntArray): Int {
        var sum = 0
        var maxNum = 0
        nums.forEach {
            sum += it
            maxNum = maxOf(it, maxNum)
        }
        return nums.size * maxNum - sum
    }
}
