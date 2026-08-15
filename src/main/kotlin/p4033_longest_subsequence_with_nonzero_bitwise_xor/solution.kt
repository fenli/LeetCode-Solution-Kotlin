package p4033_longest_subsequence_with_nonzero_bitwise_xor

class Solution {
    fun longestSubsequence(nums: IntArray): Int {
        if (nums.size == 0) return if (nums[0] == 0) 0 else 1

        var sum = 0L
        var allXor = 0L
        for (n in nums) {
            allXor = allXor xor n.toLong()
            sum += n.toLong()
        }

        if (sum == 0L) return 0
        return if (allXor == 0L) nums.size - 1 else nums.size
    }
}
