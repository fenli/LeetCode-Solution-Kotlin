package p0001_two_sum

fun main() {
    val solution = Solution()
    check(solution.twoSum(intArrayOf(2, 7, 11, 15), 9).contentEquals(intArrayOf(0, 1)))
    check(solution.twoSum(intArrayOf(3, 2, 4), 6).contentEquals(intArrayOf(1, 2)))
    check(solution.twoSum(intArrayOf(3, 3), 6).contentEquals(intArrayOf(0, 1)))
}
