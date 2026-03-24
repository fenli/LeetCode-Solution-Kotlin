/**
 * Problem : https://leetcode.com/problems/equal-row-and-column-pairs/description/
 * Submission : https://leetcode.com/problems/equal-row-and-column-pairs/submissions/1957834160
 */

class Solution2352 {
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

fun main() {
    val solution = Solution2352()
    check(
        solution.equalPairs(
            arrayOf(
                intArrayOf(3, 2, 1),
                intArrayOf(1, 7, 6),
                intArrayOf(2, 7, 7)
            )
        ) == 1
    )
    check(
        solution.equalPairs(
            arrayOf(
                intArrayOf(3, 1, 2, 2),
                intArrayOf(1, 4, 4, 5),
                intArrayOf(2, 4, 2, 2),
                intArrayOf(2, 4, 2, 2)
            )
        ) == 3
    )
}
