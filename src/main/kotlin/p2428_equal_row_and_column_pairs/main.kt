package p2428_equal_row_and_column_pairs

fun main() {
    val solution = Solution()
    check(
        solution.equalPairs(
            arrayOf(
                intArrayOf(3, 2, 1),
                intArrayOf(1, 7, 6),
                intArrayOf(2, 7, 7)
            )
        ) == 1
    )
    check(
        solution.equalPairs(
            arrayOf(
                intArrayOf(3, 1, 2, 2),
                intArrayOf(1, 4, 4, 5),
                intArrayOf(2, 4, 2, 2),
                intArrayOf(2, 4, 2, 2)
            )
        ) == 3
    )
}
