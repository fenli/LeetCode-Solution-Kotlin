package p4418_number_of_intersecting_interval_pairs_i

class Solution {
    fun countIntersectingIntervals(intervals: Array<IntArray>): Int {
        var count = 0
        val n = intervals.size

        for (i in 0 until n) {
            for (j in i+1 until n) {
                val (s1, e1) = intervals[i]
                val (s2, e2) = intervals[j]

                if (maxOf(s1, s2) <= minOf(e1, e2)) count++
            }    
        }
        
        return count
    }
}
