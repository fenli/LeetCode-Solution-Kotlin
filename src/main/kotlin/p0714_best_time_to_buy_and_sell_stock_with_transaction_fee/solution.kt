package p0714_best_time_to_buy_and_sell_stock_with_transaction_fee

class Solution {
    fun maxProfit(prices: IntArray, fee: Int): Int {
        if (prices.size == 0) return 0

        var totalProfit = 0
        var maxSessionProfit = 0
        var lastSessionProfit = 0
        var buyIndex = 0
        var lastBuyIndex = 0
        for (i in 1 until prices.size) {
            var profit = prices[i] - prices[buyIndex] - fee

            if (buyIndex != lastBuyIndex) {
                val profitWithLastIndex = prices[i] - prices[lastBuyIndex] - fee
                if (profitWithLastIndex > profit + lastSessionProfit) {
                    profit = profitWithLastIndex
                    maxSessionProfit = lastSessionProfit
                    buyIndex = lastBuyIndex
                    totalProfit -= lastSessionProfit
                    lastSessionProfit = 0
                }
            } 
            
            if (profit > maxSessionProfit) {
                maxSessionProfit = profit
                if (i != prices.size - 1) continue
            }
            
            totalProfit += maxSessionProfit
            lastSessionProfit = maxSessionProfit
            lastBuyIndex = buyIndex
            maxSessionProfit = 0
            buyIndex = i
        }
        
        return totalProfit
    }
}
