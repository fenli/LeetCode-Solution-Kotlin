package p4105_smallest_unique_subarray

class Solution {
    fun smallestUniqueSubarray(nums: IntArray): Int {
        val n = nums.size
        var left = 1
        var right = n

        while (left < right) {
            val mid = left + (right - left) / 2

            if (hasUniqueSubarray(nums, mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }

    private fun hasUniqueSubarray(nums: IntArray, length: Int): Boolean {
        val n = nums.size

        if (length > n) {
            return false
        }

        val mod1 = 1_000_000_007L
        val mod2 = 1_000_000_009L
        val base = 9_113_823L

        var power1 = 1L
        var power2 = 1L

        for (i in 0 until length - 1) {
            power1 = power1 * base % mod1
            power2 = power2 * base % mod2
        }

        val frequency = HashMap<Long, Int>()

        var hash1 = 0L
        var hash2 = 0L

        for (i in 0 until length) {
            hash1 = (hash1 * base + nums[i]) % mod1
            hash2 = (hash2 * base + nums[i]) % mod2
        }

        val firstKey = hash1 * mod2 + hash2
        frequency[firstKey] = 1

        for (i in length until n) {
            hash1 = (hash1 - nums[i - length] * power1 % mod1 + mod1) % mod1
            hash1 = (hash1 * base + nums[i]) % mod1

            hash2 = (hash2 - nums[i - length] * power2 % mod2 + mod2) % mod2
            hash2 = (hash2 * base + nums[i]) % mod2

            val key = hash1 * mod2 + hash2
            frequency[key] = (frequency[key] ?: 0) + 1
        }

        for (count in frequency.values) {
            if (count == 1) {
                return true
            }
        }

        return false
    }
}
