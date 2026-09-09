package p4248_count_commas_in_range_ii

class Solution {
    fun countCommas(n: Long): Long {
        if (n < 1000) return 0
        
        var comas = 0L
        var start = 1000L
        while(start <= n) {
            comas += n - start + 1
            start *=1000
        }

        return comas
    }
}
