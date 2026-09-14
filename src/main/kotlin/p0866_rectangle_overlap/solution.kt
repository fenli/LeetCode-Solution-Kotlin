package p0866_rectangle_overlap

class Solution {
    fun isRectangleOverlap(rec1: IntArray, rec2: IntArray): Boolean {
        val left = maxOf(rec1[0], rec2[0])
        val right = minOf(rec1[2], rec2[2])

        val bottom = maxOf(rec1[1], rec2[1])
        val top = minOf(rec1[3], rec2[3])

        return left < right && bottom < top
    }
}
