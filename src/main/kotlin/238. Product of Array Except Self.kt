/**
 * Problem : https://leetcode.com/problems/product-of-array-except-self/description/
 * Submission : https://leetcode.com/problems/product-of-array-except-self/submissions/1950866113
 */

class Solution238 {
    fun productExceptSelf(nums: IntArray): IntArray {
        val size = nums.size
        val result = IntArray(size)
        val leftProduct = IntArray(size)
        val rightProduct = IntArray(size)

        var pL = 1
        var pR = 1
        for (i in 0 until size) {
            pL *= nums[i]
            leftProduct[i] = pL

            pR *= nums[size - 1 - i]
            rightProduct[size - 1 - i] = pR
        }

        for (i in 0 until size) {
            var p = 1
            if (i > 0) p *= leftProduct[i - 1]
            if (i < size - 1) p *= rightProduct[i + 1]
            result[i] = p
        }

        return result
    }
}

fun main() {
    val solution = Solution238()
    check(solution.productExceptSelf(intArrayOf(1, 2, 3, 4)).contentEquals(intArrayOf(24, 12, 8, 6)))
    check(solution.productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)).contentEquals(intArrayOf(0, 0, 9, 0, 0)))
}
