package p0435_nonoverlapping_intervals

class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        if (intervals.size == 1) return 0
        var minInterval = 0
        var sorted = intervals.sortedBy { it[1] }
        var lastEnd = sorted[0][1]
        for (i in 1 until sorted.size) {
            if (sorted[i][0] < lastEnd) minInterval++
            else lastEnd = sorted[i][1]
        }

        return minInterval
    }
}
