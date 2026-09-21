package p3831_find_x_value_of_array_i

class Solution {
    fun resultArray(nums: IntArray, k: Int): LongArray {
        val result = LongArray(k)
        var dp = LongArray(k)

        for(num in nums){
            val rem = num%k
            val next = LongArray(k)
            next[rem]++

            for(r in 0 until k){
                next[(r * rem) % k] += dp[r]
            }

            dp = next

            for( r in 0 until k){
                result[r] += dp[r]
            }
        }

        return result

    }
}
