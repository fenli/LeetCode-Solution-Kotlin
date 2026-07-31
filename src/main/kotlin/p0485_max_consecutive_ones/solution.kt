package p0485_max_consecutive_ones

class Solution {
    fun findMaxConsecutiveOnes(nums: IntArray): Int {
        var maxC = 0
        var cons = 0
        for (n in nums) {
            if (n == 1) cons++
            else cons = 0
            maxC = maxOf(cons, maxC)
        }

        return maxC
    }
}
