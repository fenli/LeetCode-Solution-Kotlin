package p3950_maximum_k_to_sort_a_permutation

class Solution {
    fun sortPermutation(nums: IntArray): Int {
        var ans = -1
        for (i in 0 until nums.size) {
            if (nums[i] != i) {
                ans = ans and nums[i]
            }
        }
        return if (ans != -1)  ans else 0
    }
}
