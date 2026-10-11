package p2844_sum_of_squares_of_special_elements_

class Solution {
    fun sumOfSquares(nums: IntArray): Int {
        val n = nums.size
        if (n <= 0) return 0
        var res = 0
        for (i in 1..n) {
            if (n % i == 0) {
                res += nums[i - 1] * nums[i - 1]
            }
        }
        return res
    }
}
