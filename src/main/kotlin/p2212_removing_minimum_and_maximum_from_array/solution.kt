package p2212_removing_minimum_and_maximum_from_array

class Solution {

    fun minimumDeletions(nums: IntArray): Int {
        val n = nums.size

        var minIndex = 0
        var maxIndex = 0

        for (i in 0 until n) {
            if (nums[i] < nums[minIndex]) {
                minIndex = i
            }

            if (nums[i] > nums[maxIndex]) {
                maxIndex = i
            }
        }

        val left = minOf(minIndex, maxIndex)
        val right = maxOf(minIndex, maxIndex)

        // Remove both from the front
        val front = right + 1

        // Remove both from the back
        val back = n - left

        // Remove one from each side
        val frontBack = (left + 1) + (n - right)

        return minOf(front, back, frontBack)
    }
}
