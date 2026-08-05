package p0073_set_matrix_zeroes

class Solution {
    fun setZeroes(matrix: Array<IntArray>): Unit {
        var firstRowZero = false
        var firstColZero = false
        for (m in matrix.indices) {
            for (n in matrix[m].indices) {
                if (matrix[m][n] == 0) {
                    if (m == 0) firstRowZero = true
                    if (n == 0) firstColZero = true
                    matrix[0][n] = 0
                    matrix[m][0] = 0
                }
            }
        }

        for (m in 1 until matrix.size) {
            for (n in 1 until matrix[m].size) {
                if (matrix[m][0] == 0 || matrix[0][n] == 0) {
                    matrix[m][n] = 0
                }
            }
        }

        if (firstRowZero) for (i in matrix[0].indices) matrix[0][i] = 0
        if (firstColZero) for (i in matrix.indices) matrix[i][0] = 0
    }
}
