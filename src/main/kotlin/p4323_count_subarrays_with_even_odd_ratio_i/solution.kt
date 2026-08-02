package p4323_count_subarrays_with_even_odd_ratio_i

class Solution {
    fun countRatioSubarrays(nums: IntArray, a: Int, b: Int): Int {
        var validSubArrays = 0
        val oddCounter = IntArray(nums.size)
        var odds = 0
        for (i in 0 until nums.size) {
            if (nums[i] % 2 != 0) {
                odds++
                validSubArrays++
            }
            oddCounter[i] = odds
        }

        for (i in 0 until nums.size - 1) {
            for (j in (i + 1) until nums.size) {
                val odds = oddCounter[j] - (if (i > 0) oddCounter[i-1] else 0) 
                val evens = j - i + 1 - odds
                if (evens * b <= odds * a) validSubArrays++
            }
        }
        
        return validSubArrays
    }
}
