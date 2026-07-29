package p0026_remove_duplicates_from_sorted_array

fun main() {
    val solution = Solution()
    check(solution.removeDuplicates(intArrayOf(1, 1, 2)) == 2)
    check(solution.removeDuplicates(intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)) == 5)
}
