package p4245_count_commas_in_range

class Solution {
    fun countCommas(n: Int): Int {
        return if (n < 1000) return 0 else n - 999
    }
}
