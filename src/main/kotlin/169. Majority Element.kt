/**
 * Problem : https://leetcode.com/problems/majority-element/description/
 * Submission : https://leetcode.com/problems/majority-element/submissions/1943842481
 */

class Solution169 {
    fun majorityElement(nums: IntArray): Int {
        val maps = hashMapOf<Int, Int>()
        val minCount: Int = nums.size / 2
        var major = 0
        for (n in nums) {
            maps[n] = (maps[n] ?: 0) + 1
            if ((maps[n] ?: 0) > minCount) {
                major = n
            }
        }

        return major
    }
}

fun main() {
    val solution = Solution169()
    check(solution.majorityElement(intArrayOf(3, 2, 3)) == 3)
    check(solution.majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)) == 2)
}
