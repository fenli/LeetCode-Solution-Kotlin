package p1482_how_many_numbers_are_smaller_than_the_current_number

class Solution {
    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val ans = IntArray(nums.size)
        for (i in 0 until nums.size) {
            var count = 0
            for (j in 0 until nums.size) {
                if (i != j && nums[j] < nums[i]) count++
            }
            ans[i] = count
        }
        
        return ans
    }
}
