/**
 * Problem : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/
 * Submission : https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/submissions/2056595737
 */

class Solution122 {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size == 0) return 0

        var totalProfit = 0
        var maxSessionProfit = 0
        var buyIndex = 0
        for (i in 1 until prices.size) {
            val profit = prices[i] - prices[buyIndex]
            if (profit > maxSessionProfit) {
                maxSessionProfit = profit

                if (prices[i] < prices[buyIndex]) buyIndex = i
            } else {
                totalProfit += maxSessionProfit
                maxSessionProfit = 0
                buyIndex = i
            }
        }

        totalProfit += maxSessionProfit
        return totalProfit
    }
}

fun main() {
    val solution = Solution122()
    check(solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)) == 7)
    check(solution.maxProfit(intArrayOf(1, 2, 3, 4, 5)) == 4)
    check(solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)) == 0)
}
