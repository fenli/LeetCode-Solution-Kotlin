package p0088_merge_sorted_array

fun main() {
    val solution = Solution()

    // Case 1
    val n1 = intArrayOf(1, 2, 3, 0, 0, 0)
    solution.merge(n1, 3, intArrayOf(2, 5, 6), 3)
    check(n1.contentEquals(intArrayOf(1, 2, 2, 3, 5, 6)))

    // Case 2
    val n2 = intArrayOf(1)
    solution.merge(n2, 1, intArrayOf(), 0)
    check(n2.contentEquals(intArrayOf(1)))

    // Case 3
    val n3 = intArrayOf(0)
    solution.merge(n3, 0, intArrayOf(1), 1)
    check(n3.contentEquals(intArrayOf(1)))
}
