package p4147_minimum_cost_to_acquire_required_items

class Solution {
    fun minimumCost(cost1: Int, cost2: Int, costBoth: Int, need1: Int, need2: Int): Long {
        if (cost1 + cost2 > costBoth) {
            val min = minOf(need1, need2)
            var res = min * costBoth.toLong()
            res += if (cost1 < costBoth) {
                (need1 - min) * cost1.toLong()
            } else {
                costBoth.toLong() * (need1 - min)
            }
            res += if (cost2 < costBoth) {
                (need2 - min) * cost2.toLong()
            } else {
                costBoth.toLong() * (need2 - min)
            }
            return res
        } else {
            return cost1.toLong() * need1 + cost2.toLong() * need2
        }
    }
}
