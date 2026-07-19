package p4369_even_number_of_knight_moves

class Solution {
    fun canReach(start: IntArray, target: IntArray): Boolean {
        val (startX, startY) = start
        val (endX, endY) = target
        // Both moves must even or odd
        if ((startX - endX) % 2 == 0 && (startY - endY) % 2 == 0) return true
        if ((startX - endX) % 2 != 0 && (startY - endY) % 2 != 0) return true
        return false
    }
}
