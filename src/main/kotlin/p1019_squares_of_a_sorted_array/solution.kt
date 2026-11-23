package p1019_squares_of_a_sorted_array

class Solution {
    fun sortedSquares(nums: IntArray): IntArray {
        return nums.map { it * it }.sorted().toIntArray()
    }
}
