package p3372_longest_strictly_increasing_or_strictly_decreasing_subarray

class Solution {
    fun longestMonotonicSubarray(nums: IntArray): Int {
        if (nums.hasSingle()) return 1

        var maxLen = 0
        var increasing = 1
        var decreasing = 1

        nums.drop(1).forEachIndexed { index, num -> 

        when {
            num > nums[index] -> {
                increasing++
                decreasing = 1
            }
            num < nums[index] -> {
                decreasing++
                increasing = 1
            }
            else -> {
                increasing = 1
                decreasing = 1
            }
        }
        maxLen = maxOf(maxLen, increasing, decreasing)

        }
        return maxLen
    }

    private fun IntArray.hasSingle(): Boolean = when {
        this.size == 1 -> true
        else -> false
    }
}
