package p0334_increasing_triplet_subsequence

class Solution {
    fun increasingTriplet(nums: IntArray): Boolean {
        if (nums.size < 3) return false

        var firstSmall = -1
        var secondSmall = -1
        for (i in 0 until nums.size) {
            val n = nums[i]
            if (firstSmall == -1 || n < nums[firstSmall]) {
                firstSmall = i
            } else if (n > nums[firstSmall] && (secondSmall == -1 || n < nums[secondSmall])) {
                secondSmall = i
            }

            if (secondSmall != -1 && nums[secondSmall] < n) return true
        }
        return false
    }
}
