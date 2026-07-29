package p0643_maximum_average_subarray_i

fun main() {
    val solution = Solution()
    check(solution.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4) == 12.75000)
    check(solution.findMaxAverage(intArrayOf(5), 1) == 5.00000)
}
