package p1570_final_prices_with_a_special_discount_in_a_shop

class Solution {
    fun finalPrices(prices: IntArray): IntArray {
        if (prices.size == 1) return intArrayOf(prices[0])

        val stackOfIdx = Stack<Int>()
        val result = IntArray(prices.size)

        for (i in 0 until prices.size) {
            if (i == prices.size - 1) {
                result[i] = prices[i]
            } else if (prices[i+1] <= prices[i]) {
                result[i] = prices[i] - prices[i+1]
                while(!stackOfIdx.isEmpty()) {
                    val top = stackOfIdx.peek()
                    if (prices[i+1] <= prices[top]) {
                        result[top] = prices[top] - prices[i+1]
                        stackOfIdx.pop()
                    } else break
                }
            } else {
                stackOfIdx.push(i)
            }
        }

        // Fill empty array
        for (i in stackOfIdx) result[i] = prices[i]

        return result
    }
}
