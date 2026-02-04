/**
 * Problem : https://leetcode.com/problems/two-sum/
 * Submission : https://leetcode.com/problems/two-sum/submissions/1907748443
 */

class Solution1 {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val out = IntArray(2)
        val store = hashMapOf<Int, Int>()

        for (i in 0 until nums.size) {
            val diff = target - nums[i]
            if (store[diff] != null) {
                out[0] = store[diff]!!
                out[1] = i
                break
            } else store[nums[i]] = i
        }

        return out
    }
}

fun main() {
    val solution = Solution1()
    check(solution.twoSum(intArrayOf(2, 7, 11, 15), 9).contentEquals(intArrayOf(0, 1)))
    check(solution.twoSum(intArrayOf(3, 2, 4), 6).contentEquals(intArrayOf(1, 2)))
    check(solution.twoSum(intArrayOf(3, 3), 6).contentEquals(intArrayOf(0, 1)))
}
