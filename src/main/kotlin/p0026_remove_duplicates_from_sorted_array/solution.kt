package p0026_remove_duplicates_from_sorted_array

class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var p = 0
        var last = 0
        for (i in 0 until nums.size) {
            val n = nums[i]
            if (i > 0 && n > last) {
                nums[++p] = n
            }
            last = n
        }

        return p + 1
    }
}
