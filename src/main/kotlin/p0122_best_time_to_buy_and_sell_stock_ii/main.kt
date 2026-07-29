package p0122_best_time_to_buy_and_sell_stock_ii

fun main() {
    val solution = Solution()
    check(solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)) == 7)
    check(solution.maxProfit(intArrayOf(1, 2, 3, 4, 5)) == 4)
    check(solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)) == 0)
}
