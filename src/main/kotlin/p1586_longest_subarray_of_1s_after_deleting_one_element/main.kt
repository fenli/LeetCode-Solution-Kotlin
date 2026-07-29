package p1586_longest_subarray_of_1s_after_deleting_one_element

fun main() {
    val solution = Solution()
    check(solution.longestSubarray(intArrayOf(1, 1, 0, 1)) == 3)
    check(solution.longestSubarray(intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)) == 5)
    check(solution.longestSubarray(intArrayOf(1, 1, 1)) == 2)
}
