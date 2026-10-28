package p4205_minimum_xor_path_in_a_grid

class Solution {
    fun minCost(grid: Array<IntArray>): Int {
        val m = grid.size
        val n = grid[0].size
        val MAX_XOR = 1024

        val dp = Array(m) {
            Array(n) { BooleanArray(MAX_XOR) }
        }

        dp[0][0][grid[0][0]] = true

        for (i in 0 until m) {
            for (j in 0 until n) {
                for (x in 0 until MAX_XOR) {
                    if (!dp[i][j][x]) continue

                    if (i + 1 < m) {
                        val nx = x xor grid[i + 1][j]
                        dp[i + 1][j][nx] = true
                    }

                    if (j + 1 < n) {
                        val nx = x xor grid[i][j + 1]
                        dp[i][j + 1][nx] = true
                    }
                }
            }
        }

        for (x in 0 until MAX_XOR) {
            if (dp[m - 1][n - 1][x]) {
                return x
            }
        }

        return 0
    }
}
