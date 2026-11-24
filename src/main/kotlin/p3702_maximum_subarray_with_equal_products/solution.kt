package p3702_maximum_subarray_with_equal_products

class Solution {
    fun maxLength(nums: IntArray): Int {
        val n = nums.size
        val maxPossible = 2520 * 10

        var bestLength = 0

        for (left in 0 until n) {
            if (n - left <= bestLength) {
                break
            }

            var product = 1
            var currentGcd = 0
            var currentLcm = 1

            for (right in left until n) {
                product *= nums[right]

                if (product > maxPossible) {
                    break
                }

                currentGcd = gcd(currentGcd, nums[right])
                currentLcm = currentLcm / gcd(currentLcm, nums[right]) * nums[right]

                if (product == currentGcd * currentLcm) {
                    bestLength = maxOf(bestLength, right - left + 1)
                }
            }
        }

        return bestLength
    }

    private fun gcd(a: Int, b: Int): Int {
        return if (b == 0) a else gcd(b, a % b)
    }
}
