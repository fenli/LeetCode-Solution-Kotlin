package p0128_longest_consecutive_sequence

fun main() {
    val solution = Solution()
    check(solution.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)) == 4)
    check(solution.longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)) == 9)
    check(solution.longestConsecutive(intArrayOf(1, 0, 1, 2)) == 3)
}
