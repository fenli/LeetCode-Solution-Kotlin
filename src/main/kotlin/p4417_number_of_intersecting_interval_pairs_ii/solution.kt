package p4417_number_of_intersecting_interval_pairs_ii

class Solution {
    fun countIntersectingIntervals(intervals: Array<IntArray>): Long {
        val n = intervals.size
        val total = n.toLong() * (n-1)/2

        val starts = IntArray(n) { intervals[it][0]}.apply { sort() }
        var nip = 0L

        for (interval in intervals) {
            var left = 0
            var right = n
            while(left < right) {
                val mid = left + (right - left) / 2
                if (starts[mid] <= interval[1]) left = mid + 1 else right = mid
            }

            nip += (n - left)
        }
        
        return total - nip
    }
}
