package p0452_minimum_number_of_arrows_to_burst_balloons

class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if (points.size == 1) return 1
        var minArrow = points.size
        var sorted = points.sortedBy { it[1] }
        var lastXend = sorted[0][1]
        for (i in 1 until sorted.size) {
            if (sorted[i][0] <= lastXend) minArrow--
            else lastXend = sorted[i][1]
        }

        return minArrow
    }
}
