package p4430_minimum_deletions_to_make_array_sharp

class Solution {
    fun minDeletions(nums: IntArray): Int {
        var deletions = 0
        var previous = -1

        for (num in nums) {
            if (num == previous) {
                deletions++
            } else {
                previous = num
            }
        }

        return deletions
    }
}
