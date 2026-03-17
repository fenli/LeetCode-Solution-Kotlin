/**
 * Problem : https://leetcode.com/problems/move-zeroes/description/
 * Submission : https://leetcode.com/problems/move-zeroes/submissions/1950748309
 */

class Solution283 {
    fun moveZeroes(nums: IntArray): Unit {
        var zero = -1
        for (i in nums.indices) {
            if (nums[i] == 0) {
                if (zero == -1) zero = i
            } else if (zero != -1) {
                nums[zero] = nums[i]
                nums[i] = 0
                zero++
            }
        }
    }
}

fun main() {
    val solution = Solution283()

    val n1 = intArrayOf(0, 1, 0, 3, 12)
    solution.moveZeroes(n1)
    check(n1.contentEquals(intArrayOf(1, 3, 12, 0, 0)))

    val n2 = intArrayOf(0)
    solution.moveZeroes(n2)
    check(n2.contentEquals(intArrayOf(0)))
}
