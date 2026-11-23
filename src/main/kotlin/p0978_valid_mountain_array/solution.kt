package p0978_valid_mountain_array

class Solution {
    fun validMountainArray(arr: IntArray): Boolean {
        val size = arr.size
        if (size < 3) return false

        // Find the peak index where the array stops increasing
        var peakIndex = -1

        for (i in 0 until size - 1) {
            when {
                arr[i] < arr[i + 1] -> continue
                arr[i] > arr[i + 1] -> {
                    peakIndex = i
                    break
                }
                else -> return false // if equal
            }
        }

        // If no peak found or peak is at first or last index, it's not a mountain
        if (peakIndex <= 0 || peakIndex == size - 1) return false

        // Now validate strictly decreasing part from peak to end
        for (i in peakIndex until size - 1) {
            if (arr[i] <= arr[i + 1]) {
                return false
            }
        }

        return true
    }
}
