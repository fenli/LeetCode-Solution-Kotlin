/**
 * Problem : https://leetcode.com/problems/summary-ranges/description/
 * Submission : https://leetcode.com/problems/summary-ranges/submissions/1945749029
 */

class Solution228 {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.size == 0) return emptyList<String>()
        if (nums.size == 1) return listOf(nums[0].toString())

        val result = mutableListOf<String>()
        var startIndex = 0
        for (i in 1 until nums.size + 1) {
            if (i == nums.size || nums[i] != nums[i - 1] + 1) {
                if (i == startIndex + 1) {
                    result.add(nums[startIndex].toString())
                } else {
                    result.add("${nums[startIndex].toString()}->${nums[i - 1].toString()}")
                }
                startIndex = i
            }
        }

        return result
    }
}

fun main() {
    val solution = Solution228()
    check(solution.summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)) == listOf("0->2", "4->5", "7"))
    check(solution.summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9)) == listOf("0", "2->4", "6", "8->9"))
}
