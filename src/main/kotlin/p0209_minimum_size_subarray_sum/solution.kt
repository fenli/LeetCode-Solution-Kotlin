package p0209_minimum_size_subarray_sum

import kotlin.math.min

// [2,3,1,2,4,3]
// 2 3 1 2
//   3 1 2 4
//     1 2 4
//       2 4 3
//         4 3
//           3
class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var minLen = Int.MAX_VALUE
        var sums = 0
        var subIndex = 0
        for (i in nums.indices) {
            sums += nums[i]
            if (sums >= target) {

                do { 
                    sums = sums - nums[subIndex]
                    minLen = min(minLen, i - subIndex + 1)
                    subIndex++
                } while(sums >= target)
            }
        }

        return if (minLen == Int.MAX_VALUE) 0 else minLen
    }
}
