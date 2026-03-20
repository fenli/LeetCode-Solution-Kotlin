package p2428_equal_row_and_column_pairs

class Solution {
    fun equalPairs(grid: Array<IntArray>): Int {
        val h = hashMapOf<String, Int>()
        val v = hashMapOf<String, Int>()
        var equal = 0
        for (i in 0 until grid.size) {
            var hKey = ""
            var vKey = ""
            for (j in 0 until grid.size) {
                hKey = hKey + grid[i][j].toString() + "_"
                vKey = vKey + grid[j][i].toString() + "_"
            }
            h[hKey] = (h[hKey] ?: 0) + 1
            v[vKey] = (v[vKey] ?: 0) + 1
        }

        for (item in h) {
            if (v.contains(item.key)) {
                equal += h[item.key]!! * v[item.key]!!
            }
        }

        return equal
    }
}
