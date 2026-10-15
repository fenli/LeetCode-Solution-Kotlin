package p3163_subarrays_distinct_element_sum_of_squares_i

class Solution {
    fun sumCounts(nums: List<Int>): Int {
        val len=nums.size
        var rez = len
        for (i in 0 until len) {
            val arr = Array<Boolean>(101) { false }
            arr[nums[i]]=true
            var cou = 1
            for (j in i+1 until len) {
                if (arr[nums[j]]) rez+=cou*cou
                else {
                    arr[nums[j]]=true
                    cou++
                    rez+=cou*cou
                }
            }
        }
        return rez
    }
}
