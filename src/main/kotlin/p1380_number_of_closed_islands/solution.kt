package p1380_number_of_closed_islands

class Solution {
    fun closedIsland(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty()) return 0
        val m = grid.size; val n = grid[0].size

        fun dfs(x: Int, y: Int) {
            if (x < 0 || x >= m || y < 0 || y >= n || grid[x][y] != 0) return
            grid[x][y] = 1
            dfs(x + 1, y)
            dfs(x - 1, y)
            dfs(x, y + 1)
            dfs(x, y - 1)
        }
        
        for (i in 0..m - 1) {
            if (grid[i][0] == 0) dfs(i, 0)
            if (grid[i][n - 1] == 0) dfs(i, n - 1)
        }

        for (i in 0..n - 1) {
            if (grid[0][i] == 0) dfs(0, i)
            if (grid[m - 1][i] == 0) dfs(m - 1, i)
        }
    
        var nums = 0
        for (i in 0..m - 1) {
            for (j in 0..n - 1) {
                if (grid[i][j] == 0) {
                    dfs(i, j)
                    nums++
                }
            }
        }
        return nums
    }
}
