package p0189_rotate_array

class Solution {
    fun rotate(nums: IntArray, k: Int): Unit {
        val kmod = k % nums.size
        if (kmod == 0) return

        var temp: Int
        for (i in 0 until nums.size - 1) {
            var swapIndex = nums.size - kmod + i
            if (swapIndex > nums.size - 1) swapIndex -= nums.size

            if (swapIndex > i) {
                // Swap with current value
                temp = nums[i]
                nums[i] = nums[swapIndex]
                nums[swapIndex] = temp
            } else {
                // Swap with original value
                while (swapIndex < i) {
                    swapIndex = swapIndex - kmod
                    if (swapIndex < 0) swapIndex += nums.size
                }
                
                temp = nums[i]
                nums[i] = nums[swapIndex]
                nums[swapIndex] = temp
            }
        }
    }
}

