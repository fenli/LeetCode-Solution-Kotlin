package p4363_minimum_total_price_after_applying_discounts

class Solution {
    fun minPrice(prices: IntArray, discounts: IntArray): Double {
        prices.sortDescending()
        discounts.sortDescending()

        var total = 0.0
        for (p in prices) total += p.toDouble()

        for (i in 0 until minOf(prices.size, discounts.size)) total -= prices[i].toDouble() * discounts[i].toDouble() / 100.0
        return total
    }
}
