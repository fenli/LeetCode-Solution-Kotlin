package p0283_move_zeroes

class Solution {
    fun moveZeroes(nums: IntArray): Unit {
        var zero = -1
        for (i in nums.indices) {
            if (nums[i] == 0) {
                if (zero == -1) zero = i
            } else if (zero != -1) {
                nums[zero] = nums[i]
                nums[i] = 0
                zero++
            } 
        }
    }
}

