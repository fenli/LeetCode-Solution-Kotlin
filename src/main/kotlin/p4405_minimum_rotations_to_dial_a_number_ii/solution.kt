package p4405_minimum_rotations_to_dial_a_number_ii

class Solution {
    fun minRotations(n: Int, s: String): Int {
        fun cost(a: Int, b: Int): Int {
            val diff = kotlin.math.abs(a - b)
            return minOf(diff, 10 - diff)
        }

        // Cost without reversing any suffix.
        var total = cost(0, s[0] - '0')

        for (i in 1 until n) {
            total += cost(s[i - 1] - '0', s[i] - '0')
        }

        var answer = total
        val last = s[n - 1] - '0'

        // Try reversing every suffix starting at k.
        for (k in 0 until n) {
            val previous = if (k == 0) 0 else s[k - 1] - '0'
            val original = s[k] - '0'

            val candidate =
                total - cost(previous, original) + cost(previous, last)

            answer = minOf(answer, candidate)
        }

        return answer
    }
}
