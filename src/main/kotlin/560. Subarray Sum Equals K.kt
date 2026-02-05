/**
 * Problem : https://leetcode.com/problems/subarray-sum-equals-k/description/
 * Submission : https://leetcode.com/problems/subarray-sum-equals-k/submissions/1909026473
 */

class Solution560 {
    fun subarraySum(nums: IntArray, k: Int): Int {
        val map = hashMapOf<Int, Int>()
        map[0] = 1
        var subCount = 0
        var prefixSum = 0
        for (n in nums) {
            prefixSum += n
            subCount += map[prefixSum - k] ?: 0
            map[prefixSum] = (map[prefixSum] ?: 0) + 1
        }
        return subCount
    }
}

fun main() {
    val solution = Solution560()
    check(solution.subarraySum(intArrayOf(1, 1, 1), 2) == 2)
    check(solution.subarraySum(intArrayOf(1, 2, 3), 3) == 2)
}
