package p1018_largest_perimeter_triangle

class Solution {
    fun largestPerimeter(nums: IntArray): Int {
        nums.sort()
        for (i in (nums.size - 3) downTo 0) {
            if (nums[i] + nums[i+1] > nums[i+2]) {
                return nums[i] + nums[i+1] + nums[i+2]
            }
        }
        return 0
    }
}
