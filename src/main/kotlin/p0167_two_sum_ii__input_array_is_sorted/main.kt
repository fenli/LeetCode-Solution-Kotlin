package p0167_two_sum_ii__input_array_is_sorted

fun main() {
    val solution = Solution()
    check(solution.twoSum(intArrayOf(2, 7, 11, 15), 9).contentEquals(intArrayOf(1, 2)))
    check(solution.twoSum(intArrayOf(2, 3, 4), 6).contentEquals(intArrayOf(1, 3)))
    check(solution.twoSum(intArrayOf(-1, 0), -1).contentEquals(intArrayOf(1, 2)))
}
