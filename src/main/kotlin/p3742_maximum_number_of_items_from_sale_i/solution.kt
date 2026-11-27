package p3742_maximum_number_of_items_from_sale_i

class Solution {
    fun maximumSaleItems(items: Array<IntArray>, budget: Int): Int {
        val maxFactor = 1500

        val factorCount = IntArray(maxFactor + 1)
        for (item in items) {
            factorCount[item[0]]++
        }

        // bonusByFactor[f]: free copies granted by buying an item whose factor is f.
        val bonusByFactor = IntArray(maxFactor + 1) { -1 }
        for (item in items) {
            val factor = item[0]
            if (bonusByFactor[factor] != -1) {
                continue
            }

            var count = 0
            var multiple = factor
            while (multiple <= maxFactor) {
                count += factorCount[multiple]
                multiple += factor
            }
            bonusByFactor[factor] = count - 1
        }

        var cheapestPrice = items[0][1]
        for (item in items) {
            cheapestPrice = minOf(cheapestPrice, item[1])
        }

        // dp[spent] = the most copies the first copy of each chosen item yields
        // (1 bought copy plus all free copies), spending exactly 'spent'.
        // Every further copy is bought from the cheapest item, so the money
        // left over buys (budget - spent) / cheapestPrice more copies.
        val impossible = -1000000000
        val dp = IntArray(budget + 1) { impossible }
        dp[0] = 0

        for (item in items) {
            val price = item[1]
            val firstCopyValue = 1 + bonusByFactor[item[0]]

            for (spent in budget - price downTo 0) {
                if (dp[spent] != impossible) {
                    dp[spent + price] = maxOf(dp[spent + price], dp[spent] + firstCopyValue)
                }
            }
        }

        var answer = 0
        for (spent in 0..budget) {
            if (dp[spent] != impossible) {
                answer = maxOf(answer, dp[spent] + (budget - spent) / cheapestPrice)
            }
        }
        return answer
    }
}
