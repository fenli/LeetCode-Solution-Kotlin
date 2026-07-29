package p0121_best_time_to_buy_and_sell_stock

fun main() {
    val solution = Solution()
    check(solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)) == 5)
    check(solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)) == 0)
}
