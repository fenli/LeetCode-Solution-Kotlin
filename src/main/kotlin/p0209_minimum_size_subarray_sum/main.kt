package p0209_minimum_size_subarray_sum

fun main() {
    val solution = Solution()
    check(solution.minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)) == 2)
    check(solution.minSubArrayLen(4, intArrayOf(1, 4, 4)) == 1)
    check(solution.minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)) == 0)
}
