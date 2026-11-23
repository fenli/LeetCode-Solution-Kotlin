package p1137_height_checker

class Solution {
    fun heightChecker(nums: IntArray): Int {
        val sorted = nums.sorted().toIntArray()
        var result = 0
        for (i in nums.indices) {
            if (nums[i] != sorted[i]) {
                result ++
            }
        }
        return result
    }
}
