package p1570_final_prices_with_a_special_discount_in_a_shop

fun main() {
    val solution = Solution()
    check(solution.finalPrices(intArrayOf(8, 4, 6, 2, 3)).contentEquals(intArrayOf(4, 2, 4, 2, 3)))
    check(solution.finalPrices(intArrayOf(1, 2, 3, 4, 5)).contentEquals(intArrayOf(1, 2, 3, 4, 5)))
    check(solution.finalPrices(intArrayOf(10, 1, 1, 6)).contentEquals(intArrayOf(9, 0, 1, 6)))
}
