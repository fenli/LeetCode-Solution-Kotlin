package p0169_majority_element

class Solution {
    fun majorityElement(nums: IntArray): Int {
        val maps = hashMapOf<Int, Int>()
        val minCount: Int = nums.size / 2
        var major = 0
        for (n in nums) {
            maps[n] = (maps[n] ?: 0) + 1
            if ((maps[n] ?: 0) > minCount) {
                major = n
            }
        }

        return major
    }
}
