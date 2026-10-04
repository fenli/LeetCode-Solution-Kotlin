package p4404_minimum_rotations_to_dial_a_number_i

class Solution {
    fun minRotations(s: String): Int {
        var current = 0
        var rotations = 0

        for (ch in s) {
            val target = ch - '0'
            val diff = kotlin.math.abs(target - current)

            rotations += minOf(diff, 10 - diff)
            current = target
        }

        return rotations
    }
}
