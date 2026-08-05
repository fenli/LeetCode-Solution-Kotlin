package p1630_count_odd_numbers_in_an_interval_range

class Solution {
    fun countOdds(low: Int, high: Int): Int {
        val n = high - low + 1
        return if (n % 2 == 0) n / 2
        else if (high % 2 == 0 && low % 2 == 0) n / 2
        else n / 2 + 1
    }
}
