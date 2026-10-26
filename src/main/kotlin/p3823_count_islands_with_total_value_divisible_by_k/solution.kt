package p3823_count_islands_with_total_value_divisible_by_k

class Solution {
    fun countIslands(grid: Array<IntArray>, k: Int): Int {
        val n = grid.size
        val m = grid[0].size
        
        fun dfs(i: Int, j: Int): Long {
            if (i < 0 || i >= n || j < 0 || j >= m || grid[i][j] == 0) return 0
            val result = grid[i][j].toLong()
            grid[i][j] = 0
            return result + dfs(i - 1, j) + dfs(i + 1, j) + dfs(i, j - 1) + dfs(i, j + 1)
        }
        
        var ans = 0
        for (i in 0..<n) {
            for (j in 0..<m) {
                if (grid[i][j] != 0) {
                    val result = dfs(i, j)
                    if (result % k == 0L) ans++
                }
            }
        }
        return ans
    }
}
