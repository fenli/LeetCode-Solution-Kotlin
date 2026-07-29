package p1798_max_number_of_ksum_pairs

fun main() {
    val solution = Solution()
    check(solution.maxOperations(intArrayOf(1, 2, 3, 4), 5) == 2)
    check(solution.maxOperations(intArrayOf(3, 1, 3, 4, 3), 6) == 1)
}
