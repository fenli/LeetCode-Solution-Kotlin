/**
 * Problem : https://leetcode.com/problems/maximum-average-subarray-i/description/
 * Submission : https://leetcode.com/problems/maximum-average-subarray-i/submissions/1951901957
 */

class Solution643 {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        val kD = k.toDouble()
        var maxAvg: Double? = null
        var windowSize = 0
        var windowSum = 0
        for (i in 0 until nums.size) {
            if (windowSize < k) windowSize++
            windowSum += nums[i]

            if (windowSize == k) {
                windowSum -= if (i - k < 0) 0 else nums[i - k]
                val avg = windowSum / kD
                if (maxAvg == null || avg > maxAvg) maxAvg = avg
            }
        }

        return maxAvg!!
    }
}

fun main() {
    val solution = Solution643()
    check(solution.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4) == 12.75000)
    check(solution.findMaxAverage(intArrayOf(5), 1) == 5.00000)
}
