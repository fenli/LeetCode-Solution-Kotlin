package p4412_count_good_cyclic_rotations

class Solution {
    fun countGoodRotations(nums: IntArray): Int {
        val n = nums.size
        var cycle = 0
        var sumFirst = 0L
        var sumLast = 0L
        var mid = n/2
        for (i in 0 until n) {
            if (i < mid) sumFirst += nums[i].toLong()
            else sumLast += nums[i].toLong()
        }
        
        for (i in 0 until n) {
            if (sumFirst > sumLast) cycle++

            sumFirst += (nums[mid] - nums[i]).toLong()
            sumLast += (nums[i] - nums[mid]).toLong()

            mid = (mid+1)%n
        }
        
        return cycle
    }
}
