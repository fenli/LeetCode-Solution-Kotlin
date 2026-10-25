package p4449_binary_digit_score

class Solution {
    fun calculateScore(a: Int, b: Int): Int {
        val s1 = Integer.bitCount(a)
        val s2 = Integer.bitCount(b)

        return if (s1 >= s2) {
            s1 * s2
        } else {
            s2 / s1
        }
    }
}
