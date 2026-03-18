/**
 * Problem : https://leetcode.com/problems/find-pivot-index/description/
 * Submission : https://leetcode.com/problems/find-pivot-index/submissions/1952192940
 */

class Solution724 {
    fun pivotIndex(nums: IntArray): Int {
        if (nums.size == 1) return 0

        // RightSum
        val rightSumArr = IntArray(nums.size)
        var rightSum = 0
        for (i in (nums.size - 1) downTo 0) {
            rightSum += nums[i]
            rightSumArr[i] = rightSum
        }

        // LeftSum
        var leftSum = 0
        for (i in 0 until nums.size) {
            rightSum = if (i == nums.size - 1) 0 else rightSumArr[i + 1]
            if (leftSum == rightSum) return i
            leftSum += nums[i]
        }

        return -1
    }
}

fun main() {
    val solution = Solution724()
    check(solution.pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)) == 3)
    check(solution.pivotIndex(intArrayOf(1, 2, 3)) == -1)
    check(solution.pivotIndex(intArrayOf(2, 1, -1)) == 0)
}
