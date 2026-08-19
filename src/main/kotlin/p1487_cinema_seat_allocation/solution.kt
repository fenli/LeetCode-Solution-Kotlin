package p1487_cinema_seat_allocation

class Solution {
    fun maxNumberOfFamilies(n: Int, reservedSeats: Array<IntArray>): Int {
        val blocks = mutableMapOf<Int, Array<Boolean>>()
        for ((row, seat) in reservedSeats) {
            val block = blocks[row] ?: Array<Boolean>(3) { true }
            if (seat in 2..5) block[0] = false
            if (seat in 4..7) block[1] = false
            if (seat in 6..9) block[2] = false
            blocks[row] = block
        }

        var maxGroup = 2 * (n - blocks.size)
        for ((left, mid, right) in blocks.values) {
            if (left && mid && right) maxGroup++
            if (left || mid || right) maxGroup++
        }

        return maxGroup
    }
}
