package p0136_single_number

fun main() {
    val solution = Solution()
    check(solution.singleNumber(intArrayOf(2, 2, 1)) == 1)
    check(solution.singleNumber(intArrayOf(4, 1, 2, 1, 2)) == 4)
    check(solution.singleNumber(intArrayOf(1)) == 1)
}
