package p3153_apply_operations_on_array_to_maximize_sum_of_squares

class Solution {
    fun maxSum(nums: List<Int>, k: Int): Int {
        
    val count = Array<Int>(32){0}
    var res: Long = 0
    var cur: Long = 0
    var mod: Long = 1000000007
    for (a in nums){
        for (i in 0 until 32 step  1){
            if ((a and  (1.shl(i))) != 0){
                count[i]++
            }
        }
    }
    for (j in 0 until k step 1){
        cur = 0
        for (i in 0 until 32 step 1){
            if (count[i] > 0){
                count[i]--
                cur += 1.shl(i)
            }
        }
        res = (res + cur * cur % mod) %mod
    }
    return res.toInt()
    }
}
