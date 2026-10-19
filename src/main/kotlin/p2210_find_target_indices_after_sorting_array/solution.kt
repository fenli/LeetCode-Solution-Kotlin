package p2210_find_target_indices_after_sorting_array

class Solution {
    fun targetIndices(nums: IntArray, target: Int): List<Int> {
        var cntLess = 0
        var cntTarget = 0
        for (num in nums) {
            if (num < target) {
                cntLess++
            } else if (num == target) {
                cntTarget++
            }
        }
        
        return List(cntTarget) { cntLess + it }
    }
}
