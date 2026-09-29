package p2349__check_if_there_is_a_valid_parentheses_string_path

class Solution {
    fun hasValidPath(grid: Array<CharArray>): Boolean {
        val rows = grid.size
        val cols = grid[0].size
        if ((rows+cols) and 1 == 0) return false
        
        var prev = Array(cols) { mutableSetOf<Int>() }
        var tek = Array(cols) { mutableSetOf<Int>() }
        tek[0].add(if (grid[0][0]=='(') 1 else -1)
        for (i in 1 until cols) 
            for (n in tek[i-1]) 
                if (n>=0) 
                    if (grid[0][i]=='(') tek[i].add(n+1)
                    else tek[i].add(n-1)
        for (i in 1 until rows) {
            prev =  tek
            tek = Array(cols) { mutableSetOf<Int>() }
            for (n in prev[0]) 
                if (n>=0) 
                    if (grid[i][0]=='(') tek[0].add(n+1)
                    else tek[0].add(n-1)
            for (j in 1 until cols) {
                for (n in prev[j]) 
                    if (n>=0) 
                        if (grid[i][j]=='(') tek[j].add(n+1)
                        else tek[j].add(n-1)
                for (n in tek[j-1]) 
                    if (n>=0) 
                        if (grid[i][j]=='(') tek[j].add(n+1)
                        else tek[j].add(n-1)
            }
        }
        for (n in tek[cols-1]) if (n==0) return true
        return false
    }
}
