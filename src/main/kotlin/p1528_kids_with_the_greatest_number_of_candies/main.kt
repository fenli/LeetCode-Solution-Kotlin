package p1528_kids_with_the_greatest_number_of_candies

fun main() {
    val solution = Solution()
    check(solution.kidsWithCandies(intArrayOf(2, 3, 5, 1, 3), 3) == listOf(true, true, true, false, true))
    check(solution.kidsWithCandies(intArrayOf(4, 2, 1, 1, 2), 1) == listOf(true, false, false, false, false))
    check(solution.kidsWithCandies(intArrayOf(12, 1, 12), 10) == listOf(true, false, true))
}
