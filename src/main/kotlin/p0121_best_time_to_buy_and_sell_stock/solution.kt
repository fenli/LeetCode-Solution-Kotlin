package p0121_best_time_to_buy_and_sell_stock

class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) return 0
        var maxProfit = 0
        var buyIndex = 0
        for (i in 1 until prices.size) {
            val profit = prices[i] - prices[buyIndex]
            if (profit > maxProfit) {
                maxProfit = profit
            }

            if (prices[i] < prices[buyIndex]) {
                buyIndex = i
            }
        }
        
        return maxProfit
    }

    // Time Limit Exceeded
    // fun maxProfit(prices: IntArray): Int {
    //     if (prices.size <= 1) return 0
    //     var profit = 0
    //     for (i in 0 until prices.size - 1) {
    //         for (j in i+1 until prices.size) {
    //             val profitD = prices[j] - prices[i]
    //             if (profitD > profit) profit = profitD
    //         }
    //     }
    //     return profit
    // }
}
