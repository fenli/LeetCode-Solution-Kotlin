package p4416_cyclically_shift_rows_and_columns

class Solution {
    fun cyclicShift(n: Int, grid: Array<IntArray>, rowShift: IntArray, colShift: IntArray): Array<IntArray> {
        val n = grid.size
        val ans = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            for (j in 0 until n) {
                val row = (i + colShift[j]) % n
                val col = (j + rowShift[row]) % n
                ans[i][j] = grid[row][col]
            }
        }

        return ans
    }
}
