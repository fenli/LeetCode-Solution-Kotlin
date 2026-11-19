package p2706_minimum_score_by_changing_two_elements

class Solution {
    fun minimizeSum(nums: IntArray): Int {
        if (nums.size==3) return 0
        var min1 = 1_000_000_000
        var min2 = 1_000_000_000
        var min3 = 1_000_000_000
        var max1 = 0
        var max2 = 0
        var max3 = 0
        for (N in nums) {
            if (N>=max1) {
                max3=max2
                max2=max1
                max1=N
            }
            else if (N>=max2) {
                max3=max2
                max2=N
            }
            else if (N>max3) max3=N            
            if (N<=min1) {
                min3=min2
                min2=min1
                min1=N
            }
            else if (N<=min2) {
                min3=min2
                min2=N
            }
            else if (N<min3) min3=N
        }
        return minOf(max1-min3,max3-min1,max2-min2)
    }
}
