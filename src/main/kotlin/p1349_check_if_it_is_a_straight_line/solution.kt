package p1349_check_if_it_is_a_straight_line

class Solution {
    fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
        val deltaX = coordinates[1][0] - coordinates[0][0]
        val deltaY = coordinates[1][1] - coordinates[0][1]
        for (i in 2 until coordinates.size) {
            val dx = coordinates[i][0] - coordinates[i-1][0]
            val dy = coordinates[i][1] - coordinates[i-1][1]
            if (dx * deltaY != dy * deltaX) return false
        }

        return true
    }
}
