package p0560_subarray_sum_equals_k

fun main() {
    val solution = Solution()
    check(solution.subarraySum(intArrayOf(1, 1, 1), 2) == 2)
    check(solution.subarraySum(intArrayOf(1, 2, 3), 3) == 2)
}
