package p0414_third_maximum_number

class Solution {
    fun thirdMax(nums: IntArray): Int {
        var first: Int? = null
        var second: Int? = null
        var third: Int? = null

        for (i in nums.indices) {
            val n = nums[i]
            if (first == null || n > first) {
                third = second
                second = first
                first = n
            } else if ((second == null || n > second) && (first != null && n < first)) {
                third = second
                second = n
            } else if ((third == null || n > third) && (second != null && n < second)) {
                third = n
            }
            // println("$first - $second - $third")
        }
        
        third?.let { return it }
        return first!!
    }
}

