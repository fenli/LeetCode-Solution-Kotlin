package p0724_find_pivot_index

fun main() {
    val solution = Solution()
    check(solution.pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)) == 3)
    check(solution.pivotIndex(intArrayOf(1, 2, 3)) == -1)
    check(solution.pivotIndex(intArrayOf(2, 1, -1)) == 0)
}
