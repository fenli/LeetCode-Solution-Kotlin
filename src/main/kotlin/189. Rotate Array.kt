/**
 * Problem : https://leetcode.com/problems/rotate-array/description/
 * Submission : https://leetcode.com/problems/rotate-array/submissions/2008665981
 */

class Solution189 {
    fun rotate(nums: IntArray, k: Int): Unit {
        val kmod = k % nums.size
        if (kmod == 0) return

        var temp: Int
        for (i in 0 until nums.size - 1) {
            var swapIndex = nums.size - kmod + i
            if (swapIndex > nums.size - 1) swapIndex -= nums.size

            if (swapIndex > i) {
                // Swap with current value
                temp = nums[i]
                nums[i] = nums[swapIndex]
                nums[swapIndex] = temp
            } else {
                // Swap with original value
                while (swapIndex < i) {
                    swapIndex = swapIndex - kmod
                    if (swapIndex < 0) swapIndex += nums.size
                }

                temp = nums[i]
                nums[i] = nums[swapIndex]
                nums[swapIndex] = temp
            }
        }
    }
}

fun main() {
    val solution = Solution189()

    val n1 = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    solution.rotate(n1, 3)
    check(n1.contentEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4)))

    val n2 = intArrayOf(-1, -100, 3, 99)
    solution.rotate(n2, 2)
    check(n2.contentEquals(intArrayOf(3, 99, -1, -100)))
}
