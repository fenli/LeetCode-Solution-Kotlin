package p4245_count_commas_in_range

class Solution {
    fun countCommas(n: Int): Int {
        if (n < 1000) return 0
        
        val thousand = n / 1000
        val remain = n % 1000
        return ((thousand - 1) * 1000) + remain + 1
    }
}
