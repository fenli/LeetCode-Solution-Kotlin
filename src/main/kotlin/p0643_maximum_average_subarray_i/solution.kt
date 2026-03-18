package p0643_maximum_average_subarray_i

class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        val kD = k.toDouble()
        var maxAvg: Double? = null
        var windowSize = 0
        var windowSum = 0
        for (i in 0 until nums.size) {
            if (windowSize < k) windowSize++
            windowSum += nums[i]

            if (windowSize == k) {
                windowSum -= if (i-k < 0) 0 else nums[i-k]
                val avg = windowSum / kD
                if (maxAvg == null || avg > maxAvg) maxAvg = avg
            }
        }

        return maxAvg!!
    }
}
