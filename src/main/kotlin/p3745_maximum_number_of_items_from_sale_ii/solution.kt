package p3745_maximum_number_of_items_from_sale_ii

class Solution {
    fun maximumSaleItems(items: Array<IntArray>, budget: Int): Int {
        val n = items.size

        var cheapestPrice = items[0][1].toLong()
        for (item in items) {
            cheapestPrice = minOf(cheapestPrice, item[1].toLong())
        }

        val factorCount = IntArray(n + 1)
        for (item in items) {
            factorCount[item[0]]++
        }

        // multipleCount[f] = number of items whose factor is a multiple of f.
        val multipleCount = IntArray(n + 1)
        for (factor in 1..n) {
            var multiple = factor
            while (multiple <= n) {
                multipleCount[factor] += factorCount[multiple]
                multiple += factor
            }
        }

        // Each item contributes one "doubled" slot per free copy it can earn.
        val slots = mutableListOf<Pair<Long, Long>>()
        for (item in items) {
            val price = item[1].toLong()
            if (price >= 2 * cheapestPrice) {
                continue
            }

            val freeCopies = multipleCount[item[0]].toLong() - 1
            if (freeCopies > 0) {
                slots.add(price to freeCopies)
            }
        }
        slots.sortBy { it.first }

        var remaining = budget.toLong()
        var doubledCopies = 0L
        for ((price, available) in slots) {
            val take = minOf(available, remaining / price)

            doubledCopies += take
            remaining -= take * price

            if (remaining < price) {
                break
            }
        }

        return (2 * doubledCopies + remaining / cheapestPrice).toInt()
    }
}
