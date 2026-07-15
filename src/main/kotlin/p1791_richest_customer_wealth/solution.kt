package p1791_richest_customer_wealth

class Solution {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        var richest = 0
        for (m in accounts.indices) {
            var wealth = 0
            for (n in accounts[m].indices) {
                wealth += accounts[m][n]
            }
            if (wealth > richest) richest = wealth
        }

        return richest
    }
}
