package p1776_minimum_operations_to_reduce_x_to_zero

class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        val totalSum = nums.sum()
        val target = totalSum - x

        if (target < 0) return -1
        if (target == x) return nums.size

        var left = 0 
        var maxLength = -1
        var sum = 0

        for(right in 0 until nums.size){
            sum += nums[right]
            while (sum > target){
                sum -= nums[left]
                left++
            }

            if (sum == target) maxLength = maxOf(maxLength, right-left+1)
        }
        
        return if (maxLength == -1) -1 else nums.size - maxLength
    }
}
