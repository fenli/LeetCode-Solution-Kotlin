package p4078_maximum_alternating_sum_of_squares

class Solution {
    fun maxAlternatingSum(nums: IntArray): Long {
        val arr = nums.map { it.toLong() * it }.sortedDescending()
        var center = arr.size / 2
        var isNumsEven = arr.size % 2 == 0
        var res = if(isNumsEven) 0L else arr[center].toLong()
        for(i in 0 until center) {
            res += arr[i]
            if(isNumsEven){
                res -= arr[i + center]
            }else{
                res -= arr[i + center + 1]
            }
        }
        return res
    }
}
