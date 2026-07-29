package p0080_remove_duplicates_from_sorted_array_ii

fun main() {
    val solution = Solution()
    check(solution.removeDuplicates(intArrayOf(1, 1, 1, 2, 2, 3)) == 5)
    check(solution.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)) == 7)
}
